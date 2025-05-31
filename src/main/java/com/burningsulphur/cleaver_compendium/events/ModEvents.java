package com.burningsulphur.cleaver_compendium.events;

import com.burningsulphur.cleaver_compendium.CleaverCompendium; // Import your main mod class
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
// For common effects like POISON.
// If 'oreganized:stunning' is a custom effect,
// you'll need to import Oreganized's MobEffects class
// or know its MobEffect object.
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries; // Needed to look up items by ResourceLocation

// This tells Forge to look for event subscribers in this class
// and registers them on the FORGE bus, which handles in-game events.

//--------------------I translated a kubejs script I had into java using gemini. which is why it is a bit odd---------

@Mod.EventBusSubscriber(modid = CleaverCompendium.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        // KubeJS: const { entity, source } = event
        LivingEntity targetEntity = event.getEntity(); // The entity that took damage
        // KubeJS: let attackingEntity = source.actual
        // In Forge, for direct attacks, getDirectEntity() is usually the actual attacker.
        // If it's a projectile, getEntity() would be the projectile, and getDirectEntity() its owner.
        // We're expecting a LivingEntity here, so we cast.
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
            return; // If it's not the Lead cleaver, stop here
        }

        // KubeJS: entity.potionEffects.add("oreganized:stunning", 100, 1, false, true)
        // You'll need to know the actual MobEffect object for "oreganized:stunning".
        // It's best to get it from Oreganized's own MobEffects class if available,
        // or look it up from ForgeRegistries.MOB_EFFECTS.
        // For demonstration, let's assume 'MobEffects.STUNNING' is how you'd get it,
        // or replace with the actual MobEffect from Oreganized.
        ResourceLocation stunningEffectId = new ResourceLocation("oreganized", "stunning");
        MobEffect stunningEffect = ForgeRegistries.MOB_EFFECTS.getValue(stunningEffectId);

        if (stunningEffect != null) { // Make sure the effect actually exists and is loaded
            int duration = 100; // Ticks (5 seconds)
            int amplifier = 1;  // KubeJS had 1 (so Stun II if it's 0-indexed)
            boolean ambient = false;
            boolean showParticles = true; // KubeJS 'true' corresponds to showParticles

            targetEntity.addEffect(new MobEffectInstance(stunningEffect, duration, amplifier, ambient, showParticles));
        } else {
        }
    }
}