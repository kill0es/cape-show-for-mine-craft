package com.example.capeshow;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AnimationConfig {
    private static final File CONFIG_FILE = new File(FabricLoader.getInstance().getConfigDir().toFile(), "capeshow_animation.json");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static Map<String, AnimationRule> rules = new HashMap<>();

    static class AnimationRule {
        boolean enabled;
        int intervalMs; // milliseconds between each change
    }

    public static void load() {
        if (CONFIG_FILE.exists()) {
            try (Reader reader = new FileReader(CONFIG_FILE)) {
                rules = GSON.fromJson(reader, new HashMap<String, AnimationRule>(){}.getClass());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            save(); // Create default config if it doesn't exist
        }
    }

    public static void save() {
        try (Writer writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(rules, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setRule(String playerUUID, boolean enabled, int intervalMs) {
        rules.put(playerUUID, new AnimationRule(){{
            this.enabled = enabled;
            this.intervalMs = intervalMs;
        }});
        save();
    }

    public static AnimationRule getRule(String playerUUID) {
        return rules.getOrDefault(playerUUID, new AnimationRule(){{
            enabled = false;
            intervalMs = 1000; // default to 1 second
        }});
    }
}
