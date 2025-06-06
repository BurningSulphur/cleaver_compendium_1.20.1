package com.burningsulphur.cleaver_compendium.util;

//using the stained cleaver as a base:
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.yirmiri.dungeonsdelight.common.entity.misc.CleaverEntity;
import net.yirmiri.dungeonsdelight.core.registry.DDEffects;
import net.yirmiri.dungeonsdelight.core.registry.DDEnchantments;
import net.yirmiri.dungeonsdelight.core.registry.DDEntities;
import net.yirmiri.dungeonsdelight.core.registry.DDSounds;

//neptunium shovel as a guide:

import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import javax.annotation.Nonnull;

// looking at the cleaver item now
import com.google.common.collect.Sets;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.yirmiri.dungeonsdelight.common.entity.misc.CleaverEntity;
import net.yirmiri.dungeonsdelight.core.registry.DDEffects;
import net.yirmiri.dungeonsdelight.core.registry.DDEnchantments;
import net.yirmiri.dungeonsdelight.core.registry.DDEntities;
import net.yirmiri.dungeonsdelight.core.registry.DDSounds;
import vectorwing.farmersdelight.common.item.KnifeItem;

import net.minecraft.world.item.Tier;
import net.yirmiri.dungeonsdelight.common.item.CleaverItem;

public class NeptuniumCleaverItem extends CleaverItem {
    public NeptuniumCleaverItem(float range, Tier tier, float attackDamage, float attackSpeed, Properties properties) {
        super(range, tier, attackDamage, attackSpeed, properties);
    }

    //finding if they are in water
    @Override
    public void inventoryTick(@Nonnull ItemStack stack, Level world, Entity entity, int itemSlot, boolean isSelected) {
        if (entity instanceof Player player && stack.getItem() == this) {
            stack.getOrCreateTag().putBoolean("inWater", player.isEyeInFluid(FluidTags.WATER));
        }
    }


    /* example increasing dig speed
    @Override
    public float getDestroySpeed(@Nonnull ItemStack stack, BlockState state) {
        float defaultSpeed = super.getDestroySpeed(stack, state);
        boolean isInWater = stack.hasTag() && stack.getTag() != null && stack.getTag().getBoolean("inWater");
        return isInWater ? (defaultSpeed * 5.0F) * 5.0F : defaultSpeed;
    }
    */
/*
    //this.range = range;
    @Override
    public void releaseUsing(@Nonnull ItemStack stack, Level level, LivingEntity living, int timeLeft) {
        float range = this.range;
        boolean isInWater = stack.hasTag() && (stack.getTag() != null) && stack.getTag().getBoolean("inWater");
         return isInWater ? (defaultSpeed * 5.0F) * 5.0F : defaultSpeed;
    }
    */


    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity living, int timeLeft) {
        if (!(living instanceof Player player)) return;
        if (getUseDuration(stack) - timeLeft < 6 || player.getCooldowns().isOnCooldown(this)) return;

        float range = this.range;
        boolean isInWater = stack.hasTag() && (stack.getTag() != null) && stack.getTag().getBoolean("inWater");
        if (isInWater){
            range = 4;
        }

        if (!level.isClientSide) {
            stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(living.getUsedItemHand()));

            CleaverEntity cleaver = new CleaverEntity(DDEntities.CLEAVER.get(), level, player, stack.copy());
            cleaver.setItem(stack.copy());

            applyEnchantments(stack, cleaver);
            cleaver.setBaseDamage(cleaver.getBaseDamage() + getAttackDamage());
            cleaver.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, range, 1.0F);

            if (player.getAbilities().instabuild) {
                cleaver.pickup = AbstractArrow.Pickup.DISALLOWED;
            }

            level.addFreshEntity(cleaver);
            level.playSound(null, cleaver, DDSounds.CLEAVER_THROW.get(), SoundSource.PLAYERS, 2.0F, 1.0F);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
    }



// had to copy this as well as it isn't public in it's java file
    void applyEnchantments(ItemStack stack, CleaverEntity cleaver) {
        int sharpness = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SHARPNESS, stack);
        if (sharpness > 0) {
            cleaver.setBaseDamage(cleaver.getBaseDamage() + sharpness * 0.5 + 0.5);
        }

        int fireAspect = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FIRE_ASPECT, stack);
        if (fireAspect > 0) {
            cleaver.setSecondsOnFire(100 * fireAspect);
        }

        int ricochet = EnchantmentHelper.getItemEnchantmentLevel(DDEnchantments.RICOCHET.get(), stack);
        if (ricochet > 0) {
            cleaver.ricochetsLeft += ricochet;
        }

        int serrated = EnchantmentHelper.getItemEnchantmentLevel(DDEnchantments.SERRATED_STRIKE.get(), stack);
        if (serrated > 0) {
            cleaver.setSerratedLevel(serrated);
        }

        int persistence = EnchantmentHelper.getItemEnchantmentLevel(DDEnchantments.PERSISTENCE.get(), stack);
        if (persistence > 0) {
            cleaver.pickup = AbstractArrow.Pickup.ALLOWED;
            cleaver.setPersistenceLevel(persistence);
            cleaver.despawnTime = 200 + (persistence * 40);
        }
    }



}
