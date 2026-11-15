package dev.latvian.mods.kubejs.create.platform;

import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

/** Context supplied by Create 6 when an open pipe applies a fluid effect. */
public record OpenPipeEffectContext(Level level, AABB area) {
}
