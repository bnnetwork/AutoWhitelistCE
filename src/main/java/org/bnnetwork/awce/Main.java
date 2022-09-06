package org.bnnetwork.awce;

import com.mojang.authlib.GameProfile;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.text.Text;
import net.minecraft.util.dynamic.DynamicSerializableUuid;
import org.bnnetwork.awce.listener.minecraft.commands.AutoWhitelistCommand;
import org.bnnetwork.awce.utils.Init;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;

public class Main implements ModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("modid");

    public static final Logger getLogger() {
        return LOGGER;
    }

    public static Collection<GameProfile> getProfileFromNickname(String name) {
        return Collections.singletonList(new GameProfile(DynamicSerializableUuid.getOfflinePlayerUuid(name), name));
    }

    public static void onDisable() {
        //TODO ½ûÓÃMod
    }

    @Override
    public void onInitialize() {
        LOGGER.info(Text.translatable("awce.mod.enable").toString());
        LOGGER.info(Text.translatable("awce.mod.init").toString());
        Init.Init();
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated, environment) -> {
            //TODO ×¢²áÃüÁî
        });
    }
}
