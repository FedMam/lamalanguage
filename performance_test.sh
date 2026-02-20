#!/bin/bash

if [[ ! -f lama ]]; then
	echo "Error: please build the project first."
	exit -1
fi

measure_time() {
    START=$(date +%s%N)
    eval "$1"
    END=$(date +%s%N)
    ELAPSED=$(echo "scale=9; $END - $START" | bc)
    ELAPSED_SEC=$(echo "scale=9; $ELAPSED / 1000000000" | bc | sed "s/^\./0\./")
    echo "$ELAPSED_SEC s"
}

LAMA_FILE="language/performance/Sort.lama"
BC_FILE="language/performance/Sort.bc"
INPUT="0"

# Performance verifier & performance interpreter
echo $INPUT | ./interpreter/interpreter $BC_FILE -t 2>&1 1> /dev/null

# Performance onterpreter
echo $INPUT | ./interpreter/onterpreter $BC_FILE -t 2>&1 1> /dev/null

echo -n "Performance lamac -i:    "
measure_time "echo $INPUT | lamac -i $LAMA_FILE > /dev/null 2>&1"

echo -n "Performance lamac -s:    "
measure_time "echo $INPUT | lamac -s $LAMA_FILE > /dev/null 2>&1"

echo -n "Performance G&T Lama:    "
measure_time "echo $INPUT | ./lama $LAMA_FILE > /dev/null 2>&1"

