package com.masterfulmc.mods.mr.setup;

import com.masterfulmc.mods.mr.base.LayeredColored;
import com.masterfulmc.mods.mr.material.forms.ore.registry.OreBlock;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ModBlockColor implements BlockColor {
    @Override
    public int getColor(BlockState state, @Nullable BlockAndTintGetter getter, @Nullable BlockPos pod, int layer) {
        if (state.getBlock() instanceof LayeredColored oreBlock) {
            oreBlock.color(layer);
        }
        return 0xFFFFFF;
    }
}
