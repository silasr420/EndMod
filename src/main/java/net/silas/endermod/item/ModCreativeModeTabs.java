package net.silas.endermod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.silas.endermod.EndMod;
import net.silas.endermod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EndMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> END_TAB = CREATIVE_MODE_TABS.register("end_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Blocks.END_STONE))
                    .title(Component.translatable("creativetab.the_end"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(new ItemStack(ModBlocks.CHORUS_MOSS.get()));
                        output.accept(new ItemStack(ModBlocks.CHORUS_SPROUTS.get()));

                        output.accept(new ItemStack(ModBlocks.CHORUS_LOG.get()));
                        output.accept(new ItemStack(ModBlocks.STRIPPED_CHORUS_LOG.get()));
                        output.accept(new ItemStack(ModBlocks.CHORUS_WOOD.get()));
                        output.accept(new ItemStack(ModBlocks.STRIPPED_CHORUS_WOOD.get()));

                        output.accept(new ItemStack(ModBlocks.CHORUS_LEAVES.get()));
                        output.accept(new ItemStack(ModBlocks.CHORUS_SAPLING.get()));
                        output.accept(new ItemStack(ModBlocks.CHORUS_PLANKS.get()));

                        output.accept(new ItemStack(ModBlocks.CHORUS_STAIRS.get()));
                        output.accept(new ItemStack(ModBlocks.CHORUS_SLAB.get()));

                        output.accept(new ItemStack(ModBlocks.CHORUS_BUTTON.get()));
                        output.accept(new ItemStack(ModBlocks.CHORUS_PRESSURE_PLATE.get()));

                        output.accept(new ItemStack(ModBlocks.CHORUS_FENCE_GATE.get()));
                        output.accept(new ItemStack(ModBlocks.CHORUS_FENCE.get()));
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
