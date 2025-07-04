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

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

cd "$SCRIPT_DIR" || exit 1

TEST_SCRIPT=$(find "$SCRIPT_DIR" -type f -name "test.sh" | head -n 1)

if [[ -z "$TEST_SCRIPT" ]]; then
  echo "No test.sh found in $SCRIPT_DIR or subdirectories"
  exit 1
fi

bash "$TEST_SCRIPT"
EXIT_CODE=$?

echo ""
echo "test exited with code $EXIT_CODE"
echo ""

exit $EXIT_CODE

