package com.masterfulmc.mods.mr;

import com.masterfulmc.mods.mr.datagen.DataGenManager;
import com.masterfulmc.mods.mr.datagen.MRRepositorySource;
import com.masterfulmc.mods.mr.datagen.MRRepoType;
import com.masterfulmc.mods.mr.material.forms.MMaterialFormRegistry;
import com.masterfulmc.mods.mr.setup.MRegisters;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(Ref.ID)
public class ModRoot {

    public ModRoot() {
        MRegisters.register();
        MMaterialFormRegistry.init();
        DataGenManager.registerDataProviders();
        registerClientPack();
    }

    private void registerClientPack() {
        try {
            if (FMLEnvironment.dist == Dist.CLIENT) {
                Minecraft.getInstance().getResourcePackRepository()
                        .addPackFinder(new MRRepositorySource(MRRepoType.RESOURCES));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
