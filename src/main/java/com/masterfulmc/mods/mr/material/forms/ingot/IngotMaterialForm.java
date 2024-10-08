package com.masterfulmc.mods.mr.material.forms.ingot;

import com.masterfulmc.mods.mr.Ref;
import com.masterfulmc.mods.mr.datagen.DataGenCommons;
import com.masterfulmc.mods.mr.datagen.provider.MRItemModelProvider;
import com.masterfulmc.mods.mr.datagen.provider.MRLanguageProvider;
import com.masterfulmc.mods.mr.datagen.provider.MRRecipeProvider;
import com.masterfulmc.mods.mr.material.MaterialModel;
import com.masterfulmc.mods.mr.material.forms.IMaterialForm;
import com.masterfulmc.mods.mr.material.forms.ingot.registry.IngotItem;
import com.masterfulmc.mods.mr.setup.MRegisters;
import com.masterfulmc.mods.mr.util.NameUtil;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.critereon.PickedUpItemTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class IngotMaterialForm implements IMaterialForm {

    private final Optional<ResourceLocation> rawItem;
    private final boolean canSmelt;
    private final float smeltExperience;
    private final int smeltTime;
    private RegistryObject<IngotItem> ingotItem;
    private ResourceLocation rawItemId;

    public IngotMaterialForm(Optional<ResourceLocation> rawItem, boolean canSmelt, float smeltExperience, int smeltTime) {
        this.rawItem = rawItem;
        this.canSmelt = canSmelt;
        this.smeltExperience = smeltExperience;
        this.smeltTime = smeltTime;
    }

    @Override
    public void registerItems(MaterialModel model) {
        ingotItem = MRegisters.ITEMS.register(NameUtil.nameIngotItem(model.id()), () -> new IngotItem(model, new Item.Properties()));
        rawItemId = Ref.id(NameUtil.nameRawItem(model.id()));
        if (rawItem.isPresent()) {
            rawItemId = rawItem.get();
        }
    }

    @Override
    public void generateItemModels(MaterialModel materialModel, MRItemModelProvider provider) {
        provider.getBuilder(ingotItem.getId().toString())
                .parent(DataGenCommons.ITEM_GENERATED)
                .texture("layer0", Ref.Textures.INGOT_ITEM);
    }

    @Override
    public void generateRecipes(MaterialModel materialModel, MRRecipeProvider provider, Consumer<FinishedRecipe> consumer) {
        if (canSmelt) {
            var rawItem = ForgeRegistries.ITEMS.getValue(rawItemId);
            provider.oreSmelting(consumer, List.of(rawItem), RecipeCategory.MISC, ingotItem.get(), smeltExperience, smeltTime, "");
            provider.oreBlasting(consumer, List.of(rawItem), RecipeCategory.MISC, ingotItem.get(), smeltExperience, smeltTime / 2, "");
        }
    }

    @Override
    public void generateLanguage(MaterialModel materialModel, MRLanguageProvider provider) {
        provider.add(ingotItem.get(), materialModel.name() + " Ingot");
    }
}
