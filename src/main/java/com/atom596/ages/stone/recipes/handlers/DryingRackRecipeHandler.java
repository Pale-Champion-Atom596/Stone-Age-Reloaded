package com.atom596.ages.stone.recipes.handlers;

import com.atom596.ages.stone.Reference;
import com.atom596.ages.api.manual.IRecipeHandler;
import com.atom596.ages.api.manual.RecipeBackground;
import com.atom596.ages.api.manual.RecipeIngredient;
import com.atom596.ages.stone.recipes.DryingRackRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class DryingRackRecipeHandler implements IRecipeHandler {
    @Nonnull
    @Override
    public List<RecipeIngredient> getRecipeIngredients(IRecipe<?> recipe) {
        DryingRackRecipe dryingRackRecipe = (DryingRackRecipe) recipe;
        List<RecipeIngredient> list = new ArrayList<>();

        list.add(new RecipeIngredient(dryingRackRecipe.getIngredients().get(0), 22, 22));
        list.add(new RecipeIngredient(Ingredient.fromItems(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Reference.MODID, "drying_rack"))), 52, 22));
        list.add(new RecipeIngredient(Ingredient.fromStacks(dryingRackRecipe.getRecipeOutput()), 85, 23));
        return list;
    }

    @Nonnull
    @Override
    public RecipeBackground getRecipeBackground() {
        return new RecipeBackground(new ResourceLocation(Reference.MODID, "textures/gui/jei/gui_layouts.png"), 0, 61, 120, 60, 256, 256);
    }
}
