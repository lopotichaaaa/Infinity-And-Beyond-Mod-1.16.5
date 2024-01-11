package com.lopotichaaaa.infinitynbeyond.data.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lopotichaaaa.infinitynbeyond.block.ModBlocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class EndInfusionRecipe implements IEndInfusingRecipe{



    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> ingredients;

    public EndInfusionRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> ingredients) {
        this.id = id;
        this.output = output;
        this.ingredients = ingredients;
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        if(ingredients.get(0).test(inv.getStackInSlot(0))){
            return ingredients.get(1).test(inv.getStackInSlot(1));
        }
        return false;

    }

    @Override
    public ItemStack getCraftingResult(IInventory inv) {
        return output;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public ItemStack getIcon() {
        return new ItemStack(ModBlocks.END_INFUSER_BLOCK.get());
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipeTypes.END_INFUSION_SERIALIZER.get();
    }

    public static class EndInfuserType implements IRecipeType<EndInfusionRecipe>{
        @Override
        public String toString() {
            return EndInfusionRecipe.TYPE_ID.toString();
        }
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
            implements IRecipeSerializer<EndInfusionRecipe> {

        @Override
        public EndInfusionRecipe read(ResourceLocation recipeId, JsonObject json) {
            ItemStack output = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json,
                    "result"));

            JsonArray ingredients = JSONUtils.getJsonArray(json,"ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2,Ingredient.EMPTY);

            for (int i=0;i<inputs.size();i++){
                inputs.set(i,Ingredient.deserialize(ingredients.get(i)));
            }

            return new EndInfusionRecipe(recipeId,output,
                    inputs);
        }

        @Nullable
        @Override
        public EndInfusionRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(2,Ingredient.EMPTY);
            for (int i=0;i<inputs.size();i++){
                inputs.set(i,Ingredient.read(buffer));
            }

            ItemStack output = buffer.readItemStack();

            return new EndInfusionRecipe(recipeId,output,
                    inputs);
        }

        @Override
        public void write(PacketBuffer buffer, EndInfusionRecipe recipe) {
            buffer.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()){
                ing.write(buffer);
            }
            buffer.writeItemStack(recipe.getRecipeOutput(),false);
        }
    }
}
