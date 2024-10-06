package com.masterfulmc.mods.mr.material;

import com.masterfulmc.mods.mr.material.forms.ore.registry.OreBlock;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class ModBlockItemColor implements ItemColor {

    @Override
    public int getColor(ItemStack stack, int layer) {
        if (stack.getItem() instanceof BlockItem bItem) {
            Block block = bItem.getBlock();
            if (block instanceof OreBlock ob && layer == 1) {
                return ob.getColor();
            }
        }
        return 0xFFFFFF;
    }
}
