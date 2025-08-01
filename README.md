# PSE – Periodic System of Elements

PSE is a graphical application designed to visualize the periodic table of elements, provide scientific details about each element, and (in the future) support learning through interactive exercises.

## Features

- Visual Periodic Table – Intuitive, clear layout of all chemical elements.
- Element Information – View atomic number, weight, electron configuration, melting/boiling points, oxidation states, and more.
- Foundation for Learning Mode – Upcoming feature for interactive practice (currently in development).
- Multilingual Support – Built-in internationalization for German and English element names and categories.

## Getting Started

You can run PSE in two ways:

### 1. Native macOS App (recommended)

The application is released as a `.dmg` installer for macOS:
- Intel (`x86_64`)
- Apple Silicon (`aarch64`)

Each release includes the necessary Temurin JDK 21 – no Java installation required.

**Download:** See the [Releases section](https://github.com/jimfeserHTW/PSE/releases)

### 2. Run from Source (Java)

#### Requirements

- Java 21 (e.g. Adoptium Temurin JDK 21)
- Gradle (wrapper included)

#### Build & Run

```bash
# Build the project
./gradlew build

# Run the application
./gradlew run

# Run tests
./gradlew test
```

## Project Structure

This project uses Gradle as the build system. Main directories include:

- `app/src/main/java/` – Java source code organized by packages
  - `start/` – Application entry point
  - `ui/` – User interface components
  - `data/` – Data models and periodic table data
  - `interfaces/` – Interface definitions
  - `services/` – Business logic and event handlers
  - `util/` – Utility classes
- `app/src/main/resources/` – Fonts, icons, and other resources
- `app/src/test/java/` – Unit tests
- `app/build/` – Compiled classes and build artifacts
- `lib/` – External dependencies (JUnit, SQLite JDBC)
- `gradle/` – Gradle wrapper and version catalog
- `LICENSES/` – Third-party license files

## License

This project is licensed under the [GNU Affero General Public License v3.0 (AGPL-3.0)](https://www.gnu.org/licenses/agpl-3.0.en.html).

```
PSE - Periodic System of Elements (Learn and Information Application)
Copyright (C) 2025 Jim Feser

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

Contact:
Github: https://github.com/jimfeserHTW

If this program interacts with users remotely through a computer network,
it must provide a way for users to get its source code,
for example by offering a “Source” link in the user interface (see section 13 of the AGPL).
```


## Status

**Development** – Core functionality implemented. Learning mode is planned. Menu in active development.

## Contact

For feedback or contributions, feel free to open an issue or contact via GitHub:  
https://github.com/jimfeserHTW
