package com.masterfulmc.mods.mr.material.forms;

import com.masterfulmc.mods.mr.base.UsesDataGeneration;
import com.masterfulmc.mods.mr.material.MaterialModel;

public interface IMaterialForm extends UsesDataGeneration<MaterialModel> {
    default void registerBlocks(MaterialModel model) {}
    default void registerItems(MaterialModel model) {}

}
