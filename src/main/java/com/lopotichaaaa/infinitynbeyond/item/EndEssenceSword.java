package com.lopotichaaaa.infinitynbeyond.item;

import com.sun.org.apache.xpath.internal.operations.Mod;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
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
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (entityIn instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityIn;

            if (player.getHeldItem(Hand.MAIN_HAND).getItem() instanceof EndEssenceSword) {
                EndEssenceSword sword = (EndEssenceSword) player.getHeldItem(Hand.MAIN_HAND).getItem();
                // D Tier effects :
                player.addPotionEffect(new EffectInstance(Effects.SPEED,1));

                //C Tier effects:
                if (sword.getTier().greaterEqualThan(EndEssenceItemTiers.C)){
                    player.addPotionEffect(new EffectInstance(Effects.RESISTANCE,1));
                }
                //B Tier effects:
                if (sword.getTier().greaterEqualThan(EndEssenceItemTiers.B)){
                    player.addPotionEffect(new EffectInstance(Effects.STRENGTH,1));
                }
                //A Tier effects:
                if (sword.getTier().greaterEqualThan(EndEssenceItemTiers.A)){
                    player.addPotionEffect(new EffectInstance(Effects.SPEED,1,1));
                }
                //S Tier effects:
                if (sword.getTier().greaterEqualThan(EndEssenceItemTiers.S)){
                    player.addPotionEffect(new EffectInstance(Effects.RESISTANCE,1,1));
                }
                //S+ Tier effects:
                if (sword.getTier().greaterEqualThan(EndEssenceItemTiers.S_PLUS)){
                    player.addPotionEffect(new EffectInstance(Effects.SPEED,1,2));
                    player.addPotionEffect(new EffectInstance(Effects.RESISTANCE,1,2));
                    player.addPotionEffect(new EffectInstance(Effects.STRENGTH,1,2));
                }

            }
        }
    }
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("tooltip.infinitynbeyond.end_essence_sword",
                new StringTextComponent(itemTierName()).setStyle(Style.EMPTY.setColor(itemTierColor()))));
        if (!Screen.hasShiftDown()){
            tooltip.add(new TranslationTextComponent("tooltip.infinitynbeyond.holdshiftiertooltip"));
        } else {
            // D Tier Effects
            EndEssenceItemTiers tier = EndEssenceItemTiers.D;
            tooltip.add(new TranslationTextComponent("tooltip.infinitynbeyond.tierswordeffects",
                    new StringTextComponent(tier.getTierName()).setStyle(Style.EMPTY.setColor(tier.getTextColor()))));
            tooltip.add(new TranslationTextComponent("effect.minecraft.speed"));

            // C Tier Effects
            if (getTier().greaterEqualThan(EndEssenceItemTiers.C)){
                tier = EndEssenceItemTiers.C;
                tooltip.add(new TranslationTextComponent("tooltip.infinitynbeyond.tierswordeffects",
                        new StringTextComponent(tier.getTierName()).setStyle(Style.EMPTY.setColor(tier.getTextColor()))));
                tooltip.add(new TranslationTextComponent("effect.minecraft.resistance"));
            }

            // B Tier Effects
            if (getTier().greaterEqualThan(EndEssenceItemTiers.B)){
                tier = EndEssenceItemTiers.B;
                tooltip.add(new TranslationTextComponent("tooltip.infinitynbeyond.tierswordeffects",
                        new StringTextComponent(tier.getTierName()).setStyle(Style.EMPTY.setColor(tier.getTextColor()))));
                tooltip.add(new TranslationTextComponent("effect.minecraft.strength"));
            }

            // A Tier Effects
            if (getTier().greaterEqualThan(EndEssenceItemTiers.A)){
                tier = EndEssenceItemTiers.A;
                tooltip.add(new TranslationTextComponent("tooltip.infinitynbeyond.tierswordeffects",
                        new StringTextComponent(tier.getTierName()).setStyle(Style.EMPTY.setColor(tier.getTextColor()))));
                tooltip.add(new TranslationTextComponent("effect.minecraft.speed").appendString(" ")
                        .appendSibling(new TranslationTextComponent("potion.potency.1")));
            }

            // S Tier Effects
            if (getTier().greaterEqualThan(EndEssenceItemTiers.S)){
                tier = EndEssenceItemTiers.S;
                tooltip.add(new TranslationTextComponent("tooltip.infinitynbeyond.tierswordeffects",
                        new StringTextComponent(tier.getTierName()).setStyle(Style.EMPTY.setColor(tier.getTextColor()))));
                tooltip.add(new TranslationTextComponent("effect.minecraft.resistance").appendString(" ")
                        .appendSibling(new TranslationTextComponent("potion.potency.1")));
            }
            // S+ Tier Effects
            if (getTier().greaterEqualThan(EndEssenceItemTiers.S_PLUS)){
                tier = EndEssenceItemTiers.S_PLUS;
                tooltip.add(new TranslationTextComponent("tooltip.infinitynbeyond.tierswordeffects",
                        new StringTextComponent(tier.getTierName()).setStyle(Style.EMPTY.setColor(tier.getTextColor()))));
                tooltip.add(new TranslationTextComponent("effect.minecraft.speed").appendString(" ")
                        .appendSibling(new TranslationTextComponent("potion.potency.2")));
                tooltip.add(new TranslationTextComponent("effect.minecraft.resistance").appendString(" ")
                        .appendSibling(new TranslationTextComponent("potion.potency.2")));
                tooltip.add(new TranslationTextComponent("effect.minecraft.strength").appendString(" ")
                        .appendSibling(new TranslationTextComponent("potion.potency.2")));
            }

        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
