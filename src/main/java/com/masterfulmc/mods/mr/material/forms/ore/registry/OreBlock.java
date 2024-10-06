package com.masterfulmc.mods.mr.material.forms.ore.registry;

import com.masterfulmc.mods.mr.material.MaterialModel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class OreBlock extends Block {

    private final MaterialModel model;

    public OreBlock(MaterialModel model) {
        super(Properties.of().destroyTime(5)
                .explosionResistance(5).requiresCorrectToolForDrops()
                .sound(SoundType.STONE));
        this.model = model;
    }

    public int getColor() {
        return model.color();
    }
}