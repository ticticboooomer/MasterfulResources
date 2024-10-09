package com.masterfulmc.mods.mr.material.forms.tool.registry;

import com.masterfulmc.mods.mr.base.LayeredColored;
import com.masterfulmc.mods.mr.material.MaterialModel;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class MaterialSwordItem extends SwordItem implements LayeredColored {

    private final MaterialModel model;

    public MaterialSwordItem(Tier p_43269_, Properties p_43272_, MaterialModel model) {
        super(p_43269_, 0, 0, p_43272_);
        this.model = model;
    }

    @Override
    public int color(int layer) {
        if (layer == 1) {
            return model.color();
        }
        return 0xFFFFFF;
    }
}
