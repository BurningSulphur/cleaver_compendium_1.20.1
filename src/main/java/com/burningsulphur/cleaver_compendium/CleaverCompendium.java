package  com.burningsulphur.cleaver_compendium;

import appeng.items.tools.quartz.QuartzToolType;
import com.burningsulphur.cleaver_compendium.configs.SilverCleaverConfig;
import com.burningsulphur.cleaver_compendium.util.FluixCleaverItem;
import com.burningsulphur.cleaver_compendium.util.LeadCleaverItem;
import com.burningsulphur.cleaver_compendium.util.NeptuniumCleaverItem;
import com.mojang.logging.LogUtils;
import com.stal111.forbidden_arcanus.common.item.ModTiers;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.salju.kobolds.init.KoboldsItemTiers;
import org.slf4j.Logger;

import net.minecraft.world.item.Tiers;


import net.yirmiri.dungeonsdelight.common.item.*;
//it just works

import com.teamabnormals.caverns_and_chasms.core.other.CCTiers.CCItemTiers;
import galena.oreganized.index.OItemTiers;
import net.enderitemc.enderitemod.materials.EnderiteMaterial;
import com.kwpugh.gobber2.lists.tiers.ToolMaterialTiers;
import com.teammetallurgy.aquaculture.api.AquacultureAPI;


import net.minecraftforge.fml.config.ModConfig;

import static com.burningsulphur.cleaver_compendium.Config.silverCleaverDisable;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(CleaverCompendium.MOD_ID)
public class CleaverCompendium
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "cleaver_compendium";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();



    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);



    //                                                                                                                      (throw range, teir, attack damage(+2), attack speed(+4) (same), other properties)
    public static final RegistryObject<Item> EXAMPLE_CLEAVER = ITEMS.register("example_cleaver", () -> new CleaverItem(1.5F, Tiers.IRON, 2.0F, -3.0F, new Item.Properties().durability(157)));

    //public static final RegistryObject<Item> LEAD_CLEAVER = ITEMS.register("lead_cleaver", () -> new CleaverItem(1.25F, Tiers.IRON, 2.5F, -3.0F, new Item.Properties().durability(168)));

    // Create a DeferredRegister for the items
    public static final DeferredRegister<Item> OPTIONAL_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    // see if you can make a config to disable the items even if the mod is installed. all true by default, if false it won't work
    // test bool to test config
    //public static boolean CleaverEnable = true;
    //  public static final RegistryObject<Item> SILVER_CLEAVER = (ModList.get().isLoaded("caverns_and_chasms") && CleaverEnable)

    // It is IMPOSSIBLE to read the config before item registration. so instead i will configure the creative menu and the recipes

    // Register the item only if the required mod is present
    public static final RegistryObject<Item> SILVER_CLEAVER = ModList.get().isLoaded("caverns_and_chasms")
            ? OPTIONAL_ITEMS.register("silver_cleaver", () -> new CleaverItem(1.25F,CCItemTiers.SILVER, 2F, -3.0F, new Item.Properties().durability(157)))
            : null;

    public static final RegistryObject<Item> NECROMIUM_CLEAVER = ModList.get().isLoaded("caverns_and_chasms")
            ? OPTIONAL_ITEMS.register("necromium_cleaver", () -> new CleaverItem(1.75F,CCItemTiers.NECROMIUM, 4F, -3.0F, new Item.Properties().durability(2031).fireResistant()))
            : null;

    public static final RegistryObject<Item> ELECTRUM_CLEAVER = ModList.get().isLoaded("oreganized")
            ? OPTIONAL_ITEMS.register("electrum_cleaver", () -> new CleaverItem(1.75F,OItemTiers.ELECTRUM, 4F, -2.5F, new Item.Properties().durability(1561)))
            : null;

    public static final RegistryObject<Item> LEAD_CLEAVER = ModList.get().isLoaded("oreganized")
            ? OPTIONAL_ITEMS.register("lead_cleaver", () -> new LeadCleaverItem(new Item.Properties()))
            : null;

    public static final RegistryObject<Item> ROSE_GOLD_CLEAVER = ModList.get().isLoaded("cavesanddepths") // can't import the tiers from it probably due to it being mcreator.
            ? OPTIONAL_ITEMS.register("rose_gold_cleaver", () -> new CleaverItem(2F,Tiers.GOLD, 3F, -3.0F, new Item.Properties().durability(200)))
            : null;


    public static final RegistryObject<Item> ENDERITE_CLEAVER = ModList.get().isLoaded("enderitemod")
            ? OPTIONAL_ITEMS.register("enderite_cleaver", () -> new CleaverItem(3F,EnderiteMaterial.ENDERITE, 6F, -3.0F, new Item.Properties().durability(4096).fireResistant()))
            : null;


    public static final RegistryObject<Item> GOBBER_CLEAVER = ModList.get().isLoaded("gobber2")
            ? OPTIONAL_ITEMS.register("gobber2_cleaver", () -> new CleaverItem(2.25F,ToolMaterialTiers.OVERWORLD_GOBBER, 7F, -3.0F, new Item.Properties().durability(3800)))
            : null;

    public static final RegistryObject<Item> GOBBER_CLEAVER_NETHER = ModList.get().isLoaded("gobber2")
            ? OPTIONAL_ITEMS.register("gobber2_cleaver_nether", () -> new CleaverItem(2.5F,ToolMaterialTiers.NETHER_GOBBER, 8F, -3.0F, new Item.Properties().durability(5200).fireResistant()))
            : null;

    public static final RegistryObject<Item> GOBBER_CLEAVER_END = ModList.get().isLoaded("gobber2")
            ? OPTIONAL_ITEMS.register("gobber2_cleaver_end", () -> new CleaverItem(3.5F,ToolMaterialTiers.END_GOBBER, 9F, -3.0F, new Item.Properties().durability(8000)))
            : null;





    //batch 2: ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //                                                                                    (throw range, teir, attack damage(+2), attack speed(+4) (same), other properties)
    public static final RegistryObject<Item> KOBOLD_IRON_CLEAVER = ModList.get().isLoaded("kobolds")
            ? OPTIONAL_ITEMS.register("kobold_iron_cleaver", () -> new CleaverItem(1.5F, KoboldsItemTiers.KOBOLD, 2F, -2.5F, new Item.Properties().durability(1096)))
            : null;

    //AquacultureAPI.MATS.NEPTUNIUM
    // check out the neptunium shovel to get some ideas on how i could create a neptunium cleaver where the throwing distance is massive when under water
    public static final RegistryObject<Item> NEPTUNIUM_CLEAVER = ModList.get().isLoaded("aquaculture")
            ? OPTIONAL_ITEMS.register("neptunium_cleaver", () -> new NeptuniumCleaverItem(1.5F, AquacultureAPI.MATS.NEPTUNIUM, 4.5F, -3.0F, new Item.Properties().durability(1796)))
            : null;


    public static final RegistryObject<Item> CERTUS_QUARTZ_CLEAVER = ModList.get().isLoaded("ae2")
            ? OPTIONAL_ITEMS.register("certus_quartz_cleaver", () -> new CleaverItem(1.5F, QuartzToolType.CERTUS.getToolTier(), 3F, -3.0F, new Item.Properties().durability(250)))
            : null;

    public static final RegistryObject<Item> NETHER_QUARTZ_CLEAVER = ModList.get().isLoaded("ae2")
            ? OPTIONAL_ITEMS.register("nether_quartz_cleaver", () -> new CleaverItem(1.5F,QuartzToolType.NETHER.getToolTier(), 3F, -3.0F, new Item.Properties().durability(250)))
            : null;

    //add the looting 1 if you can. look at the fluix axe item class extension
    public static final RegistryObject<Item> FLUIX_CLEAVER = ModList.get().isLoaded("ae2")
            ? OPTIONAL_ITEMS.register("fluix_cleaver", () -> new FluixCleaverItem(new Item.Properties().durability(750)))
            : null;

    public static final RegistryObject<Item> DRACO_ARCANUS_CLEAVER = ModList.get().isLoaded("forbidden_arcanus")
            ? OPTIONAL_ITEMS.register("draco_arcanus_cleaver", () -> new CleaverItem(1F,ModTiers.DRACO_ARCANUS, 9F, -2.8F, new Item.Properties().durability(2661)))
            : null;

    public static final RegistryObject<Item> REINFORCED_DEORUM_CLEAVER = ModList.get().isLoaded("forbidden_arcanus")
            ? OPTIONAL_ITEMS.register("reinforced_deorum_cleaver", () -> new CleaverItem(2.0F, ModTiers.REINFORCED_DEORUM, 4.5F, -3.0F, new Item.Properties().durability(2561)))
            : null;

    //------------------------------------------------------------------------------------------------------------------------------------------------------------


    // add ember silver, dawnstone and silex





    public static final RegistryObject<CreativeModeTab> CLEAVER_COMPENDIUM_TAB = CREATIVE_MODE_TABS.register("cleaver_compendium_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("item_group." + MOD_ID + ".tab"))
            .icon(() -> EXAMPLE_CLEAVER.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(EXAMPLE_CLEAVER.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());





    // adding to creative tab if they exist
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (SILVER_CLEAVER != null && !silverCleaverDisable && event.getTab() == CLEAVER_COMPENDIUM_TAB.get()) {
            event.accept(SILVER_CLEAVER.get());
        }
        if (NECROMIUM_CLEAVER != null && event.getTab() == CLEAVER_COMPENDIUM_TAB.get()) {
            event.accept(NECROMIUM_CLEAVER.get());
        }
        if (ELECTRUM_CLEAVER != null && event.getTab() == CLEAVER_COMPENDIUM_TAB.get()) {
            event.accept(ELECTRUM_CLEAVER.get());
        }
        if (LEAD_CLEAVER != null && event.getTab() == CLEAVER_COMPENDIUM_TAB.get()) {
            event.accept(LEAD_CLEAVER.get());
        }
        if (ROSE_GOLD_CLEAVER != null && event.getTab() == CLEAVER_COMPENDIUM_TAB.get()) {
            event.accept(ROSE_GOLD_CLEAVER.get());
        }
        if (ENDERITE_CLEAVER != null && event.getTab() == CLEAVER_COMPENDIUM_TAB.get()) {
            event.accept(ENDERITE_CLEAVER.get());
        }
        if (GOBBER_CLEAVER != null && event.getTab() == CLEAVER_COMPENDIUM_TAB.get()) {
            event.accept(GOBBER_CLEAVER.get());
        }
        if (GOBBER_CLEAVER_NETHER != null && event.getTab() == CLEAVER_COMPENDIUM_TAB.get()) {
            event.accept(GOBBER_CLEAVER_NETHER.get());
        }
        if (GOBBER_CLEAVER_END != null && event.getTab() == CLEAVER_COMPENDIUM_TAB.get()) {
            event.accept(GOBBER_CLEAVER_END.get());
        }
        //batch 2
        if (KOBOLD_IRON_CLEAVER != null && event.getTab() == CLEAVER_COMPENDIUM_TAB.get()) {
            event.accept(KOBOLD_IRON_CLEAVER.get());
        }
        if (NEPTUNIUM_CLEAVER != null && event.getTab() == CLEAVER_COMPENDIUM_TAB.get()) {
            event.accept(NEPTUNIUM_CLEAVER.get());
        }
        if (CERTUS_QUARTZ_CLEAVER != null && event.getTab() == CLEAVER_COMPENDIUM_TAB.get()) {
            event.accept(CERTUS_QUARTZ_CLEAVER.get());
        }
        if (NETHER_QUARTZ_CLEAVER != null && event.getTab() == CLEAVER_COMPENDIUM_TAB.get()) {
            event.accept(NETHER_QUARTZ_CLEAVER.get());
        }
        if (FLUIX_CLEAVER != null && event.getTab() == CLEAVER_COMPENDIUM_TAB.get()) {
            event.accept(FLUIX_CLEAVER.get());
        }
        if (DRACO_ARCANUS_CLEAVER != null && event.getTab() == CLEAVER_COMPENDIUM_TAB.get()) {
            event.accept(DRACO_ARCANUS_CLEAVER.get());
        }
        if (REINFORCED_DEORUM_CLEAVER != null && event.getTab() == CLEAVER_COMPENDIUM_TAB.get()) {
            event.accept(REINFORCED_DEORUM_CLEAVER.get());
        }

    }

    public CleaverCompendium(FMLJavaModLoadingContext context)
    {

        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register the Deferred Register for conditional items
        OPTIONAL_ITEMS.register(modEventBus);

        //where all my config stuff goes

        CraftingHelper.register(new SilverCleaverConfig.Serializer());

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);

    }



    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }



    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}