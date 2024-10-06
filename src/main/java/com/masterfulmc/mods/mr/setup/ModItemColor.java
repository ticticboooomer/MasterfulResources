package com.masterfulmc.mods.mr.setup;

import com.masterfulmc.mods.mr.material.forms.ore.registry.OreBlock;
import com.masterfulmc.mods.mr.material.forms.ore.registry.RawOreItem;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class ModItemColor implements ItemColor {

    @Override
    public int getColor(ItemStack stack, int layer) {
        if (stack.getItem() instanceof BlockItem bItem) {
            Block block = bItem.getBlock();
            if (block instanceof OreBlock ob && layer == 1) {
                return ob.getColor();
            }
        }
        if (stack.getItem() instanceof RawOreItem) {
            RawOreItem rawOreItem = (RawOreItem) stack.getItem();
            return rawOreItem.getColor();

        }
        return 0xFFFFFF;
    }
}
