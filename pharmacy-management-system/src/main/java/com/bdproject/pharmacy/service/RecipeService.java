package com.bdproject.pharmacy.service;

import com.bdproject.pharmacy.dto.request.RecipeRequest;
import com.bdproject.pharmacy.model.RecipeEntity;

import java.util.List;

public interface RecipeService {

    Integer createRecipe(RecipeRequest request);

    Integer updateRecipe(Integer idProducator, RecipeRequest request);

    void deleteRecipe(Integer idProducator);

    RecipeEntity getRecipeById(Integer idProducator);

    List<RecipeEntity> getRecipes();
}
