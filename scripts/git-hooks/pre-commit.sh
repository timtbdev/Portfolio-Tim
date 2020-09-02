#!/bin/sh
echo "Running static analysis..."

./gradlew detekt ktlintCheck lintDevDebug spotlessKotlinCheck --daemon
status=$?
if [ "$status" = 0 ]; then
    echo "*********************************************"
    echo "      Static analysis no problems found      "
    echo "*********************************************"
    exit 0
else
    echo "*********************************************"
    echo "            Static Analysis Failed           "
    echo "Please fix the above issues before committing"
    echo "*********************************************"
    exit 1
fi
