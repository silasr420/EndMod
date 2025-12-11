package net.silas.endermod.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.silas.endermod.EndMod;
import net.silas.endermod.block.ModBlocks;

@Mod.EventBusSubscriber(modid = EndMod.MOD_ID)
public class ModBonemealHandler {
    @SubscribeEvent
    public static void onBonemeal(BonemealEvent event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);

        if(!state.is(Blocks.END_STONE)) return;

        boolean touchingMoss = false;
        for (var dir : Direction.values()) {
            BlockPos checkPos = pos.relative(dir);
            if (level.getBlockState(checkPos).is(ModBlocks.CHORUS_MOSS.get())) {
                touchingMoss = true;
                break;
            }
        }

        if (!touchingMoss) return;

        level.setBlock(pos, ModBlocks.CHORUS_MOSS.get().defaultBlockState(), 3);

        event.setResult(Event.Result.ALLOW);
    }

}
