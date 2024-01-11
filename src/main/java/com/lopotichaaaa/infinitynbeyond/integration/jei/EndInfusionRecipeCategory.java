package com.lopotichaaaa.infinitynbeyond.integration.jei;

import com.lopotichaaaa.infinitynbeyond.InfinityAndBeyond;
import com.lopotichaaaa.infinitynbeyond.block.ModBlocks;
import com.lopotichaaaa.infinitynbeyond.data.recipes.EndInfusionRecipe;
import com.lopotichaaaa.infinitynbeyond.tileentities.EndInfuserTile;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class EndInfusionRecipeCategory implements IRecipeCategory<EndInfusionRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(InfinityAndBeyond.MOD_ID,"infusion");
    public final static ResourceLocation TEXTURE = new ResourceLocation(InfinityAndBeyond.MOD_ID,"textures/gui/end_infuser_gui.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawableStatic infusionArrow;

    public EndInfusionRecipeCategory(IGuiHelper helper) {

        this.background = helper.createDrawable(TEXTURE,3,3,170,82);
        this.icon = helper.createDrawableIngredient(new ItemStack(ModBlocks.END_INFUSER_BLOCK.get()));
        this.infusionArrow = helper.createDrawable(TEXTURE,176,0,9,15);
    }


    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends EndInfusionRecipe> getRecipeClass() {
        return EndInfusionRecipe.class;
    }

    @Override
    public String getTitle() {
        return ModBlocks.END_INFUSER_BLOCK.get().getTranslatedName().getString();
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setIngredients(EndInfusionRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(recipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM,recipe.getRecipeOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, EndInfusionRecipe endInfusionRecipe, IIngredients iIngredients) {
        iRecipeLayout.getItemStacks().init(0,true,76,15);
        iRecipeLayout.getItemStacks().init(1,true,76,57);
        iRecipeLayout.getItemStacks().init(2,false,100,36);
        iRecipeLayout.getItemStacks().set(iIngredients);
    }
}
