OANDA v20 API Java Class Generator
==================================

# Requirements
Python 3.x (tested with Python 3.7.4).

# Usage
```
classgen.py [--root ROOT] [--output OUTPUT] [--package PACKAGE]
```
1. `ROOT` is the root directory of all definition files (default to `../defs`)
2. `OUTPUT` is the target output directory (default to `../src/main/java`)
3. `PACKAGE` is the package prefix for all generated classes (default to `io.tealight.api.oanda.v20.def`)

Additionally, every class is also organized under different sub-package according to definition categories defined in <https://developer.oanda.com/rest-live-v20/>. The sub-packages are: `account`, `instrument`, `order`, `trade`, `position`, `transaction`, `pricing`, `primitives`.

## Definitions
There are two kinds of definitions, class and enum definitions. The class generator uses file extension to differentiate the type of Java class to be generated.

Class definitions are stored as files with extension `.cdef`. Each class definition contains the schema published in OANDA v20 REST API (as is). The schema itself is a json-like that defines every property in the json object described in the schema.

Enum definitions are stored as files with extension `.edef`. Each definition contains the enumeration schema published in OANDA v20 REST API. The enumeration values are (hand) formatted to be json-like so it is easier to be parsed by the Python parser.

# Assumptions
1. All class names are unique, i.e. no two classes with the same name but belong to two different packages.
2. Attributes that have the same name as any of Java reserved words are generated as member variables with prefix `_`. To ensure that Gson will generate the correct property names, the generator will also add Gson annotation `com.google.gson.annotations.SerializedName` into each of the member variable. So far there are three of this kind of member variables:
    - `_long`, defined in `order/UnitsAvailableDetails.java` and `position/Position.java`
    - `_short`, defined in `order/UnitsAvailableDetails.java` and `position/Position.java`
    - `_default`, defined in `order/UnitsAvailableDetails.java`
