 # PSE - Periodic System of Elements (Learn and Information Application)
 # Copyright (C) 2025 Jim Feser
 #
 # This program is free software: you can redistribute it and/or modify
 # it under the terms of the GNU Affero General Public License as published by
 # the Free Software Foundation, either version 3 of the License, or
 # (at your option) any later version.
 #
 # This program is distributed in the hope that it will be useful,
 # but WITHOUT ANY WARRANTY; without even the implied warranty of
 # MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 # GNU Affero General Public License for more details.
 #
 # You should have received a copy of the GNU Affero General Public License
 # along with this program.  If not, see <https://www.gnu.org/licenses/>.
 #
 # Contact:
 #  Github: https://github.com/jimfeserHTW
 #
 # If this program interacts with users remotely through a computer network,
 # it must provide a way for users to get its source code, for example by
 # offering a “Source” link in the user interface (see section 13 of the AGPL).


#!/bin/bash
set -e

JUNIT="lib/junit-4.13.2.jar"
HAMCREST="lib/hamcrest-core-1.3.jar"
BIN_DIR="bin"

# Erstelle das bin-Verzeichnis falls nicht vorhanden
mkdir -p $BIN_DIR

# Kompiliere alle Java-Dateien aus src (inkl. Unterordner)
javac -d $BIN_DIR -cp "$BIN_DIR:$JUNIT:$HAMCREST" $(find src -name "*.java")

echo "Compilation success."

# Starte die Tests mit JUnit (Annahme: Testklasse ist test.PSETest)
java -cp "$BIN_DIR:$JUNIT:$HAMCREST" org.junit.runner.JUnitCore test.PSETest > test_output.txt 2>&1

total=0
passed=0
failed=0

if grep -q "Tests run:" test_output.txt; then
    result_line=$(grep "Tests run:" test_output.txt)
    total=$(echo "$result_line" | awk '{gsub(/[^0-9]/, "", $3); print $3}')
    failed=$(echo "$result_line" | awk '{gsub(/[^0-9]/, "", $5); print $5}')
    passed=$((total - failed))
else
    ok_line=$(grep "OK (" test_output.txt)
    passed=$(echo "$ok_line" | awk '/OK \([0-9]+ test[s]*\)/{match($0, /[0-9]+/); print substr($0, RSTART, RLENGTH)}')
    total=$passed
    failed=0
fi

echo ""
echo "Only assertEquals is reported! (May encounter errors)"
echo ""

if [ "$failed" -ne 0 ]; then
    echo -e "\n\033[1;31mFailed Tests:\033[0m"
    
    awk '
        BEGIN { show = 0 }
        /^[0-9]+\)/ { testname = $0; show = 1; next }
        /expected:.*but was:/ && show {
            expected = actual = ""
            line = $0

            # expected extrahieren
            match(line, /expected:<[^>]*>/)
            if (RSTART > 0) {
                expected = substr(line, RSTART + 10, RLENGTH - 11)
            }

            # actual extrahieren
            match(line, /but was:<[^>]*>/)
            if (RSTART > 0) {
                actual = substr(line, RSTART + 9, RLENGTH - 10)
            }

            print "\033[1m" testname "\033[0m"
            print "  \033[1;33mExpected:\033[0m " expected
            print "  \033[1;31mActual:\033[0m   " actual "\n"

            show = 0
        }
    ' test_output.txt

fi

printf "\033[1;34m Total Tests:\033[0m \033[1m%s\033[0m   \033[1;32m Passed:\033[0m \033[1m%s\033[0m   \033[1;31m Failed:\033[0m \033[1m%s\033[0m\n" "$total" "$passed" "$failed"

rm test_output.txt

if [ "$failed" -ne 0 ]; then
    exit 1
fi

exit 0
