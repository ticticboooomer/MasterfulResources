package com.masterfulmc.mods.mr.material.forms.ore.registry;

import com.masterfulmc.mods.mr.material.MaterialModel;
import net.minecraft.world.item.Item;

public class RawOreItem extends Item {

    private final MaterialModel model;

    public RawOreItem(Properties p_41383_, MaterialModel model) {
        super(p_41383_);
        this.model = model;
    }

    public int getColor() {
        return model.color();
    }
}
