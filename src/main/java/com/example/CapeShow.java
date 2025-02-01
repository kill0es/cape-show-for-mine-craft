package com.example.capeshow;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v4.CommandRegistrationCallback;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.server.command.ServerCommandSource;

public class CapeShow implements ModInitializer {
    public static final String MOD_ID = "capeshow";

    @Override
    public void onInitialize() {
        System.out.println("CapeShow Mod has been initialized!");
        CapeManager.init();
        registerCommands();
    }

    private void registerCommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(
                LiteralArgumentBuilder.<ServerCommandSource>literal(MOD_ID)
                    .then(new CapeCommand().register())
            );
        });
    }
}
