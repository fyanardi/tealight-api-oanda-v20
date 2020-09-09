import re
import os
import argparse
from datetime import datetime
import time


# list of java reserved words that appear in some of the definition files
JAVA_RESERVED = [ 'default', 'long', 'short' ]

# Type map, key is the type value is a tuple of (Java type (primitive/class), Java package)
# This dict will be extended by the newly processed definitions files, so this dict initially
# contains definitions that are represented by primitive Java types (or String)
TYPE_MAP = {
    'string': ('String', None, False),
    'integer': ('Integer', None, False),
    'boolean': ('Boolean', None, False),
    'DecimalNumber': ('Double', None, False),
    'AccountID': ('String', None, False),
    'AccountUnits': ('Double', None, False),
    'Currency': ('Currency', 'java.util', False),
    'InstrumentName': ('String', None, False),
    'DateTime': ('ZonedDateTime', 'java.time', True),
    'PricingComponent': ('String', None, False),
    # Order definitions
    'OrderID': ('String', None, False),
    'OrderSpecifier': ('String', None, False),
    # Transaction definitions
    'ClientID': ('String', None, False),
    'TransactionID': ('String', None, False),
    'ClientTag': ('String', None, False),
    'ClientComment': ('String', None, False),
    'RequestID': ('String', None, False),
    'ClientRequestID': ('String', None, False),
    # Trade definitions
    'TradeID': ('String', None, False),
    'TradeSpecifier': ('String', None, False),
    # Pricing definitions
    'CandleSpecification': ('String', None, False),
    # Pricing Common definitions
    'PriceValue': ('Double', None, False)
}

JAVA_CLASS_INHERITANCE= {
    'AccumulatedAccountState': [
        'AccountSummary', 'AccountChangesState'
    ],
    'AccountSummary': [
        'Account'
    ],
    'Order': [
        'MarketOrder', 'FixedPriceOrder', 'LimitOrder', 'StopOrder', 'MarketIfTouchedOrder',
        'TakeProfitOrder', 'StopLossOrder', 'GuaranteedStopLossOrder', 'TrailingStopLossOrder'
    ],
    'OrderRequest': [
         'MarketOrderRequest', 'LimitOrderRequest', 'StopOrderRequest',
         'MarketIfTouchedOrderRequest', 'TakeProfitOrderRequest', 'StopLossOrderRequest',
         'GuaranteedStopLossOrderRequest', 'TrailingStopLossOrderRequest'
    ],
    'Transaction': [
        'MarketOrderTransaction', 'OrderFillTransaction', 'OrderCancelTransaction',
        'MarketOrderRejectTransaction', 'OrderCancelRejectTransaction',
        'OrderClientExtensionsModifyTransaction', 'OrderClientExtensionsModifyRejectTransaction',
        'ClientConfigureTransaction', 'ClientConfigureRejectTransaction',  'CreateTransaction',
        'CloseTransaction', 'ReopenTransaction', 'TransferFundsTransaction',
        'TransferFundsRejectTransaction', 'FixedPriceOrderTransaction', 'LimitOrderTransaction',
        'LimitOrderRejectTransaction', 'StopOrderTransaction', 'StopOrderRejectTransaction',
        'MarketIfTouchedOrderTransaction', 'MarketIfTouchedOrderRejectTransaction', 
        'TakeProfitOrderTransaction', 'TakeProfitOrderRejectTransaction',
        'StopLossOrderTransaction', 'StopLossOrderRejectTransaction',
        'GuaranteedStopLossOrderTransaction', 'GuaranteedStopLossOrderRejectTransaction',
        'TrailingStopLossOrderTransaction', 'TrailingStopLossOrderRejectTransaction',
        'TradeClientExtensionsModifyTransaction', 'TradeClientExtensionsModifyRejectTransaction',
        'MarginCallEnterTransaction', 'MarginCallExtendTransaction', 'MarginCallExitTransaction',
        'DelayedTradeClosureTransaction', 'DailyFinancingTransaction',
        'DividendAdjustmentTransaction', 'ResetResettablePLTransaction'
    ],
    'ErrorResponse': [
        'OrderRejectResponse', 'OrderCancelRejectResponse'
    ]
}


def gen_class(name, package, props, parent=None, parent_members=None):
    """
    return: list of string of the generated class
    """

    print('gen_class name={} parent={} parent_members={}'.format(name, parent, parent_members))

    # Java classes to be imported, each entry is a tuple of (package, class)
    imports = []
    # member variables, each entry is a tuple of (name, type)
    members = []

    unknown_types = set()

    for prop in props:
        is_array = False
        m = re.search(r'Array\[(\w+)\]', prop[1])

        if m:
            is_array = True
            java_type = m.group(1)
        else:
            java_type = prop[1]

        if java_type not in TYPE_MAP:
            unknown_types.add(java_type)
            continue

        if parent_members and prop[0] in parent_members:
            continue

        m_type = TYPE_MAP[java_type]
        if m_type[1]:
            imports.append((m_type[1], m_type[0]))

        if is_array:
            members.append((prop[0], "{}[]".format(m_type[0]), None))
        else:
            # prop[2] is the default value (if any)
            members.append((prop[0], m_type[0], prop[2]))

    if parent:
        # Need to import parent class if it is in different package
        parent_package = TYPE_MAP[parent][1]
        if parent_package != package:
            imports.append((parent_package, parent))

    lines = []
    lines.append("package {};".format(package))

    imported = []
    if imports:
        # TODO: sort imports
        lines.append("")
        for i in imports:
            import_ = '{}.{}'.format(i[0], i[1])
            if import_ in imported:
                continue
            # If same package, no need to import
            if i[0] == package:
                continue
            
            lines.append("import {};".format(import_))
            imported.append(import_)

    lines.append("")

    if parent:
        lines.append("public class {} extends {} {{".format(name, parent))
    else:
        lines.append("public class {} {{".format(name))

    # member declarations
    for member in members:
        var_name = member[0]
        # there are some definitions with attributes 'long' and 'short', which are java reserved
        # words
        if var_name in JAVA_RESERVED:
            var_name = '_' + var_name

        if member[2]:
            # TYPE_MAP value tuple #2 is whether the type is an enum or not
            # Need to check whether TYPE_MAP contains the type first, since this dict contains only
            # the final Java type and not the type in the def file. E.g. type in the def file might
            # be 'string' but the corresponding Java type is 'String'
            if member[1] in TYPE_MAP and TYPE_MAP[member[1]][2]:
                lines.append("    private {} {} = {}.{};".format(
                        member[1], var_name, member[1], member[2]))
            elif member[1] == 'String':
                lines.append("    private {} {} = \"{}\";".format(
                        member[1], var_name, member[2]))
            else:
                lines.append("    private {} {} = {};".format(
                        member[1], var_name, member[2]))
        else:
            lines.append("    private {} {};".format(member[1], var_name))
    lines.append("");

    # getters and setters
    for member in members:
        cap = member[0][0].upper() + member[0][1:]
        var_name = member[0]
        # there are some definitions with attributes 'long' and 'short', which are java reserved
        # words
        if var_name in JAVA_RESERVED:
            var_name = '_' + var_name

        lines.append("    public {} get{}() {{".format(member[1], cap))
        lines.append("        return {};".format(var_name))
        lines.append("    }");
        lines.append("");
        lines.append("    public void set{}({} {}) {{".format(cap, member[1], var_name))
        lines.append("        this.{} = {};".format(var_name, var_name))
        lines.append("    }");
        lines.append("");
    lines.append("}");

    print('--- class={}.{} generated with unknown types: {} ---'.format(package, name, unknown_types))

    return lines, unknown_types


def gen_enum(name, package, values):
    """
    return: list of string of the generated enum
    """
    lines = []
    lines.append("package {};".format(package))

    lines.append("")
    lines.append("public enum {} {{".format(name))

    for i in range(len(values)):
        if i != len(values) - 1:
            lines.append("    {},".format(values[i][0]))
        else:
            lines.append("    {}".format(values[i][0]))

    lines.append("}")

    return lines


def parse_cdef_schema(schema_file):
    """
    Parse a cdef (class definition) schema file
    """
    # Each entry is a tuple of property name, type, default value and comment
    # Example: ('id', 'AccountID',  None, 'The Account's identifier')
    props = []

    f = open(schema_file)
    comments = ""
    i = 0

    for l in f:
        i += 1
        line = l.strip()

        if not line:
            continue

        # start / end definition
        if line == "{":
            # TODO: class comments
            comments = ""
            continue
        elif line == "}":
            continue
        elif line.startswith("#"):
            # don't append empty comment line
            c = line[1:].strip()
            if not c:
                continue
            # multiline comment, add space
            if comments:
                comments += " "
            comments += c
        else:
            m = re.search(r'\s*(\w+)\s*:\s*\((.+)\),*', line)
            if m:
                fields = m.group(2).split(',')
                default = None
                if len(fields) > 1:
                    for i in range(1, len(fields)):
                        field = fields[i].strip()
                        if field.startswith('default='):
                            default = field[len('default='):]
                            break
                # print("{} => {}".format(m.group(1), m.group(2)))
                props.append((m.group(1), fields[0], default, comments))
            else:
                print("Parse error at line #", i)
            comments = ""

    for prop in props:
        print("property=[{}] type=[{}] default=[{}] comments=[{}]".format(
                prop[0], prop[1], prop[2], prop[3]))

    return props


def parse_edef_schema(schema_file):
    """
    Parse an edef (enum definition) schema file
    """
    # Each entry is a tuple of enum value and comment
    # Example: ('DISABLED', 'The Account is not permitted to create guaranteed Stop Loss Orders.')
    values = []

    f = open(schema_file)
    comments = ""
    i = 0

    for l in f:
        i += 1
        line = l.strip()

        if not line:
            continue

        # start / end definition
        if line == "[" or line == "]":
            continue
        elif line.startswith("#"):
            # don't append empty comment line
            c = line[1:].strip()
            if not c:
                continue
            # multiline comment, add space
            if comments:
                comments += " "
            comments += c
        else:
            if line.endswith(","):
                values.append((line[:-1], comments))
            else:
                values.append((line, comments))

            comments = ""

    for value in values:
        print("value=[{}] comments=[{}]".format(value[0], value[1]))

    return values


def to_upper_camel(string):
    words = string.split('_')
    return ''.join(x.capitalize() for x in words)


def gen_package(package_base, sub_package):
    """
    package_base: base/common package
    sub_package: sub package paths as list (not string)
    """
    package = package_base
    if sub_package:
        package = package + '.' + '.'.join(sub_package)
    return package


def save_java_class(base_path, package_paths, class_name, lines):
    """
    package_paths: list of paths that make up the package, e.g: ['oanda', 'account']
    """
    path = os.path.join(base_path, *package_paths)
    file_path = os.path.join(path, class_name + ".java")
    print('Path: {}'.format(file_path))

    os.makedirs(path, exist_ok=True)
    with open(file_path, "w") as f:
        now = datetime.now()
        ts = now.strftime("%Y-%m-%d %H:%M:%S")
        tz = now.astimezone().tzname()
        f.write("// This Java source file was generated on {} ({})\n".format(ts, tz))

        # writelines does not append '\n' at the end of every line
        # f.writelines(lines)
        for line in lines:
            f.write(line + '\n')


def main(root_defs_dir, output_base_dir, package_base=''):
    # every entry in the list is a tuple of (def_file_path, java_package, java_class, is_enum)
    # cdef_base_files contain parent classes that need to be generated first
    cdef_base_files = []
    cdef_files = []
    edef_files = []

    # DFS on the root directory
    # Every dirs entry is a list of paths (starting from root directory)
    dirs = [ [ root_defs_dir ] ]
    while dirs:
        d = dirs[0]
        # remove processed dir
        dirs = dirs[1:]

        path = os.sep.join(d)
        for f in os.listdir(path):
            file_path = os.path.join(path, f)
            if os.path.isdir(file_path):
                d_ = d[:]
                d_.append(f)
                dirs.insert(0, d_)
            elif os.path.isfile(file_path):
                head, tail = os.path.split(f)
                name, ext = os.path.splitext(tail)
                if ext.lower() == '.cdef':
                    # remove the root dir from package name
                    # cdef_files.append((file_path, d[1:], to_upper_camel(name)))
                    if name in JAVA_CLASS_INHERITANCE:
                        cdef_base_files.append((file_path, d[1:], name))
                    else:
                        cdef_files.append((file_path, d[1:], name))
                elif ext.lower() == '.edef':
                    # remove the root dir from package name
                    # edef_files.append((file_path, d[1:], to_upper_camel(name)))
                    edef_files.append((file_path, d[1:], name))

    oanda_type_map = {}
    for def_file in cdef_base_files:
        oanda_type_map[def_file[2]] = (def_file[2], gen_package(package_base, def_file[1]), False)
    for def_file in cdef_files:
        oanda_type_map[def_file[2]] = (def_file[2], gen_package(package_base, def_file[1]), False)
    for def_file in edef_files:
        oanda_type_map[def_file[2]] = (def_file[2], gen_package(package_base, def_file[1]), True)

    # insert OANDA specific definitions into the type map
    TYPE_MAP.update(oanda_type_map)

    for key, value in oanda_type_map.items():
        print('type={} package={}'.format(key, value[1]))

    print()

    unknown_types = set()

    # dict of parent class -> props
    parent_defs = {}

    package_base_paths = package_base.split('.')

    # Make a dict of child -> parent so it is easier to look up
    parent_classes = {}
    for key, value in JAVA_CLASS_INHERITANCE.items():
        for child in value:
            parent_classes[child] = key

    print('parent_classes: {}'.format(parent_classes))
    print()

    for def_file in cdef_base_files:
        package = gen_package(package_base, def_file[1])
        print('*** cdef_file={} package={} class={} ***'.format(def_file[0], package, def_file[2]))
        props = parse_cdef_schema(def_file[0])
        parent_defs[def_file[2]] = [ x[0] for x in props ]

        # if the class itself is a child of another class, defer the actual Java class generation
        # and add the class def into cdef_files
        if def_file[2] in parent_classes:
            cdef_files.append(def_file)
            continue

        lines, u_t = gen_class(def_file[2], package, props)
        unknown_types = unknown_types | u_t
        save_java_class(output_base_dir, package_base_paths + def_file[1], def_file[2], lines)
        print()

    for def_file in cdef_files:
        package = gen_package(package_base, def_file[1])
        print('*** cdef_file={} package={} class={} ***'.format(def_file[0], package, def_file[2]))
        props = parse_cdef_schema(def_file[0])

        print('in parent_classes: {}'.format(def_file[2] in parent_classes))

        if def_file[2] in parent_classes:
            parent = parent_classes[def_file[2]]
            parent_members = parent_defs[parent]

            lines, u_t = gen_class(def_file[2], package, props, parent, parent_members)
        else:
            lines, u_t = gen_class(def_file[2], package, props)

        unknown_types = unknown_types | u_t

        save_java_class(output_base_dir, package_base_paths + def_file[1], def_file[2], lines)
        print()

    for def_file in edef_files:
        package = gen_package(package_base, def_file[1])
        print('*** edef_file={} package={} class={} ***'.format(def_file[0], package, def_file[2]))
        values = parse_edef_schema(def_file[0])
        lines = gen_enum(def_file[2], package, values)
        save_java_class(output_base_dir, package_base_paths + def_file[1], def_file[2], lines)
        print()

    print('{} classes & enums generated'.format(len(cdef_files) + len(edef_files)))
    print('Unknown types: {}'.format(unknown_types))


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description='OANDA API v20 Java Class Generator.')
    parser.add_argument('--root', default='..\\defs',
            help='Root location of the definition files')
    parser.add_argument('--output', default='..\\src\\main\\java',
            help='Directory to write generated classes into')
    parser.add_argument('--package', default='io.tealight.api.oanda.v20.def',
            help='Java package name of all generated classes')

    args = parser.parse_args()
    d = vars(args)

    print('Generating Java Classes using arguments: {}'.format(d))

    root_defs_dir = d['root']
    output_base_dir = d['output']
    package_base = d['package']

    main(root_defs_dir, output_base_dir, package_base)

