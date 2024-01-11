package com.lopotichaaaa.infinitynbeyond.data.recipes;

import com.lopotichaaaa.infinitynbeyond.InfinityAndBeyond;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipeTypes {
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, InfinityAndBeyond.MOD_ID);

    public static final RegistryObject<EndInfusionRecipe.Serializer> END_INFUSION_SERIALIZER
            = RECIPE_SERIALIZER.register("infusion", EndInfusionRecipe.Serializer::new);

    public static IRecipeType<EndInfusionRecipe> END_INFUSION_RECIPE
            = new EndInfusionRecipe.EndInfuserType();


    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZER.register(eventBus);

        Registry.register(Registry.RECIPE_TYPE, EndInfusionRecipe.TYPE_ID, END_INFUSION_RECIPE);
    }
}
