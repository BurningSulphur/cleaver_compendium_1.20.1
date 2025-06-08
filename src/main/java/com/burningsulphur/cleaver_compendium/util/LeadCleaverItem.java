package com.burningsulphur.cleaver_compendium.util;



import galena.oreganized.index.OItemTiers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.yirmiri.dungeonsdelight.common.item.CleaverItem;

public class LeadCleaverItem extends CleaverItem {
    private static final ResourceLocation STUNNING_ID = new ResourceLocation("oreganized", "stunning");

    public LeadCleaverItem(Properties props) {
        super(1.5F, OItemTiers.LEAD, 2F, -3.0F, props);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean result = super.hurtEnemy(stack, target, attacker);

        MobEffect stunningEffect = ForgeRegistries.MOB_EFFECTS.getValue(STUNNING_ID);

        if (stunningEffect != null) {
            int duration = 100;
            int amplifier = 1;
            boolean ambient = false;
            boolean showParticles = true;

            target.addEffect(new MobEffectInstance(stunningEffect, duration, amplifier, ambient, showParticles));
        }

        return result;
    }
}