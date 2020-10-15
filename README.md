OANDA v20 API Java Wrapper
==========================

Alternative Java wrapper for OANDA v20 REST APIs.

# Dependencies
## Runtime
1. Java 11 (due to the usage of `java.net.http` introduced in Java 11), tested with Java 11 & 13.
2. Google GSON, tested with GSON 2.8.6

## Development and Test
1. JDK 11
2. Python 3.x to generate the class definitions, tested with Python 3.7.4.
3. Gradle build system, tested with Gradle 6.6.1
4. JUnit 5

## Using Eclipse IDE
Run `gradle eclipse` to generate necessary Eclipse IDE files (`.project` and `.classpath`)

# Build
Run `gradle java` to build the project and `gradle jar` to create the corresponding jar. The jar is located in `build/libs/tealight-api-oanda-v20-x.y.z.jar` (where `x.y.z` is the current project version).

# Usage
Please take a look at the sample codes under package `io.tealight.api.oanda.v20`.
