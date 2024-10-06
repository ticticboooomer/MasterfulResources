package com.masterfulmc.mods.mr.datagen;

import lombok.SneakyThrows;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.nio.file.Files;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PackEventHandler {

    @SubscribeEvent
    public static void on(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.SERVER_DATA) {
            event.addRepositorySource(new MRRepositorySource(MRRepoType.DATA));
        } else {
            event.addRepositorySource(new MRRepositorySource(MRRepoType.RESOURCES));
        }
    }

    @SneakyThrows
    public static void ensureConfigPath() {
        if (!Files.exists(MRRepositorySource.CONFIG_DIR)) {
            Files.createDirectories(MRRepositorySource.CONFIG_DIR);
        }
    }
}