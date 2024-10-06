package com.masterfulmc.mods.mr.event;

import com.masterfulmc.mods.mr.datagen.PackEventHandler;
import com.masterfulmc.mods.mr.setup.MRegisters;
import com.masterfulmc.mods.mr.setup.ModBlockColor;
import com.masterfulmc.mods.mr.setup.ModItemColor;
import com.masterfulmc.mods.mr.setup.loader.MaterialLoader;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SetupEventHandler {

    @SubscribeEvent
    public static void onConstruction(final FMLConstructModEvent event) {
        event.enqueueWork(() -> {
            PackEventHandler.ensureConfigPath();
            MaterialLoader.loadAll();
        });
    }

    @SubscribeEvent
    public static void onRegisterBlockColors(final RegisterColorHandlersEvent.Block event) {
        event.register(new ModBlockColor(), MRegisters.BLOCKS.getEntries().stream().map(RegistryObject::get).toArray(Block[]::new));
    }

    @SubscribeEvent
    public static void onRegisterItemColors(final RegisterColorHandlersEvent.Item event) {
        event.register(new ModItemColor(), MRegisters.ITEMS.getEntries().stream().map(RegistryObject::get).toArray(Item[]::new));
    }
}
