package com.masterfulmc.mods.mr.setup;

import com.masterfulmc.mods.mr.base.LayeredColored;
import com.masterfulmc.mods.mr.material.forms.ingot.registry.IngotItem;
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
            if (bItem.getBlock() instanceof LayeredColored ob) {
                return ob.color(layer);
            }
        }
        if (stack.getItem() instanceof LayeredColored lc) {
            return lc.color(layer);
        }
        return 0xFFFFFF;
    }
}
