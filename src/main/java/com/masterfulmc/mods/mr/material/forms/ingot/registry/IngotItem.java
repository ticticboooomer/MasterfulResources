package com.masterfulmc.mods.mr.material.forms.ingot.registry;

import com.masterfulmc.mods.mr.base.LayeredColored;
import com.masterfulmc.mods.mr.material.MaterialModel;
import net.minecraft.world.item.Item;

public class IngotItem extends Item  implements LayeredColored {

    private final MaterialModel model;

    public IngotItem(MaterialModel model, Properties props) {
        super(props);
        this.model = model;
    }

    @Override
    public int color(int layer) {
        if (layer == 0) {
            return model.color();
        }
        return 0xFFFFFF;
    }
}
