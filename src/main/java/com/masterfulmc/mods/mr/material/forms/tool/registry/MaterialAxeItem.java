package com.masterfulmc.mods.mr.material.forms.tool.registry;

import com.masterfulmc.mods.mr.base.LayeredColored;
import com.masterfulmc.mods.mr.material.MaterialModel;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

public class MaterialAxeItem extends AxeItem implements LayeredColored {

    private final MaterialModel model;

    public MaterialAxeItem(Tier p_40521_, Properties p_40524_, MaterialModel model) {
        super(p_40521_, 0, 0, p_40524_);
        this.model = model;
    }

    @Override
    public int color(int layer) {
        return 0;
    }
}
