package com.masterfulmc.mods.mr.datagen.provider;

import com.masterfulmc.mods.mr.Ref;
import com.masterfulmc.mods.mr.material.MaterialModel;
import com.masterfulmc.mods.mr.material.forms.IMaterialForm;
import com.masterfulmc.mods.mr.setup.loader.MaterialLoader;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class MRLanguageProvider extends LanguageProvider {
    public MRLanguageProvider(PackOutput output) {
        super(output, Ref.ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        for (MaterialModel material : MaterialLoader.MATERIALS) {
            for (IMaterialForm form : material.forms()) {
                form.generateLanguage(material, this);
            }
        }
    }
}
