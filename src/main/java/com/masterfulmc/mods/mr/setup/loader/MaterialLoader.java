package com.masterfulmc.mods.mr.setup.loader;

import com.google.gson.JsonObject;
import com.masterfulmc.mods.mr.material.MaterialModel;
import com.masterfulmc.mods.mr.material.forms.IMaterialForm;

import java.util.ArrayList;
import java.util.List;

public class MaterialLoader extends AbstractConfigLoader<MaterialModel> {

    public static final List<MaterialModel> MATERIALS = new ArrayList<>();

    @Override
    protected String getConfigPath() {
        return "materials";
    }

    @Override
    protected List<MaterialModel> parseModels(List<JsonObject> jsons) {
        var result = new ArrayList<MaterialModel>();
        for (var json : jsons) {
            MaterialModel parsed = MaterialModel.parse(json);
            result.add(parsed);
        }
        return result;
    }

    @Override
    protected void registerModels(List<MaterialModel> materialModels) {
        MATERIALS.addAll(materialModels);
        for (MaterialModel materialModel : materialModels) {
            for (IMaterialForm form : materialModel.forms()) {
                form.registerBlocks(materialModel);
                form.registerItems(materialModel);
            }
        }
    }

    public static void loadAll() {
        var loader = new MaterialLoader();
        loader.load();
    }
}
