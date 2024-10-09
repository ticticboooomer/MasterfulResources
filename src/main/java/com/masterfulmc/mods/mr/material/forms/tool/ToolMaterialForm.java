package com.masterfulmc.mods.mr.material.forms.tool;

import com.masterfulmc.mods.mr.datagen.DataGenCommons;
import com.masterfulmc.mods.mr.datagen.provider.MRItemModelProvider;
import com.masterfulmc.mods.mr.datagen.provider.MRLanguageProvider;
import com.masterfulmc.mods.mr.datagen.provider.MRRecipeProvider;
import com.masterfulmc.mods.mr.material.MaterialModel;
import com.masterfulmc.mods.mr.material.forms.IMaterialForm;
import com.masterfulmc.mods.mr.setup.MRegisters;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

public class ToolMaterialForm implements IMaterialForm {

    private final Tier tier;
    private final MaterialToolType toolType;
    private RegistryObject<Item> toolItem;

    public ToolMaterialForm(Tier tier, MaterialToolType toolType) {
        this.tier = tier;
        this.toolType = toolType;
    }

    @Override
    public void registerItems(MaterialModel model) {
        toolItem = MRegisters.ITEMS.register(model.id().getPath() + toolType.getIdSuffix(), () -> toolType.createItem(tier, model));
    }

    @Override
    public void generateItemModels(MaterialModel materialModel, MRItemModelProvider provider) {
        provider.getBuilder(toolItem.getId().getPath())
                .parent(DataGenCommons.ITEM_GENERATED)
                .texture("layer0", toolType.getHandleTexture())
                .texture("layer1", toolType.getHeadTexture());
    }

    @Override
    public void generateLanguage(MaterialModel materialModel, MRLanguageProvider provider) {
        provider.add(toolItem.get(), materialModel.name() + toolType.getNameSuffix());
    }

    @Override
    public void generateRecipes(MaterialModel materialModel, MRRecipeProvider provider, Consumer<FinishedRecipe> consumer) {
    }
}
