#!/bin/bash

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

cd "$SCRIPT_DIR" || exit 1

TEST_SCRIPT=$(find "$SCRIPT_DIR" -type f -name "test.sh" | head -n 1)

if [[ -z "$TEST_SCRIPT" ]]; then
  echo "No instance of $SCRIPT_DIR found in this directory or its subdirectorys"
  exit 1
fi

bash "$TEST_SCRIPT"
