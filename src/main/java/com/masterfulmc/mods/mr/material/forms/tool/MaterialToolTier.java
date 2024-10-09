package com.masterfulmc.mods.mr.material.forms.tool;

import cpw.mods.util.Lazy;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;

public class MaterialToolTier implements Tier {

    private final int uses;
    private final float speed;
    private final float attackSpeed;
    private final int level;
    private final int enchanmentValue;
    private final ResourceLocation repairMaterial;

    private Item repairMaterialItem;

    public MaterialToolTier(int uses, float speed, float attackSpeed,
                            int level, int enchanmentValue,
                            ResourceLocation repairMaterial) {
        this.uses = uses;
        this.speed = speed;
        this.attackSpeed = attackSpeed;
        this.level = level;
        this.enchanmentValue = enchanmentValue;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackSpeed;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getEnchantmentValue() {
        return enchanmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        if (repairMaterialItem == null) {
            repairMaterialItem = ForgeRegistries.ITEMS.getValue(repairMaterial);
        }
        return Ingredient.of(repairMaterialItem);
    }
}
