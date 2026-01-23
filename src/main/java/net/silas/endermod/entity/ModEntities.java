package net.silas.endermod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silas.endermod.EndMod;
import net.silas.endermod.entity.custom.ChorusRaccoonEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EndMod.MOD_ID);

    public static final RegistryObject<EntityType<ChorusRaccoonEntity>> CHORUS_RACCOON =
            ENTITY_TYPES.register("chorus_raccoon", () -> EntityType.Builder.of(ChorusRaccoonEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.4f).build("chorus_raccoon"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
