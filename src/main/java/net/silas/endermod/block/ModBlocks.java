package net.silas.endermod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silas.endermod.EndMod;
import net.silas.endermod.block.custom.EndMossBlock;
import net.silas.endermod.block.custom.ModFlammableRotatedPillarBlock;
import net.silas.endermod.item.ModItems;
import net.silas.endermod.worldgen.tree.ModTreeGrowers;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EndMod.MOD_ID);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, java.util.function.Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> toReturn) {
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
    }


    public static final RegistryObject<Block> CHORUS_MOSS = registerBlock("chorus_moss",
            () -> new EndMossBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3).sound(SoundType.NYLIUM)));

    public static final RegistryObject<Block> CHORUS_SPROUTS = registerBlock("chorus_sprouts",
            () -> new RootsBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.NETHER_SPROUTS).instabreak()
                    .noCollission().lightLevel(state -> 5)));

    public static final RegistryObject<Block> CHORUS_SAPLING = registerBlock("chorus_sapling",
            () -> new SaplingBlock(ModTreeGrowers.CHORUS, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_SAPLING)));

    public static final RegistryObject<Block> CHORUS_LEAVES = registerBlock("chorus_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> CHORUS_LOG = registerBlock("chorus_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LOG)));
    public static final RegistryObject<Block> CHORUS_WOOD = registerBlock("chorus_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WOOD)));
    public static final RegistryObject<Block> STRIPPED_CHORUS_LOG = registerBlock("stripped_chorus_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_LOG)));
    public static final RegistryObject<Block> STRIPPED_CHORUS_WOOD = registerBlock("stripped_chorus_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD)));

    public static final RegistryObject<Block> CHORUS_PLANKS = registerBlock("chorus_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> CHORUS_STAIRS = registerBlock("chorus_stairs",
            () -> new StairBlock(ModBlocks.CHORUS_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_STAIRS)));
    public static final RegistryObject<Block> CHORUS_SLAB = registerBlock("chorus_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_SLAB)));

    public static final RegistryObject<Block> CHORUS_PRESSURE_PLATE = registerBlock("chorus_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PRESSURE_PLATE)));
    public static final RegistryObject<Block> CHORUS_BUTTON = registerBlock("chorus_button",
            () -> new ButtonBlock(BlockSetType.CHERRY, 1, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_BUTTON)));

    public static final RegistryObject<Block> CHORUS_FENCE = registerBlock("chorus_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_FENCE)));
    public static final RegistryObject<Block> CHORUS_FENCE_GATE = registerBlock("chorus_fence_gate",
            () -> new FenceGateBlock(WoodType.CHERRY, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_FENCE_GATE)));


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
