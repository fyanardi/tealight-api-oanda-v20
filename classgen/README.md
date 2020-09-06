OANDA v20 API Java Class Generator
==================================

# Requirements
Python 3.x (tested with Python 3.7.4).

# Usage
```
classgen.py [--root ROOT] [--output OUTPUT] --package PACKAGE
```
1. `ROOT` is the root directory of all definition files (default to `../defs`)
2. `OUTPUT` is the target output directory (default to `../src/main/java`)
3. `PACKAGE` is the package prefix for all generated classes (default to `io.tealight.api.oanda.v20.dev`)

Additionally, every class is also organized under different sub-package according to definition categories defined in <https://developer.oanda.com/rest-live-v20/>. The sub-packages are: `account`, `instrument`, `order`, `trade`, `position`, `transaction`, `pricing`, `primitives`.

## Definitions
There are two kind of definitions, class and enum definitions. The class generator uses file extension to differentiate the type of Java class to be generated.

Class definitions are stored as files with extension `.cdef`, and contains the schema published in OANDA v20 REST API (as is). The schema itself is a json-like that defines every property in the json object described in the schema.

Enum definitions are stored as files with extension `.edef`, and contains the enumeration schema publish in OANDA v20 REST API. The enumeration values are formatted to be json-like so it is easier to be parsed by the Python parser.
