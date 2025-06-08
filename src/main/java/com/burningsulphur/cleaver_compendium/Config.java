package com.burningsulphur.cleaver_compendium;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Mod.EventBusSubscriber(modid = com.burningsulphur.cleaver_compendium.CleaverCompendium.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);
    private static final ForgeConfigSpec.Builder COMMON_BUILDER  = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec COMMON_CONFIG;

    public static ForgeConfigSpec.BooleanValue SILVER_CLEAVER_DISABLE;
    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        COMMON_BUILDER.comment("Enable/Disable Cleavers");
        SILVER_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Silver cleaver from Cavers and chasms(Default: false)").define("silver_cleaver_disable", true);
        COMMON_CONFIG = COMMON_BUILDER.build();

    }


    public static ForgeConfigSpec.BooleanValue getConfigOption(String key) {
        if ("silver_cleaver_disable".equals(key)) {
            return SILVER_CLEAVER_DISABLE;
        }
        LOGGER.warn("Unknown configuration key requested: {}", key); // Log a warning for unknown keys
        return null;
    }

    public static boolean silverCleaverDisable;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        silverCleaverDisable = SILVER_CLEAVER_DISABLE.get();
    }

}