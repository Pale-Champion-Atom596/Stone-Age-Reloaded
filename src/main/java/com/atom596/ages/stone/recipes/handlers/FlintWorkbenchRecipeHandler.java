package com.atom596.ages.stone.recipes.handlers;

import com.atom596.ages.stone.Reference;
import com.atom596.ages.api.manual.IRecipeHandler;
import com.atom596.ages.api.manual.RecipeBackground;
import com.atom596.ages.api.manual.RecipeIngredient;
import com.atom596.ages.stone.recipes.FlintWorkbenchRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class FlintWorkbenchRecipeHandler implements IRecipeHandler {
    @Nonnull
    @Override
    public List<RecipeIngredient> getRecipeIngredients(IRecipe<?> recipe) {
        FlintWorkbenchRecipe flintWorkbenchRecipe = (FlintWorkbenchRecipe) recipe;
        List<RecipeIngredient> list = new ArrayList<>();

        for (int y = 0; y < flintWorkbenchRecipe.getHeight(); y++) {
            for (int x = 0; x < flintWorkbenchRecipe.getWidth(); x++) {
                int pos = y * flintWorkbenchRecipe.getWidth() + x;
                list.add(pos, new RecipeIngredient(flintWorkbenchRecipe.getIngredients().get(pos), 4 + x * 18, 4 + y * 18));
            }
        }

        list.add(new RecipeIngredient(flintWorkbenchRecipe.getTool(), 67, 22));
        list.add(new RecipeIngredient(Ingredient.fromStacks(flintWorkbenchRecipe.getRecipeOutput()), 98, 22));
        return list;
    }

    @Nonnull
    @Override
    public RecipeBackground getRecipeBackground() {
        return new RecipeBackground(new ResourceLocation(Reference.MODID, "textures/gui/jei/gui_layouts.png"), 0, 0, 120, 60, 256, 256);
    }
}
