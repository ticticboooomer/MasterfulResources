package com.masterfulmc.mods.mr.material.forms.tool;

import com.google.gson.JsonObject;
import com.masterfulmc.mods.mr.material.forms.IMaterialForm;
import com.masterfulmc.mods.mr.material.forms.MaterialFormType;
import net.minecraft.resources.ResourceLocation;

public class ToolMaterialFormType extends MaterialFormType {

    private final MaterialToolType type;

    public ToolMaterialFormType(MaterialToolType type) {
        this.type = type;
    }

    @Override
    public IMaterialForm parse(ResourceLocation materialId, JsonObject json) {
        var uses = json.get("uses").getAsInt();
        var speed = json.get("speed").getAsFloat();
        var attackDamage = json.get("attackDamage").getAsFloat();
        var level = json.get("level").getAsInt();
        var enchantmentValue = json.get("enchantmentValue").getAsInt();
        var repairMaterial = ResourceLocation.tryParse(json.get("repairMaterial").getAsString());

        return new ToolMaterialForm();
    }
}
