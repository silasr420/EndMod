package net.silas.endermod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.silas.endermod.block.ModBlocks;
import net.silas.endermod.item.ModItems;
import net.silas.endermod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        stairBuilder(ModBlocks.CHORUS_STAIRS.get(), Ingredient.of(ModBlocks.CHORUS_PLANKS.get())).group("chorus_wood")
                .unlockedBy("has_chorus_planks", has(ModBlocks.CHORUS_PLANKS.get())).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_SLAB.get(), ModBlocks.CHORUS_PLANKS.get());

        buttonBuilder(ModBlocks.CHORUS_BUTTON.get(), Ingredient.of(ModBlocks.CHORUS_PLANKS.get())).group("chorus_wood")
                .unlockedBy("has_chorus_planks", has(ModBlocks.CHORUS_PLANKS.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.CHORUS_PRESSURE_PLATE.get(), ModBlocks.CHORUS_PLANKS.get());

        woodFromLogs(recipeOutput, ModBlocks.CHORUS_WOOD.get(), ModBlocks.CHORUS_LOG.get());
        woodFromLogs(recipeOutput, ModBlocks.STRIPPED_CHORUS_WOOD.get(), ModBlocks.STRIPPED_CHORUS_LOG.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_PLANKS.get(), 4)
                .requires(ModTags.Items.CHORUS_LOGS)
                .unlockedBy("has_chorus_log", has(ModBlocks.CHORUS_LOG.get())).save(recipeOutput);

        fenceBuilder(ModBlocks.CHORUS_FENCE.get(), Ingredient.of(ModBlocks.CHORUS_PLANKS.get())).group("chorus_wood")
                .unlockedBy("has_chorus_planks", has(ModBlocks.CHORUS_PLANKS.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.CHORUS_FENCE_GATE.get(), Ingredient.of(ModBlocks.CHORUS_PLANKS.get())).group("chorus_wood")
                .unlockedBy("has_chorus_planks", has(ModBlocks.CHORUS_PLANKS.get())).save(recipeOutput);

    }
}
