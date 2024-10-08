package com.masterfulmc.mods.mr.base;

import com.masterfulmc.mods.mr.datagen.provider.*;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface UsesDataGeneration<MODEL> {
    default void generateBlockModels(MODEL model, MRBlockModelProvider provider) {}
    default void generateItemModels(MODEL model, MRItemModelProvider provider) {}
    default void generateLanguage(MODEL model, MRLanguageProvider provider) {}
    default void generateLootTables(MODEL model, BiConsumer<ResourceLocation, LootTable.Builder> consumer) {}
    default void generateBlockTags(MODEL model, MRBlockTagsProvider provider) {}
    default void generateItemTags(MODEL model, MRItemTagsProvider provider) {}
    default void generateRecipes(MODEL model, MRRecipeProvider provider, Consumer<FinishedRecipe> consumer) {}

}
