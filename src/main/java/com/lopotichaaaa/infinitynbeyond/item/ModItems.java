package com.lopotichaaaa.infinitynbeyond.item;

import com.lopotichaaaa.infinitynbeyond.InfinityAndBeyond;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InfinityAndBeyond.MOD_ID);

    public static final RegistryObject<Item> END_ESSENCE = ITEMS.register("end_essence",
            ()-> new Item(new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));

    public static final RegistryObject<Item> END_ESSENCE_SWORD = ITEMS.register("end_essence_sword",
            ()-> new SwordItem(ModItemTier.END_ESSENCE,2,1.6f,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));
    public static final RegistryObject<Item> END_ESSENCE_PICKAXE = ITEMS.register("end_essence_pickaxe",
            ()-> new PickaxeItem(ModItemTier.END_ESSENCE,-2,-2.8f,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));
    public static final RegistryObject<Item> END_ESSENCE_AXE = ITEMS.register("end_essence_axe",
            ()-> new AxeItem(ModItemTier.END_ESSENCE,4,1.0f,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));
    public static final RegistryObject<Item> END_ESSENCE_HOE = ITEMS.register("end_essence_hoe",
            ()-> new HoeItem(ModItemTier.END_ESSENCE,-7,1f,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));
    public static final RegistryObject<Item> END_ESSENCE_SHOVEL = ITEMS.register("end_essence_shovel",
            ()-> new ShovelItem(ModItemTier.END_ESSENCE,-1,-3f,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
