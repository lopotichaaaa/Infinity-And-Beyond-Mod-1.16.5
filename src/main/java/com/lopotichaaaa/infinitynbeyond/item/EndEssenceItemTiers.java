package com.lopotichaaaa.infinitynbeyond.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.text.Color;

import java.util.function.Supplier;

public enum EndEssenceItemTiers implements IItemTier {




    D(4, 4062, 12.0F, 7.0F, 24,
            ()->Ingredient.fromItems(ModItems.END_ESSENCE.get()),"D","FFFFFF"),
    C(4, 8124, 14.0F, 8.0F, 26,
            ()->Ingredient.fromItems(ModItems.END_ESSENCE.get()),"C","42f545"),
    B(4, 16000, 15.0F, 9.0F, 26,
            ()->Ingredient.fromItems(ModItems.END_ESSENCE.get()),"B","4248f5"),
    A(4, 20000, 16.0F, 10.0F, 26,
            ()->Ingredient.fromItems(ModItems.END_ESSENCE.get()),"A","f542e0"),
    S(4, 30000, 17.0F, 11.0F, 26,
            ()->Ingredient.fromItems(ModItems.END_ESSENCE.get()),"S","f09d0e"),
    S_PLUS(4, 50000, 20.0F, 13.0F, 30,
            ()->Ingredient.fromItems(ModItems.END_ESSENCE.get()),"S+","f7d128")
    ;

    private static String order = "DCBAS";

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;
    private final String tierName;
    private final Color textColor;
    EndEssenceItemTiers(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability,
                        Supplier<Ingredient> repairMaterial,String tierName, String textColor) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
        this.tierName = tierName;
        this.textColor = Color.fromHex(textColor);
    }


    public boolean greaterEqualThan(EndEssenceItemTiers other){
        if (this==S_PLUS){
            return true;
        }
        if (other==S_PLUS){
            return false;
        }
        int rank = order.indexOf(getTierName());
        return rank>=order.indexOf(other.getTierName());
    }

    public String getTierName() {
        return tierName;
    }

    public Color getTextColor() {
        return textColor;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.getValue();
    }
}
