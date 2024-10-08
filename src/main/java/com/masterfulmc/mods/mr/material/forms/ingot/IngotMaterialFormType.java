package com.masterfulmc.mods.mr.material.forms.ingot;

import com.google.gson.JsonObject;
import com.masterfulmc.mods.mr.material.forms.IMaterialForm;
import com.masterfulmc.mods.mr.material.forms.MaterialFormType;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class IngotMaterialFormType extends MaterialFormType {

    @Override
    public IMaterialForm parse(ResourceLocation materialId, JsonObject json) {
        Optional<ResourceLocation> rawItem = Optional.empty();
        if (json.has("rawItem")) {
            rawItem = Optional.of(new ResourceLocation(json.get("rawItem").getAsString()));
        }

        boolean canSmelt = true;
        if (json.has("canSmelt")) {
            canSmelt = json.get("canSmelt").getAsBoolean();
        }

        float exp = 0.7f;
        if (json.has("smeltExperience")) {
            exp = json.get("smeltExperience").getAsFloat();
        }

        int smeltTime = 200;
        if (json.has("smeltTime")) {
            smeltTime = json.get("smeltTime").getAsInt();
        }

        return new IngotMaterialForm(rawItem, canSmelt, exp, smeltTime);
    }
}
