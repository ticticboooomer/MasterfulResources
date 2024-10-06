package com.masterfulmc.mods.mr.material.forms.ore;

import com.google.gson.JsonObject;
import com.masterfulmc.mods.mr.material.forms.IMaterialForm;
import com.masterfulmc.mods.mr.material.forms.MaterialFormType;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class OreMaterialFormType extends MaterialFormType {

    @Override
    public IMaterialForm parse(ResourceLocation materialId, JsonObject json) {
        String dropType = json.get("dropType").getAsString();
        if (!dropType.equals("gemlike") && !dropType.equals("raw")) {
            throw new RuntimeException("Error parsing material Json: [" + materialId + "]: Invalid dropType: " + dropType + ", valid values are: [gemlike, raw]");
        }
        Optional<ResourceLocation> dropOverride = Optional.empty();
        boolean dropOverrideInJson = json.has("dropOverride");
        if (!dropType.equals("gemlike") && dropOverrideInJson) {
            throw new RuntimeException("Error parsing material Json: [" + materialId + "]: Field [dropOverride] is onlyalloes to be used when field [dropType] has value of [gemlike]: found: [dropType=raw]");
        }
        else if (dropOverrideInJson) {
            dropOverride = Optional.of(new ResourceLocation(json.get("dropOverride").toString()));
        }
        return new OreMaterialForm(dropType, dropOverride);
    }
}
