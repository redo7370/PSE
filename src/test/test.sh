#!/bin/bash

JUNIT="test/junit-4.13.2.jar"
HAMCREST="test/hamcrest-core-1.3.jar"

javac -cp ".:$JUNIT:$HAMCREST" src/*.java lib/*.java test/PSETest.java
if [ $? -ne 0 ]; then
    echo "❌ Kompilierung fehlgeschlagen"
    exit 1
fi

java -cp ".:$JUNIT:$HAMCREST" org.junit.runner.JUnitCore PSETest > test_output.txt

if grep -q "OK (" test_output.txt; then
    # Beispiel: "OK (5 tests)" → Zahl mit sed extrahieren
    total=$(sed -n 's/OK (\([0-9]\+\) tests)/\1/p' test_output.txt)
    passed=$total
    failed=0
else
    # Beispiel: "Tests run: 5,  Failures: 2"
    total=$(sed -n 's/Tests run: \([0-9]\+\),.*/\1/p' test_output.txt)
    failed=$(sed -n 's/.*Failures: \([0-9]\+\).*/\1/p' test_output.txt)
    passed=$((total - failed))
fi

echo "✅ Tests insgesamt: $total"
echo "✅ Bestanden: $passed"
echo "❌ Fehlgeschlagen: $failed"