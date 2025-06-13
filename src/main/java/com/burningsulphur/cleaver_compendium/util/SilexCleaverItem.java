package com.burningsulphur.cleaver_compendium.util;



import galena.oreganized.index.OItemTiers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import net.yirmiri.dungeonsdelight.common.item.CleaverItem;

public class SilexCleaverItem extends CleaverItem {
    public SilexCleaverItem() {
        super(0.75F, new SilexTier(), -5F, -3.0F, new Item.Properties().durability(48));
    }

    private static class SilexTier implements Tier {
        public int getUses() {
            return 48;
        }

        public float getSpeed() {
            return 6.0F;
        }

        public float getAttackDamageBonus() {
            return 6.0F;
        }

        public int getLevel() {
            return 2;
        }

        public int getEnchantmentValue() {
            return 13;
        }

        public Ingredient getRepairIngredient() {
            return Ingredient.of(new ItemStack[]{new ItemStack(Items.FLINT)});
        }
    }
}