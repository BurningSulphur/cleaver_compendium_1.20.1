package com.burningsulphur.cleaver_compendium.util;





import java.util.List;

import appeng.items.tools.fluix.FluixToolType;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.yirmiri.dungeonsdelight.common.item.CleaverItem;
import org.jetbrains.annotations.Nullable;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import appeng.core.localization.GuiText;
//import appeng.hooks.IntrinsicEnchantItem;


public class FluixCleaverItem extends CleaverItem{

    public FluixCleaverItem(Properties props) {
        super(1.5F, FluixToolType.FLUIX.getToolTier(), 3.4F, -3.0F, props);
    }

    public int getIntrinsicEnchantLevel(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.MOB_LOOTING ? 1 : 0;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents,
                                TooltipFlag isAdvanced) {
        tooltipComponents.add(GuiText.IntrinsicEnchant.text(Enchantments.MOB_LOOTING.getFullname(1)));
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}


/*
public class FluixCleaverItem extends CleaverItem implements IntrinsicEnchantItem {
    public FluixCleaverItem(Properties props) {
        super(1.5F, FluixToolType.FLUIX.getToolTier(), 3.4F, -3.0F, props);
    }

    @Override
    public int getIntrinsicEnchantLevel(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.MOB_LOOTING ? 1 : 0;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents,
                                TooltipFlag isAdvanced) {
        tooltipComponents.add(GuiText.IntrinsicEnchant.text(Enchantments.MOB_LOOTING.getFullname(1)));
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}

 */