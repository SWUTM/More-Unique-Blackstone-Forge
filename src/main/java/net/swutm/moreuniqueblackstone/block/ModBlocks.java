package net.swutm.moreuniqueblackstone.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swutm.moreuniqueblackstone.item.ModItems;
import net.swutm.moreuniqueblackstone.moreuniqueblackstone;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, moreuniqueblackstone.MOD_ID);

    public static final RegistryObject<Block> CHARRED_BLACKSTONE = registerBlock("charred_blackstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE).noOcclusion()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> COVERED_WITH_DIAMOND_BLACKSTONE = registerBlock("covered_with_diamond_blackstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE).noOcclusion()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> COVERED_WITH_EMERALD_BLACKSTONE = registerBlock("covered_with_emerald_blackstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE).noOcclusion()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> COVERED_WITH_IRON_BLACKSTONE = registerBlock("covered_with_iron_blackstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE).noOcclusion()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> COVERED_WITH_LAPIS_BLACKSTONE = registerBlock("covered_with_lapis_blackstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE).noOcclusion()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> COVERED_WITH_NETHERITE_BLACKSTONE = registerBlock("covered_with_netherite_blackstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE).noOcclusion()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> COVERED_WITH_REDSTONE_BLACKSTONE = registerBlock("covered_with_redstone_blackstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE).noOcclusion()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> COVERED_WITH_RANDOM_BLACKSTONE = registerBlock("covered_with_random_blackstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE).noOcclusion()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
