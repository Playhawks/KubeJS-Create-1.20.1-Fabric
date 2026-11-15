package dev.latvian.mods.kubejs.create.events;

import com.simibubi.create.api.boiler.BoilerHeater;
import dev.latvian.mods.kubejs.block.state.BlockStatePredicate;
import dev.latvian.mods.kubejs.create.platform.BoilerHeaterHelper;
import dev.latvian.mods.kubejs.event.EventJS;
import dev.latvian.mods.kubejs.level.BlockContainerJS;
import net.minecraft.world.level.block.Block;

public class BoilerHeaterHandlerEvent extends EventJS {
	@FunctionalInterface
	public interface BoilerHeaterCallback {
		float updateHeat(BlockContainerJS block);
	}

	public void add(Block block, BoilerHeaterCallback onUpdate) {
		BoilerHeaterHelper.registerHeaterPlatform(block, onUpdate);
	}

	public void addAdvanced(BlockStatePredicate block, BoilerHeaterCallback onUpdate) {
		BoilerHeater.REGISTRY.registerProvider(candidate -> block.test(candidate.defaultBlockState())
				? (level, blockPos, blockState) -> onUpdate.updateHeat(level.kjs$getBlock(blockPos))
				: null);
	}
}
