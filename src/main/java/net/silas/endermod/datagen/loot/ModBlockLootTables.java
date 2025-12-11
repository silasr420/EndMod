package net.silas.endermod.datagen.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraftforge.registries.RegistryObject;
import net.silas.endermod.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        this.add(ModBlocks.CHORUS_MOSS.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.END_STONE));
        dropSelf(ModBlocks.CHORUS_SPROUTS.get());

        dropSelf(ModBlocks.CHORUS_LOG.get());
        dropSelf(ModBlocks.STRIPPED_CHORUS_LOG.get());
        dropSelf(ModBlocks.STRIPPED_CHORUS_WOOD.get());
        dropSelf(ModBlocks.CHORUS_WOOD.get());
        dropSelf(ModBlocks.CHORUS_PLANKS.get());
        dropSelf(ModBlocks.CHORUS_SAPLING.get());
        this.add(ModBlocks.CHORUS_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.CHORUS_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        dropSelf(ModBlocks.CHORUS_STAIRS.get());
        this.add(ModBlocks.CHORUS_SLAB.get(), block -> createSlabItemTable(ModBlocks.CHORUS_SLAB.get()));

        dropSelf(ModBlocks.CHORUS_BUTTON.get());
        dropSelf(ModBlocks.CHORUS_PRESSURE_PLATE.get());

        dropSelf(ModBlocks.CHORUS_FENCE.get());
        dropSelf(ModBlocks.CHORUS_FENCE_GATE.get());

    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
