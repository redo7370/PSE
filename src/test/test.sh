#!/bin/bash

JUNIT="lib/junit-4.13.2.jar"
HAMCREST="lib/hamcrest-core-1.3.jar"

javac -d bin -cp "bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" src/test/PSETest.java src/**/*.java
if [ $? -ne 0 ]; then
    echo "Kompilierung fehlgeschlagen"
    exit 1
fi

java -cp "bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore test.PSETest > test_output.txt

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
echo "Only assertEquals is reported! (May encounter errors when working with non-alphanumeric comparisons)"
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

exit 0