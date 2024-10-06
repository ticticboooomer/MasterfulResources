package com.masterfulmc.mods.mr.material.forms;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;


public abstract class MaterialFormType {
    public abstract IMaterialForm parse(ResourceLocation materialId, JsonObject json);
}
