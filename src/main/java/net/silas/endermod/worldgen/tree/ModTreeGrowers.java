package net.silas.endermod.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.silas.endermod.EndMod;
import net.silas.endermod.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower CHORUS = new TreeGrower(EndMod.MOD_ID + ":chorus",
            Optional.empty(), Optional.of(ModConfiguredFeatures.CHORUS_TREE_KEY), Optional.empty());
}
