package com.burningsulphur.cleaver_compendium;

import com.burningsulphur.cleaver_compendium.configs.CertusQuartzCleaverConfig;
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
    public static ForgeConfigSpec.BooleanValue CCNECROMIUM_CLEAVER_DISABLE;
    public static ForgeConfigSpec.BooleanValue CERTUS_QUARTZ_CLEAVER_DISABLE;
    public static ForgeConfigSpec.BooleanValue NETHER_QUARTZ_CLEAVER_DISABLE;
    public static ForgeConfigSpec.BooleanValue DCROSE_GOLD_CLEAVER_DISABLE;
    public static ForgeConfigSpec.BooleanValue DRACO_ARCANUS_CLEAVER_DISABLE;
    public static ForgeConfigSpec.BooleanValue ENDERITE_CLEAVER_DISABLE;
    public static ForgeConfigSpec.BooleanValue FLUIX_CLEAVER_DISABLE;
    public static ForgeConfigSpec.BooleanValue GOBBER_CLEAVER_DISABLE;
    public static ForgeConfigSpec.BooleanValue GOBBER_END_CLEAVER_DISABLE;
    public static ForgeConfigSpec.BooleanValue GOBBER_NETHER_CLEAVER_DISABLE;
    public static ForgeConfigSpec.BooleanValue KOBOLD_IRON_CLEAVER_DISABLE;
    public static ForgeConfigSpec.BooleanValue NEPTUNIUM_CLEAVER_DISABLE;
    public static ForgeConfigSpec.BooleanValue OELECTRUM_CLEAVER_DISABLE;
    public static ForgeConfigSpec.BooleanValue REINFORCED_DEORUM_CLEAVER_DISABLE;
    public static ForgeConfigSpec.BooleanValue DAWNSTONE_CLEAVER_DISABLE;
    public static ForgeConfigSpec.BooleanValue EMBERS_LEAD_CLEAVER_DISABLE;
    public static ForgeConfigSpec.BooleanValue EMBERS_SILVER_CLEAVER_DISABLE;
    public static ForgeConfigSpec.BooleanValue SILEX_CLEAVER_DISABLE;

    //------------------------------------------------------------------------------------------------------

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        COMMON_BUILDER.comment("Enable/Disable Cleavers");
        //--------------------------------------------------------------------------------------------TWO
        COMMON_BUILDER.comment("Caverns and Chasms");
        SILVER_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Silver cleaver (Default: false)").define("silver_cleaver_disable", false);
        CCNECROMIUM_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Necroimum cleaver (Default: false)").define("ccnecromium_cleaver_disable", false);
        COMMON_BUILDER.comment("");
        COMMON_BUILDER.comment("Oreganized");
        OLEAD_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Lead cleaver (Default: false)").define("olead_cleaver_disable", false);
        OELECTRUM_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Electrum cleaver (Default: false)").define("oelectrum_cleaver_disable", false);
        COMMON_BUILDER.comment("");
        COMMON_BUILDER.comment("Applied Energistics 2");
        CERTUS_QUARTZ_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Certus Quartz cleaver (Default: false)").define("certus_quartz_cleaver_disable", false);
        NETHER_QUARTZ_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Nether Quartz cleaver (Default: false)").define("nether_quartz_cleaver_disable", false);
        FLUIX_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Fluix cleaver (Default: false)").define("fluix_cleaver_disable", false);
        COMMON_BUILDER.comment("");
        COMMON_BUILDER.comment("Forbidden and Arcanus");
        DRACO_ARCANUS_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Draco Arcanus cleaver (Default: false)").define("draco_arcanus_cleaver_disable", false);
        REINFORCED_DEORUM_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Reinforced Deorum cleaver (Default: false)").define("reinforced_deorum_cleaver_disable", false);
        COMMON_BUILDER.comment("");
        COMMON_BUILDER.comment("Gobber");
        GOBBER_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Gobber cleaver (Default: false)").define("gobber_cleaver_disable", false);
        GOBBER_NETHER_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Nether Gobber cleaver (Default: false)").define("gobber_nether_cleaver_disable", false);
        GOBBER_END_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable End Gobber cleaver (Default: false)").define("gobber_end_cleaver_disable", false);
        COMMON_BUILDER.comment("");
        COMMON_BUILDER.comment("Embers Rekindled");
        EMBERS_LEAD_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Lead cleaver (Default: false)").define("elead_cleaver_disable", false);
        EMBERS_SILVER_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Silver cleaver (Default: false)").define("esilver_cleaver_disable", false);
        DAWNSTONE_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Dawnstone cleaver (Default: false)").define("dawnstone_cleaver_disable", false);
        COMMON_BUILDER.comment("");
        COMMON_BUILDER.comment("Other mods");
        DCROSE_GOLD_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Rose Gold cleaver from Deeper Caves (Default: false)").define("dcrose_gold_cleaver_disable", false);
        ENDERITE_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Enderite cleaver from Enderite Mod (Default: false)").define("enderite_cleaver_disable", false);
        KOBOLD_IRON_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Kobold Iron cleaver from Kobolds! (Default: false)").define("kobold_iron_cleaver_disable", false);
        NEPTUNIUM_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Neptunium cleaver from Aquaculture 2 (Default: false)").define("neptunium_cleaver_disable", false);

        COMMON_BUILDER.comment("Currently obtaining a Silex cleaver can't be disabled as it's obtained through loot tables");
        SILEX_CLEAVER_DISABLE = COMMON_BUILDER.comment("Disable Silex cleaver from Sweety's Archaeology (Default: false)").define("silex_cleaver_disable", false);

        //------------------------------------------------------------------------------------------------

        COMMON_CONFIG = COMMON_BUILDER.build();

    }

    //-----------------------------------------------------------------------------------------------THREE
    public static boolean silverCleaverDisable;
    public static boolean CCNecromiumCleaverDisable;
    public static boolean CertusQuartzCleaverDisable;
    public static boolean DCRoseGoldCleaverDisable;
    public static boolean DracoArcanusCleaverDisable;
    public static boolean EnderiteCleaverDisable;
    public static boolean FluixCleaverDisable;
    public static boolean GobberCleaverDisable;
    public static boolean GobberEndCleaverDisable;
    public static boolean GobberNetherCleaverDisable;
    public static boolean KoboldIronCleaverDisable;
    public static boolean NeptuniumCleaverDisable;
    public static boolean NetherQuartzCleaverDisable;
    public static boolean OElectrumCleaverDisable;
    public static boolean OLeadCleaverDisable;
    public static boolean ReinforcedDeorumCleaverDisable;
    public static boolean ELeadCleaverDisable;
    public static boolean ESilverCleaverDisable;
    public static boolean DawnstoneCleaverDisable;
    public static boolean SilexCleaverDisable;
    //-------------------------------------------------------------------------------------------------

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        //------------------------------------------------------------------------------------------FOUR
        silverCleaverDisable = SILVER_CLEAVER_DISABLE.get();
        OLeadCleaverDisable = OLEAD_CLEAVER_DISABLE.get();

        CCNecromiumCleaverDisable = CCNECROMIUM_CLEAVER_DISABLE.get();
        CertusQuartzCleaverDisable = CERTUS_QUARTZ_CLEAVER_DISABLE.get();
        DCRoseGoldCleaverDisable = DCROSE_GOLD_CLEAVER_DISABLE.get();
        DracoArcanusCleaverDisable = DRACO_ARCANUS_CLEAVER_DISABLE.get();
        EnderiteCleaverDisable = ENDERITE_CLEAVER_DISABLE.get();
        FluixCleaverDisable = FLUIX_CLEAVER_DISABLE.get();
        GobberCleaverDisable = GOBBER_CLEAVER_DISABLE.get();
        GobberEndCleaverDisable = GOBBER_END_CLEAVER_DISABLE.get();
        GobberNetherCleaverDisable = GOBBER_NETHER_CLEAVER_DISABLE.get();
        KoboldIronCleaverDisable = KOBOLD_IRON_CLEAVER_DISABLE.get();
        NeptuniumCleaverDisable = NEPTUNIUM_CLEAVER_DISABLE.get();
        NetherQuartzCleaverDisable = NETHER_QUARTZ_CLEAVER_DISABLE.get();
        OElectrumCleaverDisable = OELECTRUM_CLEAVER_DISABLE.get();
        ReinforcedDeorumCleaverDisable = REINFORCED_DEORUM_CLEAVER_DISABLE.get();

        ELeadCleaverDisable = EMBERS_LEAD_CLEAVER_DISABLE.get();
        ESilverCleaverDisable = EMBERS_SILVER_CLEAVER_DISABLE.get();
        DawnstoneCleaverDisable = DAWNSTONE_CLEAVER_DISABLE.get();
        SilexCleaverDisable = SILEX_CLEAVER_DISABLE.get();
        //-------------------------------------------------------------------------------------------
    }

}