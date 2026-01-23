package net.silas.endermod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.silas.endermod.EndMod;
import net.silas.endermod.block.ModBlocks;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EndMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CHORUS_MOSS.get())
                .add(ModBlocks.VOID_SHALE.get())
                .add(ModBlocks.POLISHED_VOID_SHALE.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.CHORUS_LOG.get())
                .add(ModBlocks.STRIPPED_CHORUS_WOOD.get())
                .add(ModBlocks.STRIPPED_CHORUS_LOG.get())
                .add(ModBlocks.CHORUS_WOOD.get())
                .add(ModBlocks.CHORUS_PLANKS.get())
                .add(ModBlocks.CHORUS_STAIRS.get())
                .add(ModBlocks.CHORUS_SLAB.get())
                .add(ModBlocks.CHORUS_PRESSURE_PLATE.get())
                .add(ModBlocks.CHORUS_BUTTON.get())
                .add(ModBlocks.CHORUS_FENCE.get())
                .add(ModBlocks.CHORUS_FENCE_GATE.get());

        this.tag(BlockTags.FENCES).add(ModBlocks.CHORUS_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(ModBlocks.CHORUS_FENCE_GATE.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.CHORUS_LOG.get())
                .add(ModBlocks.STRIPPED_CHORUS_LOG.get())
                .add(ModBlocks.STRIPPED_CHORUS_WOOD.get())
                .add(ModBlocks.CHORUS_WOOD.get());




    }


}
