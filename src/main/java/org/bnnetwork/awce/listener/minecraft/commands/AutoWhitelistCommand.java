package org.bnnetwork.awce.listener.minecraft.commands;

import com.mojang.authlib.GameProfile;
import com.mojang.brigadier.CommandDispatcher;
import me.lucko.fabric.api.permissions.v0.Permissions;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Collection;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static com.mojang.brigadier.arguments.StringArgumentType.word;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;
import static org.bnnetwork.awce.Main.getProfileFromNickname;

@Mixin(net.minecraft.server.dedicated.command.WhitelistCommand.class)
public class AutoWhitelistCommand {
    @Invoker("executeAdd")
    private static int executeAdd(ServerCommandSource source, Collection<GameProfile> targets) {
        return 0;
    }

    @Invoker("executeRemove")
    private static int executeRemove(ServerCommandSource source, Collection<GameProfile> targets) {
        return 0;
    }

    private static void registerCommand(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("autowhitelist")
                .requires(Permissions.require("awce.commands.wl.root", 3))
                .then(literal("add")
                        .requires(Permissions.require("awce.commands.wl.add", 3))
                        .then(argument("targets", word())
                                .executes(ctx ->
                                        executeAdd(ctx.getSource(), getProfileFromNickname(getString(ctx, "targets")))
                                )
                        )
                )
                .then(literal("remove")
                        .requires(Permissions.require("awce.commands.wl.remove", 3))
                        .then(argument("targets", word())
                                .executes(ctx ->
                                        executeRemove(ctx.getSource(), getProfileFromNickname(getString(ctx, "targets")))
                                )
                        )
                )
                .then(literal("on")
                        .requires(Permissions.require("awce.commands.wl.switch.on", 3))
                        .executes(ctx -> {
                            ctx.getSource().getServer().getPlayerManager().setWhitelistEnabled(true);
                            ctx.getSource().sendFeedback(Text.translatable("awce.whitelist.enabled"), true);
                            return 1;
                        })
                )
                .then(literal("off")
                        .requires(Permissions.require("awce.commands.wl.switch.off", 3))
                        .executes(ctx -> {
                            ctx.getSource().getServer().getPlayerManager().setWhitelistEnabled(false);
                            ctx.getSource().sendFeedback(Text.translatable("awce.whitelist.disabled"), true);
                            return 1;
                        })
                )
                .then(literal("reload")
                        .requires(Permissions.require("awce.commands.wl.reload", 3))
                        .executes(ctx -> {
                            ctx.getSource().getServer().getPlayerManager().reloadWhitelist();
                            ctx.getSource().sendFeedback(Text.translatable("awce.whitelist.reloaded"), true);
                            return 1;
                        })
                )
        );
    }
}
