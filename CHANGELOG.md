# Changelog

All notable changes to KubeJS Create Fabric are documented in this file.

## 2001.2.5-build.1

### Added

- Compatibility with KubeJS Fabric `2001.6.5-build.26` for Minecraft 1.20.1.
- Support for Create Fabric `6.0.8.1+build.1744-mc1.20.1`.
- Forge-compatible millibucket amounts in KubeJS Create recipes.
  `Fluid.of('minecraft:water', 250)` now correctly represents 250 mB.
- Automatic conversion from mB to Fabric Fluid Units for fluid inputs and
  outputs in newly created Create recipes.

### Fixed

- Fabric Fluid Units no longer need to be calculated manually in KubeJS
  scripts.
- Fluid amounts such as `250`, `500`, and `1000` are no longer passed to
  Create as tiny raw Fabric values.
- Warnings about suspicious fluid amounts are avoided when KubeJS Create
  recipes use correctly specified mB values.
