package com.masterfulmc.mods.mr.material.forms.tool;

import com.masterfulmc.mods.mr.Ref;
import com.masterfulmc.mods.mr.material.MaterialModel;
import com.masterfulmc.mods.mr.material.forms.tool.registry.*;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;

import java.util.function.BiFunction;

@Getter
public enum MaterialToolType {
    AXE("_axe", " Axe", (m, t) -> new MaterialAxeItem(t, new Item.Properties(), m), Ref.Textures.TOOL_AXE_HANDLE, Ref.Textures.TOOL_AXE_HEAD),
    HOE("_hoe", " Hoe", (m, t) -> new MaterialHoeItem(t, new Item.Properties(), m), Ref.Textures.TOOL_HOE_HANDLE, Ref.Textures.TOOL_HOE_HEAD),
    PICKAXE("_pickaxe", " Pickaxe", (m, t) -> new MaterialPickaxeItem(t, new Item.Properties(), m), Ref.Textures.TOOL_PICKAXE_HANDLE, Ref.Textures.TOOL_PICKAXE_HEAD),
    SHOVEL("_shovel", " Shovel", (m, t) -> new MaterialShovelItem(t, new Item.Properties(), m), Ref.Textures.TOOL_SHOVEL_HANDLE, Ref.Textures.TOOL_SHOVEL_HEAD),
    SWORD("_sword", " Sword", (m, t) -> new MaterialSwordItem(t, new Item.Properties(), m), Ref.Textures.TOOL_SWORD_HANDLE, Ref.Textures.TOOL_SWORD_HEAD),
    ;
    private final String idSuffix;
    private final String nameSuffix;
    private final BiFunction<MaterialModel, Tier, ? extends Item> itemFactory;
    private final ResourceLocation handleTexture;
    private final ResourceLocation headTexture;

    MaterialToolType(String idSuffix, String nameSuffix, BiFunction<MaterialModel, Tier, ? extends Item> itemFactory,
                     ResourceLocation handleTexture, ResourceLocation headTexture) {
        this.idSuffix = idSuffix;
        this.nameSuffix = nameSuffix;
        this.itemFactory = itemFactory;
        this.handleTexture = handleTexture;
        this.headTexture = headTexture;
    }

    public Item createItem(Tier tier, MaterialModel model) {
        return itemFactory.apply(model, tier);
    }
}
