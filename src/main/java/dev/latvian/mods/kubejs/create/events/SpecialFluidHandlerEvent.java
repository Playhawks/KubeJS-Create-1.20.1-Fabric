package dev.latvian.mods.kubejs.create.events;

import com.simibubi.create.api.effect.OpenPipeEffectHandler;
import com.simibubi.create.foundation.fluid.FluidIngredient;
import dev.latvian.mods.kubejs.create.platform.FluidIngredientHelper;
import dev.latvian.mods.kubejs.create.platform.OpenPipeEffectContext;
import dev.latvian.mods.kubejs.event.EventJS;
import dev.latvian.mods.kubejs.fluid.FluidStackJS;

import java.util.function.BiConsumer;

/**
 * @author Prunoideae
 */
public class SpecialFluidHandlerEvent extends EventJS {
	public void add(FluidIngredient fluidIngredient, BiConsumer<OpenPipeEffectContext, FluidStackJS> handler) {
		var effectHandler = FluidIngredientHelper.createEffectHandler(handler);
		OpenPipeEffectHandler.REGISTRY.registerProvider(fluid ->
				fluidIngredient.test(new io.github.fabricators_of_create.porting_lib.fluids.FluidStack(fluid, 1))
						? effectHandler : null);
	}
}
