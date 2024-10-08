package com.masterfulmc.mods.mr.material.forms.ore.registry;

import com.masterfulmc.mods.mr.base.LayeredColored;
import com.masterfulmc.mods.mr.material.MaterialModel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class OreBlock extends Block implements LayeredColored {

    private final MaterialModel model;

    public OreBlock(MaterialModel model) {
        super(Properties.of().destroyTime(5)
                .explosionResistance(5).requiresCorrectToolForDrops()
                .sound(SoundType.STONE));
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