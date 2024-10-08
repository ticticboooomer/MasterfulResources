package com.masterfulmc.mods.mr.util;

import net.minecraft.resources.ResourceLocation;

public class NameUtil {

    public static String nameOreBlock(ResourceLocation materialId) {
        return materialId.getPath() + "_ore";
    }

    public static String nameRawItem(ResourceLocation materialId) {
        return "raw_" + materialId.getPath();
    }

    public static String nameIngotItem(ResourceLocation materialId) {
        return materialId.getPath() + "_ingot";
    }
}
