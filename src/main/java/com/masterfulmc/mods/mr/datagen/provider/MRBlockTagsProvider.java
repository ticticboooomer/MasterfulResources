package com.masterfulmc.mods.mr.datagen.provider;

import com.masterfulmc.mods.mr.Ref;
import com.masterfulmc.mods.mr.material.MaterialModel;
import com.masterfulmc.mods.mr.material.forms.IMaterialForm;
import com.masterfulmc.mods.mr.setup.loader.MaterialLoader;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class MRBlockTagsProvider extends BlockTagsProvider {
    public MRBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Ref.ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        for (MaterialModel material : MaterialLoader.MATERIALS) {
            for (IMaterialForm form : material.forms()) {
                form.generateBlockTags(material, this);
            }
        }
    }
}
