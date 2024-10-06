package com.masterfulmc.mods.mr.base;

import com.masterfulmc.mods.mr.datagen.provider.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.function.BiConsumer;

public interface UsesDataGeneration<MODEL> {
    default void generateBlockModels(MODEL model, MRBlockModelProvider provider) {}
    default void generateItemModels(MODEL model, MRItemModelProvider provider) {}
    default void generateLanguage(MODEL model, MRLanguageProvider provider) {}
    default void generateLootTables(MODEL model, BiConsumer<ResourceLocation, LootTable.Builder> consumer) {}
    default void generateBlockTags(MODEL model, MRBlockTagsProvider provider) {}
    default void generateItemTags(MODEL model, MRItemTagsProvider provider) {}

}
