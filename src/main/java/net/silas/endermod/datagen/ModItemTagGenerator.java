package net.silas.endermod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.silas.endermod.EndMod;
import net.silas.endermod.block.ModBlocks;
import net.silas.endermod.util.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                               CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, EndMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.CHORUS_LOG.get().asItem())
                .add(ModBlocks.CHORUS_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_CHORUS_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_CHORUS_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.CHORUS_PLANKS.get().asItem());

        this.tag(ModTags.Items.CHORUS_LOGS)
                .add(ModBlocks.CHORUS_LOG.get().asItem())
                .add(ModBlocks.CHORUS_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_CHORUS_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_CHORUS_WOOD.get().asItem());
    }
}