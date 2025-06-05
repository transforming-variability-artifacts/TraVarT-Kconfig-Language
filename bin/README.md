# Kconfig plugin for TraVarT

This repository contains an adaptation of
[Kfeature](https://codeberg.org/6b6279/Kfeature) as a plugin for
[TraVarT](https://github.com/SECPS/TraVarT).

Transformations from the original Kfeature are re-implemented, alongside with completely new transformations:
- Backward transformation from Kconfig to UVL (roundtrip transformation)
- Forward transformation from UVL to Kconfig

This plugin provides an intermediate model format for Kconfig files
(`KconfigModel`), which is based on a directed graph structure
(`KconfigGraph`), the nodes being confsyms (or equivalent blocks,
menus, choices...) and the edges being dependencies. `KconfigReader`
is also implemented, which delivers `KconfigModel`s for a given
Kconfig file. The node types used in `KconfigGraph` are implemented
with generics and coupled polymorphism. We utilize LogicNG (which is
also used by UVL internally) to allow composite dependency
expressions, through which we also provide a novel transformation for
such expressions into respective UVL constraints. We use mintcoffee's
ANTLR3 parser grammar for Kconfig files, which was also used in the
original Kfeature implementation, although with few changes (see
below).

The round-trip transformer supports following Kconfig structures (`KconfigModelTwoWayGraphTransformer` with `processGraph` and `processToGraph`):

- Choice blocks, tristate and boolean
- Menu blocks
- Tristate and boolean confsyms
- Forward and reverse dependencies (`select`), regardless of dependee expression

...although with certain caveats:

- The parser grammar for dependee expressions is slightly altered to match with the LogicNG syntax (`$false` instead of `false`, `|` and `&` instead of `||` and `&&`, `~` instead of `!`)
- Due to typing issues, menuconfig confsyms are reduced to regular boolean confsyms
- `modules` for reducing tristate confsyms to boolean confsyms is ignored, Kconfig files without a respective `modules` confsym are processed regardless

Certain transformations are trivial, but not implemented due to parser/time restrictions:

- There is a rudimentary one-way transformation for `if` blocks, but the backward transformation is missing
- String-, integer- and decimal-valued confsyms (trivial due to UVL allowing arbitrary feature attributes)
- `imply` and `default` (or in general, all structs refering to confsym default values)

The partial round-trip transformation (Kconfig -> UVL) is bootstrapped
in the one-way transformer. This might produce some redundant
attributes (`active` and `hasSelectDep`) if unsupported constructs are
transformed.

The one-way transformer supports following UVL structures (`KconfigModelOneWayGraphTransformer` with `processToGraph`):

- Mandatory and optional features
- Alt and or groups
- Feature model constraints

...although with certain caveats:

- Only simple implication constraints are supported, and these might break the produced model used alongside with or groups
- Only 1..* or groups are supported
- Chains of mandatory features might result in unsatisfiable Kconfig models (depending on the used Kconfig backend)

The code is mostly self-documented. For implementing own unit tests,
copy one of the tests in `KconfigTest` and replace the URI given to
`KconfigReader` with your respective Kconfig file. For testing the
one-way UVL to Kconfig transformation, you have to build your UVL
feature model by hand (see `oneWayOrTest`) and compare it with the
expected result, using AssertJ. You might have to ignore certain
fields, see already implemented tests for pointers.
