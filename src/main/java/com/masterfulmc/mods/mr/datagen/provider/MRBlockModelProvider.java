package com.masterfulmc.mods.mr.datagen.provider;

import com.masterfulmc.mods.mr.Ref;
import com.masterfulmc.mods.mr.material.MaterialModel;
import com.masterfulmc.mods.mr.material.forms.IMaterialForm;
import com.masterfulmc.mods.mr.setup.loader.MaterialLoader;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.loaders.CompositeModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MRBlockModelProvider extends BlockStateProvider {

    public MRBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Ref.ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (MaterialModel material : MaterialLoader.MATERIALS) {
            for (IMaterialForm form : material.forms()) {
                form.generateBlockModels(material, this);
            }
        }
    }

    public BlockModelBuilder layeredBlock(ResourceLocation loc, ResourceLocation baseTexture, ResourceLocation overlayTexture) {
        return models().getBuilder(loc.toString()).parent(new ModelFile.UncheckedModelFile(mcLoc("block/block")))
                .texture("particle", overlayTexture)
                .transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(75F, 45F, 0F)
                .translation(0F, 2.5F, 0)
                .scale(0.375F, 0.375F, 0.375F)
                .end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(75F, 45F, 0F)
                .translation(0F, 2.5F, 0)
                .scale(0.375F, 0.375F, 0.375F)
                .end()
                .end()
                .customLoader(CompositeModelBuilder::begin)
                .child("base", this.models().nested().parent(new ModelFile.UncheckedModelFile(mcLoc("block/cube_all")))
                        .texture("all", baseTexture)
                        .renderType("solid")
                )
                .child("overlay", this.models().nested().parent(new ModelFile.UncheckedModelFile(mcLoc("block/block")))
                        .texture("overlay", overlayTexture)
                        .element()
                        .from(0, 0, 0)
                        .to(16, 16, 16)
                        .allFaces((dir, uv) -> uv.texture("#overlay").uvs(0, 0, 16, 16).tintindex(1))
                        .end()
                        .renderType("translucent")
                )
                .end();
    }


}
