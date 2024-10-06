package com.masterfulmc.mods.mr.material;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.masterfulmc.mods.mr.material.forms.IMaterialForm;
import com.masterfulmc.mods.mr.material.forms.MMaterialFormRegistry;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public record MaterialModel(
        ResourceLocation id,
        String name,
        int color,
        List<IMaterialForm> forms
) {

    public static MaterialModel parse(JsonObject json) {
        var id = new ResourceLocation(json.get("id").getAsString());
        String name = json.get("name").getAsString();
        int color = json.get("color").getAsInt();

        var forms = new ArrayList<IMaterialForm>();
        JsonArray formsJson = json.getAsJsonArray("forms");
        for (JsonElement element : formsJson) {
            JsonObject o = element.getAsJsonObject();
            IMaterialForm form = MMaterialFormRegistry.parseForm(o, id);
            forms.add(form);
        }

        return new MaterialModel(id, name, color, forms);
    }
}
