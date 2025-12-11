package net.silas.endermod.datagen;


import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silas.endermod.EndMod;
import net.silas.endermod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, EndMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.CHORUS_MOSS.get(),
                models().cubeBottomTop(
                        "chorus_moss",
                        modLoc("block/chorus_moss_side"),
                        mcLoc("block/end_stone"),
                        modLoc("block/chorus_moss_top")
                ));

        simpleBlock(ModBlocks.CHORUS_SPROUTS.get(),
                models().cross(blockTexture(ModBlocks.CHORUS_SPROUTS.get()).getPath(),
                        blockTexture(ModBlocks.CHORUS_SPROUTS.get())).renderType("cutout"));

        logBlock(((RotatedPillarBlock) ModBlocks.CHORUS_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.CHORUS_WOOD.get()), blockTexture(ModBlocks.CHORUS_LOG.get()),
                blockTexture(ModBlocks.CHORUS_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_CHORUS_WOOD.get()), blockTexture(ModBlocks.STRIPPED_CHORUS_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_CHORUS_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_CHORUS_LOG.get()));

        blockItem(ModBlocks.CHORUS_LOG);
        blockItem(ModBlocks.CHORUS_WOOD);
        blockItem(ModBlocks.STRIPPED_CHORUS_LOG);
        blockItem(ModBlocks.STRIPPED_CHORUS_WOOD);

        blockWithItem(ModBlocks.CHORUS_PLANKS);

        leavesBlock(ModBlocks.CHORUS_LEAVES);

        saplingBlock(ModBlocks.CHORUS_SAPLING);

        stairsBlock(((StairBlock) ModBlocks.CHORUS_STAIRS.get()), blockTexture(ModBlocks.CHORUS_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.CHORUS_SLAB.get()), blockTexture(ModBlocks.CHORUS_PLANKS.get()), blockTexture(ModBlocks.CHORUS_PLANKS.get()));

        blockItem(ModBlocks.CHORUS_STAIRS);
        blockItem(ModBlocks.CHORUS_SLAB);

        buttonBlock(((ButtonBlock) ModBlocks.CHORUS_BUTTON.get()), blockTexture(ModBlocks.CHORUS_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.CHORUS_PRESSURE_PLATE.get()), blockTexture(ModBlocks.CHORUS_PLANKS.get()));

        blockItem(ModBlocks.CHORUS_PRESSURE_PLATE);

        fenceBlock(((FenceBlock) ModBlocks.CHORUS_FENCE.get()), blockTexture(ModBlocks.CHORUS_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.CHORUS_FENCE_GATE.get()), blockTexture(ModBlocks.CHORUS_PLANKS.get()));

        blockItem(ModBlocks.CHORUS_FENCE_GATE);


    }
    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("endermod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}