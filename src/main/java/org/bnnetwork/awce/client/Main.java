package org.bnnetwork.awce.client;

import net.fabricmc.api.ModInitializer;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("modid");
    @Override
    public void onInitialize() {
        LOGGER.info(Text.translatable("awce.mod.error.client_load").toString());
        LOGGER.info(Text.translatable("awce.mod.disable").toString());
    }
}

