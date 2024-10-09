package com.masterfulmc.mods.mr.material.forms.tool.registry;

import com.masterfulmc.mods.mr.base.LayeredColored;
import com.masterfulmc.mods.mr.material.MaterialModel;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;

public class MaterialHoeItem extends HoeItem implements LayeredColored {

    private final MaterialModel model;

    public MaterialHoeItem(Tier p_41336_, Properties p_41339_, MaterialModel model) {
        super(p_41336_, 0, 0, p_41339_);
        this.model = model;
    }

    @Override
    public int color(int layer) {
        return 0;
    }
}
