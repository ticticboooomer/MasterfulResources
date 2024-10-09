package com.masterfulmc.mods.mr.material.forms.tool.registry;

import com.masterfulmc.mods.mr.base.LayeredColored;
import com.masterfulmc.mods.mr.material.MaterialModel;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import org.apache.commons.lang3.NotImplementedException;

public class MaterialShovelItem extends ShovelItem implements LayeredColored {

    private final MaterialModel model;

    public MaterialShovelItem(Tier tier,  Properties props, MaterialModel model) {
        super(tier, 0, 0, props);
        this.model = model;
    }

    @Override
    public int color(int layer) {
        throw new NotImplementedException();
    }
}
