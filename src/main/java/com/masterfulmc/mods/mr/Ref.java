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
        public static final ResourceLocation TOOL_AXE_HANDLE = id("item/axe_handle");
        public static final ResourceLocation TOOL_AXE_HEAD = id("item/axe_head");
        public static final ResourceLocation TOOL_PICKAXE_HANDLE = id("item/pickaxe_handle");
        public static final ResourceLocation TOOL_PICKAXE_HEAD = id("item/pickaxe_head");
        public static final ResourceLocation TOOL_HOE_HANDLE = id("item/hoe_handle");
        public static final ResourceLocation TOOL_HOE_HEAD = id("item/hoe_head");
        public static final ResourceLocation TOOL_SHOVEL_HANDLE = id("item/shovel_handle");
        public static final ResourceLocation TOOL_SHOVEL_HEAD = id("item/shovel_head");
        public static final ResourceLocation TOOL_SWORD_HANDLE = id("item/sword_handle");
        public static final ResourceLocation TOOL_SWORD_HEAD = id("item/sword_head");
    }

    public static final class MaterialFormTypes {
        public static final ResourceLocation ORE = id("form/ore");
        public static final ResourceLocation INGOT = id("form/ingot");
        public static final ResourceLocation TOOL_AXE = id("form/tool/axe");
        public static final ResourceLocation TOOL_HOE = id("form/tool/hoe");
        public static final ResourceLocation TOOL_PICKAXE = id("form/tool/pickaxe");
        public static final ResourceLocation TOOL_SHOVEL = id("form/tool/shovel");
        public static final ResourceLocation TOOL_SWORD = id("form/tool/sword");
    }
}
