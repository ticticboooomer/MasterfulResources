package com.masterfulmc.mods.mr.material.forms.tool;

import com.masterfulmc.mods.mr.material.MaterialModel;
import com.masterfulmc.mods.mr.material.forms.tool.registry.*;
import lombok.Getter;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;

import java.util.function.BiFunction;

@Getter
public enum MaterialToolType {
    AXE("_axe", " Axe", (m, t) -> new MaterialAxeItem(t, new Item.Properties(), m)),
    HOE("_hoe", " Hoe", (m, t) -> new MaterialHoeItem(t, new Item.Properties(), m)),
    PICKAXE("_pickaxe", " Pickaxe", (m, t) -> new MaterialPickaxeItem(t, new Item.Properties(), m)),
    SHOVEL("_shovel", " Shovel", (m, t) -> new MaterialShovelItem(t, new Item.Properties(), m)),
    SWORD("_sword", " Sword", (m, t) -> new MaterialSwordItem(t, new Item.Properties(), m))
    ;
    private final String idSuffix;
    private final String nameSuffix;
    private final BiFunction<MaterialModel, Tier, ? extends Item> itemFactory;

    MaterialToolType(String idSuffix, String nameSuffix, BiFunction<MaterialModel, Tier, ? extends Item> itemFactory) {
        this.idSuffix = idSuffix;
        this.nameSuffix = nameSuffix;
        this.itemFactory = itemFactory;
    }

    public Item createItem(Tier tier, MaterialModel model) {
        return itemFactory.apply(model, tier);
    }
}
