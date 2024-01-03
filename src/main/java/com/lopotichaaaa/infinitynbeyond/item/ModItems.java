package com.lopotichaaaa.infinitynbeyond.item;

import com.lopotichaaaa.infinitynbeyond.InfinityAndBeyond;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InfinityAndBeyond.MOD_ID);

    public static final RegistryObject<Item> END_ESSENCE = ITEMS.register("end_essence",
            ()-> new Item(new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
