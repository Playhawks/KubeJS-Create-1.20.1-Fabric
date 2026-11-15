package dev.latvian.mods.kubejs.create.events;

import com.simibubi.create.api.behaviour.spouting.BlockSpoutingBehaviour;
import dev.latvian.mods.kubejs.block.state.BlockStatePredicate;
import dev.latvian.mods.kubejs.create.platform.FluidIngredientHelper;
import dev.latvian.mods.kubejs.event.EventJS;
import dev.latvian.mods.kubejs.fluid.FluidStackJS;
import dev.latvian.mods.kubejs.level.BlockContainerJS;
import net.minecraft.resources.ResourceLocation;

/**
 * @author Prunoideae
 */
public class SpecialSpoutHandlerEvent extends EventJS {
	@FunctionalInterface
	public interface SpoutHandler {
		long fillBlock(BlockContainerJS block, FluidStackJS fluid, boolean simulate);
	}

	public void add(ResourceLocation path, BlockStatePredicate block, SpoutHandler handler) {
		var behaviour = FluidIngredientHelper.createSpoutingHandler(block, handler);
		BlockSpoutingBehaviour.BY_BLOCK.registerProvider(candidate ->
				block.test(candidate.defaultBlockState()) ? behaviour : null);
	}
}
