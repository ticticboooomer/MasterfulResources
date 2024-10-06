package com.masterfulmc.mods.mr.setup.loader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.SneakyThrows;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public abstract class AbstractConfigLoader<TModel> {

    protected abstract String getConfigPath();

    protected abstract List<TModel> parseModels(List<JsonObject> jsons);

    protected abstract void registerModels(List<TModel> models);

    public void load() {
        var jsons = getJsons();
        var models = parseModels(jsons);
        registerModels(models);
    }

    @SneakyThrows
    private List<JsonObject> getJsons() {
        Path root = FMLPaths.CONFIGDIR.get().resolve("mr").resolve(getConfigPath());
        if (!Files.exists(root)) {
            Files.createDirectories(root);
        }
        return Files.walk(root, FileVisitOption.FOLLOW_LINKS).filter(x -> x.toString().endsWith(".json")).map(x -> {
            try {
                var file = Files.readString(x);
                return JsonParser.parseString(file).getAsJsonObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }
}