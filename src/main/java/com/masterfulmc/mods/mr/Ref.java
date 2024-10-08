package com.masterfulmc.mods.mr;

import net.minecraft.resources.ResourceLocation;

public class Ref {
    public static final String ID = "mr";

    public static ResourceLocation id(String p) {
        return new ResourceLocation(ID, p);
    }

    public static final class Textures {
        public static final ResourceLocation ORE_BLOCK_OVERLAY = id("block/ore_block_overlay");
        public static final ResourceLocation ORE_BLOCK_BASE = id("block/ore_block_base");
        public static final ResourceLocation RAW_ORE_ITEM = id("item/raw_ore");
        public static final ResourceLocation ORE_GEM_ITEM = id("item/ore_gem");
        public static final ResourceLocation INGOT_ITEM = id("item/ingot");
    }

    public static final class MaterialFormTypes {
        public static final ResourceLocation ORE = id("form/ore");
        public static final ResourceLocation INGOT = id("form/ingot");
    }
}
