package com.masterfulmc.mods.mr.datagen;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.masterfulmc.mods.mr.datagen.provider.*;
import net.minecraft.DetectedVersion;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.ModLoader;
import net.minecraftforge.fml.loading.FMLEnvironment;

import java.util.concurrent.CompletableFuture;

public class DataGenManager {

    private static DataGenerator generator;
    private static boolean hasGenerated = false;

    public static void generate() {
        if (!hasGenerated) {
            try {
                if (!ModLoader.isLoadingStateValid()) {
                    return;
                }
                generator.run();
                hasGenerated = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void registerDataProviders() {
        generator = createDataGenerator();
        ExistingFileHelper efh = new ExistingFileHelper(ImmutableList.of(), ImmutableSet.of(), false, null, null);
        CompletableFuture<HolderLookup.Provider> lookupProvider = CompletableFuture.supplyAsync(() -> RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY));
        generator.addProvider(true, new MRLootTableProvider(generator.getPackOutput()));
        MRBlockTagsProvider blockTagProvider = new MRBlockTagsProvider(generator.getPackOutput(), lookupProvider, efh);
        generator.addProvider(true, blockTagProvider);
        CompletableFuture<TagsProvider.TagLookup<Block>> blockTagLookup = blockTagProvider.contentsGetter();
        generator.addProvider(true, new MRItemTagsProvider(generator.getPackOutput(), lookupProvider, blockTagLookup, efh));
        generator.addProvider(true, new MRRecipeProvider(generator.getPackOutput()));

        if (FMLEnvironment.dist != Dist.DEDICATED_SERVER) {
            generator.addProvider(true, new MRBlockModelProvider(generator.getPackOutput(), efh));
            generator.addProvider(true, new MRItemModelProvider(generator.getPackOutput(), efh));
            generator.addProvider(true, new MRLanguageProvider(generator.getPackOutput()));
        }
    }

    public static DataGenerator createDataGenerator() {
        generator = new DataGenerator(MRRepositorySource.CONFIG_DIR, DetectedVersion.tryDetectVersion(), true);
        return DataGenManager.generator;
    }
}