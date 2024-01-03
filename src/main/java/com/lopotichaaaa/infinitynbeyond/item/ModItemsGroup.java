package com.lopotichaaaa.infinitynbeyond.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemsGroup {

    public static final ItemGroup INFINITY_AND_BEYOND = new ItemGroup("infinitynbeyondTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.END_ESSENCE.get());
        }
    };

}
