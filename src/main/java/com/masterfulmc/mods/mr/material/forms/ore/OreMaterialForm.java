package com.masterfulmc.mods.mr.material.forms.ore;

import com.masterfulmc.mods.mr.Ref;
import com.masterfulmc.mods.mr.datagen.provider.MRBlockModelProvider;
import com.masterfulmc.mods.mr.datagen.provider.MRBlockTagsProvider;
import com.masterfulmc.mods.mr.datagen.provider.MRItemModelProvider;
import com.masterfulmc.mods.mr.datagen.provider.MRLanguageProvider;
import com.masterfulmc.mods.mr.material.MaterialModel;
import com.masterfulmc.mods.mr.material.forms.IMaterialForm;
import com.masterfulmc.mods.mr.material.forms.ore.registry.OreBlock;
import com.masterfulmc.mods.mr.material.forms.ore.registry.RawOreItem;
import com.masterfulmc.mods.mr.setup.MRegisters;
import com.masterfulmc.mods.mr.util.NameUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;

public class OreMaterialForm implements IMaterialForm {

    private final String dropType;
    private final Optional<ResourceLocation> dropOverride;

    private RegistryObject<Block> oreBlock;
    private RegistryObject<Item> oreBlockItem;
    private RegistryObject<Item> rawItem;

    public OreMaterialForm(String dropType, Optional<ResourceLocation> dropOverride) {
        this.dropType = dropType;
        this.dropOverride = dropOverride;
    }

    @Override
    public void registerBlocks(MaterialModel model) {
        oreBlock = MRegisters.BLOCKS.register(NameUtil.nameOreBlock(model.id()), () -> new OreBlock(model));
    }

    @Override
    public void registerItems(MaterialModel model) {
        var name = NameUtil.nameRawItem(model.id());
        if (dropType.equals("gemlike")) {
            name = model.id().getPath();
        }
        rawItem = MRegisters.ITEMS.register(name, () -> new RawOreItem(new Item.Properties(), model));
        oreBlockItem = MRegisters.ITEMS.register(oreBlock.getId().getPath(), () -> new BlockItem(oreBlock.get(), new Item.Properties()));
    }

    @Override
    public void generateBlockModels(MaterialModel materialModel, MRBlockModelProvider provider) {
        provider.layeredBlock(oreBlock.getId(), Ref.Textures.ORE_BLOCK_BASE, Ref.Textures.ORE_BLOCK_OVERLAY);
        provider.simpleBlock(oreBlock.get());
    }

    @Override
    public void generateItemModels(MaterialModel materialModel, MRItemModelProvider provider) {
        provider.getBuilder(oreBlock.getId().toString()).parent(new ModelFile.UncheckedModelFile(Ref.id("block/" + oreBlock.getId().getPath())));
        var dropItemModel = provider.getBuilder(rawItem.getId().toString())
                .parent(new ModelFile.UncheckedModelFile(new ResourceLocation("item/generated")));

        if (dropType.equals("raw")) {
            dropItemModel.texture("layer0", Ref.Textures.RAW_ORE_ITEM);
        } else {
            dropItemModel.texture("layer0", Ref.Textures.ORE_GEM_ITEM);
        }
    }

    @Override
    public void generateLanguage(MaterialModel materialModel, MRLanguageProvider provider) {
        provider.add(oreBlock.get(), materialModel.name() + " Ore");
        if (dropType.equals("raw")) {
            provider.add(rawItem.get(), "Raw " + materialModel.name());
        } else {
            provider.add(rawItem.get(), materialModel.name());
        }
    }

    @Override
    public void generateLootTables(MaterialModel materialModel, BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        LootPool.Builder pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1f)).add(LootItem.lootTableItem(rawItem.get()));
        if (dropOverride.isPresent()) {
            pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1f)).add(LootItem.lootTableItem(
                    Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(dropOverride.get()))));
        }
        consumer.accept(Ref.id("blocks/" + oreBlock.getId().getPath()), LootTable.lootTable().withPool(pool));
    }

    @Override
    public void generateBlockTags(MaterialModel materialModel, MRBlockTagsProvider provider) {
        provider.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(oreBlock.get());
    }
}
