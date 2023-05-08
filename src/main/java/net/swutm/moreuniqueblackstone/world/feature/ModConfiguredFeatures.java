package net.swutm.moreuniqueblackstone.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.swutm.moreuniqueblackstone.block.ModBlocks;
import net.swutm.moreuniqueblackstone.moreuniqueblackstone;

import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, moreuniqueblackstone.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_CHARRED_BLACKSTONE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.CHARRED_BLACKSTONE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_CHARRED_BLACKSTONE1 = CONFIGURED_FEATURES.register("nether_charred_blackstone",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_CHARRED_BLACKSTONE.get(), 9)));


    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}