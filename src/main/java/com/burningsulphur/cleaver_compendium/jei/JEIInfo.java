package com.burningsulphur.cleaver_compendium.jei;

import com.burningsulphur.cleaver_compendium.CleaverCompendium;
import static com.burningsulphur.cleaver_compendium.Config.*;
import com.burningsulphur.cleaver_compendium.configs.*;
import com.google.common.collect.ImmutableList;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.*;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import vectorwing.farmersdelight.common.utility.TextUtils;
import vectorwing.farmersdelight.integration.jei.resource.DecompositionDummy;

import javax.annotation.ParametersAreNonnullByDefault;

@JeiPlugin
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@SuppressWarnings("unused")
public class JEIInfo implements IModPlugin {
    private static final ResourceLocation ID = new ResourceLocation(CleaverCompendium.MOD_ID, "jei_plugin");

    @Override
    public void registerRecipes(IRecipeRegistration registration) {

        //INFO
        if (CleaverCompendium.SILVER_CLEAVER != null && !silverCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.SILVER_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        if (CleaverCompendium.NECROMIUM_CLEAVER != null && !CCNecromiumCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.NECROMIUM_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        if (CleaverCompendium.ELECTRUM_CLEAVER != null && !OElectrumCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.ELECTRUM_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        if (CleaverCompendium.LEAD_CLEAVER != null && !OLeadCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.LEAD_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        if (CleaverCompendium.ROSE_GOLD_CLEAVER != null && !DCRoseGoldCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.ROSE_GOLD_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        if (CleaverCompendium.ENDERITE_CLEAVER != null && !EnderiteCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.ENDERITE_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        if (CleaverCompendium.GOBBER_CLEAVER != null && !GobberCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.GOBBER_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        if (CleaverCompendium.GOBBER_CLEAVER_NETHER != null && !GobberNetherCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.GOBBER_CLEAVER_NETHER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        if (CleaverCompendium.GOBBER_CLEAVER_END != null && !GobberEndCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.GOBBER_CLEAVER_END.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        //batch 2
        if (CleaverCompendium.KOBOLD_IRON_CLEAVER != null && !KoboldIronCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.KOBOLD_IRON_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        if (CleaverCompendium.NEPTUNIUM_CLEAVER != null && !NeptuniumCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.NEPTUNIUM_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        if (CleaverCompendium.CERTUS_QUARTZ_CLEAVER != null && !CertusQuartzCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.CERTUS_QUARTZ_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        if (CleaverCompendium.NETHER_QUARTZ_CLEAVER != null && !NetherQuartzCleaverDisable ) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.NETHER_QUARTZ_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        if (CleaverCompendium.FLUIX_CLEAVER != null && !FluixCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.FLUIX_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        if (CleaverCompendium.DRACO_ARCANUS_CLEAVER != null && !DracoArcanusCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.DRACO_ARCANUS_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        if (CleaverCompendium.REINFORCED_DEORUM_CLEAVER != null && !ReinforcedDeorumCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.REINFORCED_DEORUM_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        //batch 3
        if (CleaverCompendium.DAWNSTONE_CLEAVER != null && !DawnstoneCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.DAWNSTONE_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        if (CleaverCompendium.EMBER_LEAD_CLEAVER != null && !ELeadCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.EMBER_LEAD_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        if (CleaverCompendium.EMBER_SILVER_CLEAVER != null && !ESilverCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.EMBER_SILVER_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        if (CleaverCompendium.SILEX_CLEAVER != null && !SilexCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.SILEX_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }
        if (CleaverCompendium.CRYSTALLINE_CLEAVER != null && !CrystallineCleaverDisable) {
            registration.addIngredientInfo(new ItemStack(CleaverCompendium.CRYSTALLINE_CLEAVER.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslation("jei.info.cleaver"));
        }

    }

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }
}