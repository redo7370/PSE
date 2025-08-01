# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [2.0.0] - 2025-08-01

### Changed
- **Build System Migration**: Migrated from custom build scripts to Gradle build system
  - Added Gradle wrapper for consistent builds across environments
  - Replaced custom `run_test.sh` script with standard Gradle tasks
  - Enhanced test output to show detailed results (passed, failed, skipped tests)
  - Reorganized project structure to follow Gradle conventions
  - Removed "main." prefix from all package declarations to follow Java naming conventions

### Added
- Gradle build configuration with Java 21 toolchain
- Enhanced test reporting with detailed exception information
- Comprehensive project structure documentation

### Improved
- Development workflow now uses standard Gradle commands (`./gradlew build`, `./gradlew run`, `./gradlew test`)
- Better error reporting and debugging capabilities for tests
- Simplified project setup for new contributors
