package com.lopotichaaaa.infinitynbeyond.item;

import net.minecraft.util.text.Color;

public interface IInfusedItem {
    public String itemTierName();
    public EndEssenceItemTiers getTier();
    Color itemTierColor();
}
