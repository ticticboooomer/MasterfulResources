package com.masterfulmc.mods.mr.datagen.provider;

import com.masterfulmc.mods.mr.Ref;
import com.masterfulmc.mods.mr.material.MaterialModel;
import com.masterfulmc.mods.mr.material.forms.IMaterialForm;
import com.masterfulmc.mods.mr.setup.loader.MaterialLoader;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MRItemModelProvider extends ItemModelProvider {

    public MRItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Ref.ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (MaterialModel material : MaterialLoader.MATERIALS) {
            for (IMaterialForm form : material.forms()) {
                form.generateItemModels(material, this);
            }
        }
    }
}
