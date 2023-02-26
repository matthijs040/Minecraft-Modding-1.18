package com.mattice.tutorialmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mattice.tutorialmod.init.ItemInit;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("tutorialmod")
public class TutorialMod {

	public static final String MOD_ID = "tutorialmod";

	private static final Logger LOGGER = LogManager.getLogger();

	public static final CreativeModeTab TAB = new CreativeModeTab(MOD_ID) {
		
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(ItemInit.EXAMPLE_ITEM.get());
		}
	};

	public TutorialMod() {
		var loading_context = FMLJavaModLoadingContext.get().getModEventBus();
		ItemInit.ITEMS.register(loading_context);

		loading_context.addListener(this::setup);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event)
	{
		// TODO: Add pre-init code.
		LOGGER.info("pre-init function called.");
		LOGGER.info("Dirt block >> {}", Blocks.DIRT.getRegistryName());

		
	}
}
