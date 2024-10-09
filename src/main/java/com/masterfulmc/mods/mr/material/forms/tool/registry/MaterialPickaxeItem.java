package com.masterfulmc.mods.mr.material.forms.tool.registry;

import com.masterfulmc.mods.mr.base.LayeredColored;
import com.masterfulmc.mods.mr.material.MaterialModel;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class MaterialPickaxeItem extends PickaxeItem implements LayeredColored {

    public MaterialPickaxeItem(Tier tier, Properties props, MaterialModel model) {
        super(tier, 0, 0, props);
    }

    @Override
    public int color(int layer) {
        return 0;
    }
}
