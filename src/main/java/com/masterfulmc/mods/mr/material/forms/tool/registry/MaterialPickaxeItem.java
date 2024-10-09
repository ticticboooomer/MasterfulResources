package com.masterfulmc.mods.mr.material.forms.tool.registry;

import com.masterfulmc.mods.mr.base.LayeredColored;
import com.masterfulmc.mods.mr.material.MaterialModel;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class MaterialPickaxeItem extends PickaxeItem implements LayeredColored {

    private final MaterialModel model;

    public MaterialPickaxeItem(Tier tier, Properties props, MaterialModel model) {
        super(tier, 0, 0, props);
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
