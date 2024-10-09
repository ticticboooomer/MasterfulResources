package com.masterfulmc.mods.mr.material.forms;

import com.google.gson.JsonObject;
import com.masterfulmc.mods.mr.Ref;
import com.masterfulmc.mods.mr.material.forms.ingot.IngotMaterialFormType;
import com.masterfulmc.mods.mr.material.forms.ore.OreMaterialFormType;
import com.masterfulmc.mods.mr.material.forms.tool.MaterialToolType;
import com.masterfulmc.mods.mr.material.forms.tool.ToolMaterialFormType;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class MMaterialFormRegistry {
    public static final Map<ResourceLocation, MaterialFormType> FORM_TYPES = new HashMap<>();

    public static void init() {
        register(Ref.MaterialFormTypes.ORE, new OreMaterialFormType());
        register(Ref.MaterialFormTypes.INGOT, new IngotMaterialFormType());
        register(Ref.MaterialFormTypes.TOOL_AXE, new ToolMaterialFormType(MaterialToolType.AXE));
        register(Ref.MaterialFormTypes.TOOL_HOE, new ToolMaterialFormType(MaterialToolType.HOE));
        register(Ref.MaterialFormTypes.TOOL_PICKAXE, new ToolMaterialFormType(MaterialToolType.PICKAXE));
        register(Ref.MaterialFormTypes.TOOL_SHOVEL, new ToolMaterialFormType(MaterialToolType.SHOVEL));
        register(Ref.MaterialFormTypes.TOOL_SWORD, new ToolMaterialFormType(MaterialToolType.SWORD));
    }

    public static MaterialFormType get(ResourceLocation id) {
        return FORM_TYPES.get(id);
    }

    public static void register(ResourceLocation id, MaterialFormType type) {
        FORM_TYPES.put(id, type);
    }

    public static IMaterialForm parseForm(JsonObject json, ResourceLocation materialId) {
        var id = ResourceLocation.tryParse(json.get("type").getAsString());
        var formType = FORM_TYPES.get(id);
        var form = formType.parse(materialId, json);
        return form;
    }
}
