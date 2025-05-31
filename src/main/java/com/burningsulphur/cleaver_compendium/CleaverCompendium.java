package  com.burningsulphur.cleaver_compendium;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import net.minecraft.world.item.Tiers;


import net.yirmiri.dungeonsdelight.common.item.*;
//it just works

import com.teamabnormals.caverns_and_chasms.core.other.CCTiers.CCItemTiers;





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

    // Register the item only if the required mod is present
    public static final RegistryObject<Item> SILVER_CLEAVER = ModList.get().isLoaded("caverns_and_chasms")
            ? OPTIONAL_ITEMS.register("silver_cleaver", () -> new CleaverItem(1.25F,CCItemTiers.SILVER, 2F, -3.0F, new Item.Properties().durability(168)))
            : null;

    public static final RegistryObject<Item> NECROMIUM_CLEAVER = ModList.get().isLoaded("caverns_and_chasms")
            ? OPTIONAL_ITEMS.register("necromium_cleaver", () -> new CleaverItem(1.75F,CCItemTiers.NECROMIUM, 4F, -3.0F, new Item.Properties().durability(2031)))
            : null;

    public static final RegistryObject<Item> ELECTRUM_CLEAVER = ModList.get().isLoaded("oreganized")
            ? OPTIONAL_ITEMS.register("electrum_cleaver", () -> new CleaverItem(1.75F,Tiers.IRON, 4F, -2.5F, new Item.Properties().durability(168)))
            : null;

    public static final RegistryObject<Item> LEAD_CLEAVER = ModList.get().isLoaded("oreganized")
            ? OPTIONAL_ITEMS.register("lead_cleaver", () -> new CleaverItem(1.5F,Tiers.IRON, 2F, -3.0F, new Item.Properties().durability(168)))
            : null;

    public static final RegistryObject<Item> ROSE_GOLD_CLEAVER = ModList.get().isLoaded("cavesanddepths")
            ? OPTIONAL_ITEMS.register("rose_gold_cleaver", () -> new CleaverItem(2F,Tiers.IRON, 3F, -3.0F, new Item.Properties().durability(168)))
            : null;


    public static final RegistryObject<Item> ENDERITE_CLEAVER = ModList.get().isLoaded("enderitemod")
            ? OPTIONAL_ITEMS.register("enderite_cleaver", () -> new CleaverItem(2F,Tiers.IRON, 6F, -3.0F, new Item.Properties().durability(168)))
            : null;


    public static final RegistryObject<Item> GOBBER_CLEAVER = ModList.get().isLoaded("gobber2")
            ? OPTIONAL_ITEMS.register("gobber2_cleaver", () -> new CleaverItem(2.25F,Tiers.IRON, 7F, -3.0F, new Item.Properties().durability(168)))
            : null;

    public static final RegistryObject<Item> GOBBER_CLEAVER_NETHER = ModList.get().isLoaded("gobber2")
            ? OPTIONAL_ITEMS.register("gobber2_cleaver_nether", () -> new CleaverItem(2.5F,Tiers.IRON, 8F, -3.0F, new Item.Properties().durability(168)))
            : null;

    public static final RegistryObject<Item> GOBBER_CLEAVER_END = ModList.get().isLoaded("gobber2")
            ? OPTIONAL_ITEMS.register("gobber2_cleaver_end", () -> new CleaverItem(3.5F,Tiers.IRON, 9F, -3.0F, new Item.Properties().durability(168)))
            : null;




    public static final RegistryObject<CreativeModeTab> CLEAVER_COMPENDIUM_TAB = CREATIVE_MODE_TABS.register("cleaver_compendium_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("item_group." + MOD_ID + ".tab"))
            .icon(() -> EXAMPLE_CLEAVER.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(EXAMPLE_CLEAVER.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());

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

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

    }



 // adding to creative tab if they exist
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (SILVER_CLEAVER != null && event.getTab() == CLEAVER_COMPENDIUM_TAB.get()) {
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
