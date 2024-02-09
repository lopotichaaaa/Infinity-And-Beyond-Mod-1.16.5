package com.lopotichaaaa.infinitynbeyond.item;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.*;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class EndEssenceSword extends SwordItem implements IInfusedTool{
    public EndEssenceSword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }






    @Override
    public String itemTierName() {
        return getTier().getTierName();
    }

    @Override
    public Color itemTierColor() {
        return getTier().getTextColor();
    }

    @Override
    public EndEssenceItemTiers getTier() {
        return (EndEssenceItemTiers) super.getTier();
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("tooltip.infinitynbeyond.end_essence_sword",
                new StringTextComponent(itemTierName()).setStyle(Style.EMPTY.setColor(itemTierColor()))));
        if (!Screen.hasShiftDown()){
            tooltip.add(new TranslationTextComponent("tooltip.infinitynbeyond.holdshiftiertooltip"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
