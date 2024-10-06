package com.masterfulmc.mods.mr.datagen.provider;

import com.masterfulmc.mods.mr.material.MaterialModel;
import com.masterfulmc.mods.mr.material.forms.IMaterialForm;
import com.masterfulmc.mods.mr.material.forms.MMaterialFormRegistry;
import com.masterfulmc.mods.mr.setup.loader.MaterialLoader;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;

public class MRLootTableProvider extends LootTableProvider {
    public MRLootTableProvider(PackOutput p_254123_) {
        super(p_254123_, Set.of(),
                List.of(new SubProviderEntry(MRSubProvider::new, LootContextParamSets.BLOCK)));
    }

    public static class MRSubProvider implements LootTableSubProvider {
        @Override
        public void generate(BiConsumer<ResourceLocation, LootTable.Builder> biConsumer) {
            for (MaterialModel material : MaterialLoader.MATERIALS) {
                for (IMaterialForm form : material.forms()) {
                    form.generateLootTables(material, biConsumer);
                }
            }
        }
    }
}
