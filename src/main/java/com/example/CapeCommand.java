package com.example.capeshow;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import static com.mojang.brigadier.arguments.StringArgumentType.*;
import static net.minecraft.server.command.CommandManager.*;

public class CapeCommand {
    public LiteralArgumentBuilder<ServerCommandSource> register() {
        return literal("manage")
                .requires(source -> source.hasPermissionLevel(2))
                .then(literal("add")
                        .then(argument("player", EntityArgumentType.player())
                                .then(argument("capeHash", string())
                                        .executes(this::addCape))))
                .then(literal("list")
                        .then(argument("player", EntityArgumentType.player())
                                .executes(this::listCapes)))
                .then(literal("animate")
                        .then(argument("player", EntityArgumentType.player())
                                .executes(this::setAnimation)));
    }

    private int addCape(CommandContext<ServerCommandSource> context) {
        ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
        String capeHash = getString(context, "capeHash");
        CapeManager.addCape(player.getUuidAsString(), capeHash);
        context.getSource().sendFeedback(() -> Text.literal("Added cape " + capeHash + " to " + player.getName()), false);
        return 1;
    }

    private int listCapes(CommandContext<ServerCommandSource> context) {
        ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
        Set<String> capes = CapeManager.getPlayerCapes(player.getUuidAsString());
        context.getSource().sendFeedback(() -> Text.literal("Capes for " + player.getName() + ": " + String.join(", ", capes)), false);
        return 1;
    }

    private int setAnimation(CommandContext<ServerCommandSource> context) {
        ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
        // Here, you would set or toggle animation based on some rules or configuration
        context.getSource().sendFeedback(() -> Text.literal("Animation set for " + player.getName()), false);
        return 1;
    }
}
