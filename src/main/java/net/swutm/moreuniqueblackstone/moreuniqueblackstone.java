package net.swutm.moreuniqueblackstone;

import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.swutm.moreuniqueblackstone.block.ModBlocks;
import net.swutm.moreuniqueblackstone.item.ModItems;
import net.swutm.moreuniqueblackstone.world.feature.ModConfiguredFeatures;
import net.swutm.moreuniqueblackstone.world.feature.ModPlacedFeatures;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(moreuniqueblackstone.MOD_ID)
public class moreuniqueblackstone
{
    // Directly reference a slf4j logger
    public static final String MOD_ID = "moreuniqueblackstone";

    private static final Logger LOGGER = LogUtils.getLogger();

    public moreuniqueblackstone()
    {
        // Register the setup method for modloading
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    public moreuniqueblackstone(BlockBehaviour.Properties p_49795_) {
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getName());
    }
}
