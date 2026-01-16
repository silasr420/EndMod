package net.silas.endermod.worldgen.biome;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.silas.endermod.block.ModBlocks;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource END_STONE = makeStateRule(Blocks.END_STONE);
    private static final SurfaceRules.RuleSource CHORUS_MOSS = makeStateRule(ModBlocks.CHORUS_MOSS.get());



    public static SurfaceRules.RuleSource makeChorusForestRules() {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.CHORUS_FOREST), END_STONE),
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, CHORUS_MOSS)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
