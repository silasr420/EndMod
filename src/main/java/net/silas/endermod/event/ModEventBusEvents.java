package net.silas.endermod.event;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.silas.endermod.EndMod;
import net.silas.endermod.entity.ModEntities;
import net.silas.endermod.entity.client.ChorusRaccoonModel;
import net.silas.endermod.entity.client.ModModelLayers;
import net.silas.endermod.entity.custom.ChorusRaccoonEntity;

@Mod.EventBusSubscriber(modid = EndMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.CHORUS_RACCOON, ChorusRaccoonModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CHORUS_RACCOON.get(), ChorusRaccoonEntity.createAttributes().build());
    }
}
