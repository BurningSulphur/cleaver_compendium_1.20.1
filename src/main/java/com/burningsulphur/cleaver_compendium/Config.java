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
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue SILVER_CLEAVER_ENABLE = BUILDER
            .comment("Controls if the cleavers are registered when their mods are installed. There is no way to register them without their mod installed")
            .define("silverCleaverEnable", true);



    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static ForgeConfigSpec.BooleanValue getConfigOption(String key) {
        if ("silverCleaverEnable".equals(key)) {
            return SILVER_CLEAVER_ENABLE;
        }
        LOGGER.warn("Unknown configuration key requested: {}", key); // Log a warning for unknown keys
        return null;
    }

    public static boolean silverCleaverEnable;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        silverCleaverEnable = SILVER_CLEAVER_ENABLE.get();    }



}