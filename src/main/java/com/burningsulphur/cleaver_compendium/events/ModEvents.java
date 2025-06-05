package com.burningsulphur.cleaver_compendium.events;

import com.burningsulphur.cleaver_compendium.CleaverCompendium;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;


//--------------------I translated a kubejs script I had into java using gemini. which is why it is a bit odd---------

@Mod.EventBusSubscriber(modid = CleaverCompendium.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        // KubeJS: const { entity, source } = event
        LivingEntity targetEntity = event.getEntity();
        // KubeJS: let attackingEntity = source.actual
        LivingEntity attackingEntity = null;
        if (event.getSource().getDirectEntity() instanceof LivingEntity) {
            attackingEntity = (LivingEntity) event.getSource().getDirectEntity();
        } else if (event.getSource().getEntity() instanceof LivingEntity) {
            // Fallback for cases where getDirectEntity() might be null but getEntity() is a LivingEntity (e.g., environmental damage from a mob)
            attackingEntity = (LivingEntity) event.getSource().getEntity();
        }


        // KubeJS: if (!attackingEntity) return
        if (attackingEntity == null) {
            return;
        }

        // KubeJS: if (attackingEntity.mainHandItem.id != "embers:lead_sword") return
        ItemStack mainHandItem = attackingEntity.getMainHandItem();
        ResourceLocation expectedItemId = new ResourceLocation("cleaver_compendium", "lead_cleaver"); // Define the item ID to check for

        if (mainHandItem.getItem() != ForgeRegistries.ITEMS.getValue(expectedItemId)) {
            return;
        }

        // KubeJS: entity.potionEffects.add("oreganized:stunning", 100, 1, false, true)
        ResourceLocation stunningEffectId = new ResourceLocation("oreganized", "stunning");
        MobEffect stunningEffect = ForgeRegistries.MOB_EFFECTS.getValue(stunningEffectId);

        if (stunningEffect != null) {
            int duration = 100;
            int amplifier = 1;
            boolean ambient = false;
            boolean showParticles = true; //

            targetEntity.addEffect(new MobEffectInstance(stunningEffect, duration, amplifier, ambient, showParticles));
        } else {
        }
    }
}