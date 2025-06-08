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


    //----------------------------------------------------------------------------------------------------ONE
    public static ForgeConfigSpec.BooleanValue SILVER_CLEAVER_DISABLE;
    public static ForgeConfigSpec.BooleanValue OLEAD_CLEAVER_DISABLE;

    //------------------------------------------------------------------------------------------------------

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        COMMON_BUILDER.comment("Enable/Disable Cleavers");
        //--------------------------------------------------------------------------------------------TWO
        SILVER_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Silver cleaver from Caverns and Chasms (Default: false)").define("silver_cleaver_disable", false);
        OLEAD_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Lead cleaver from Oreganized (Default: false)").define("olead_cleaver_disable", false);
        //------------------------------------------------------------------------------------------------

        COMMON_CONFIG = COMMON_BUILDER.build();

    }

    //-----------------------------------------------------------------------------------------------THREE
    public static boolean silverCleaverDisable;
    public static boolean OLeadCleaverDisable;
    //-------------------------------------------------------------------------------------------------

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        //------------------------------------------------------------------------------------------FOUR
        silverCleaverDisable = SILVER_CLEAVER_DISABLE.get();
        OLeadCleaverDisable = OLEAD_CLEAVER_DISABLE.get();
        //-------------------------------------------------------------------------------------------
    }

}