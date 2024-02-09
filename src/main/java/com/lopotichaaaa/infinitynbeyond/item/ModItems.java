package com.lopotichaaaa.infinitynbeyond.item;

import com.lopotichaaaa.infinitynbeyond.InfinityAndBeyond;
import net.minecraft.inventory.EquipmentSlotType;
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

    public static final RegistryObject<Item> END_ESSENCE_SWORD_D = ITEMS.register("end_essence_sword_d",
            ()-> new EndEssenceSword(EndEssenceItemTiers.D,2,1.6f,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));
    public static final RegistryObject<Item> END_ESSENCE_SWORD_C = ITEMS.register("end_essence_sword_c",
            ()-> new EndEssenceSword(EndEssenceItemTiers.C,2,1.6f,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));
    public static final RegistryObject<Item> END_ESSENCE_SWORD_B = ITEMS.register("end_essence_sword_b",
            ()-> new EndEssenceSword(EndEssenceItemTiers.B,2,1.6f,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));
    public static final RegistryObject<Item> END_ESSENCE_SWORD_A = ITEMS.register("end_essence_sword_a",
            ()-> new EndEssenceSword(EndEssenceItemTiers.A,2,1.6f,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));
    public static final RegistryObject<Item> END_ESSENCE_SWORD_S = ITEMS.register("end_essence_sword_s",
            ()-> new EndEssenceSword(EndEssenceItemTiers.S,2,1.6f,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));
    public static final RegistryObject<Item> END_ESSENCE_SWORD_S_PLUS = ITEMS.register("end_essence_sword_s_plus",
            ()-> new EndEssenceSword(EndEssenceItemTiers.S_PLUS,2,1.6f,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));

    public static final RegistryObject<Item> END_ESSENCE_PICKAXE = ITEMS.register("end_essence_pickaxe",
            ()-> new PickaxeItem(EndEssenceItemTiers.D,-2,-2.8f,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));
    public static final RegistryObject<Item> END_ESSENCE_AXE = ITEMS.register("end_essence_axe",
            ()-> new AxeItem(EndEssenceItemTiers.D,4,1.0f,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));
    public static final RegistryObject<Item> END_ESSENCE_HOE = ITEMS.register("end_essence_hoe",
            ()-> new HoeItem(EndEssenceItemTiers.D,-7,1f,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));
    public static final RegistryObject<Item> END_ESSENCE_SHOVEL = ITEMS.register("end_essence_shovel",
            ()-> new ShovelItem(EndEssenceItemTiers.D,-1,-3f,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));

    public static final RegistryObject<Item> END_ESSENCE_BOOTS = ITEMS.register("end_essence_boots",
            ()-> new ArmorItem(EndEssenceArmorTiers.D, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));
    public static final RegistryObject<Item> END_ESSENCE_LEGGINGS = ITEMS.register("end_essence_leggings",
            ()-> new ArmorItem(EndEssenceArmorTiers.D, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));
    public static final RegistryObject<Item> END_ESSENCE_CHESTPLATE = ITEMS.register("end_essence_chestplate",
            ()-> new ArmorItem(EndEssenceArmorTiers.D, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));
    public static final RegistryObject<Item> END_ESSENCE_HELMET = ITEMS.register("end_essence_helmet",
            ()-> new ArmorItem(EndEssenceArmorTiers.D, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
