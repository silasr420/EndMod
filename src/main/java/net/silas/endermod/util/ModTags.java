package net.silas.endermod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.silas.endermod.EndMod;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> CHORUS_LOGS = createTag("chorus_logs");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(EndMod.MOD_ID, name));
        }
    }
}
