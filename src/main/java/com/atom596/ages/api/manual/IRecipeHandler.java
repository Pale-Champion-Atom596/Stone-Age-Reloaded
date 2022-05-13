package com.atom596.ages.api.manual;

import net.minecraft.item.crafting.IRecipe;

import javax.annotation.Nonnull;
import java.util.List;

public interface IRecipeHandler {

    @Nonnull
    List<RecipeIngredient> getRecipeIngredients(IRecipe<?> recipe);

    @Nonnull
    RecipeBackground getRecipeBackground();
}
