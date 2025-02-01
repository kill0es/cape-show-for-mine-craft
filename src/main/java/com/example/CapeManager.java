package com.example.capeshow;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.minecraft.server.network.ServerPlayerEntity;
import java.io.*;
import java.util.*;

public class CapeManager {
    private static final File CAPE_DATABASE = new File("./config/capeshow/cape_database.json");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static Map<String, Set<String>> capeData = new HashMap<>();

    public static void init() {
        if (!CAPE_DATABASE.exists()) {
            CAPE_DATABASE.getParentFile().mkdirs();
            try (Writer writer = new FileWriter(CAPE_DATABASE)) {
                GSON.toJson(new HashMap<>(), writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            loadCapeData();
        }
    }

    private static void loadCapeData() {
        try (Reader reader = new FileReader(CAPE_DATABASE)) {
            capeData = GSON.fromJson(reader, new TypeToken<Map<String, Set<String>>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (capeData == null) {
            capeData = new HashMap<>();
        }
    }

    public static void saveCapeData() {
        try (Writer writer = new FileWriter(CAPE_DATABASE)) {
            GSON.toJson(capeData, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addCape(String playerUUID, String capeHash) {
        capeData.computeIfAbsent(playerUUID, k -> new HashSet<>()).add(capeHash);
        saveCapeData();
    }

    public static Set<String> getPlayerCapes(String playerUUID) {
        return capeData.getOrDefault(playerUUID, new HashSet<>());
    }
}
