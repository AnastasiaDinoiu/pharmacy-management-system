package com.bdproject.pharmacy.controller;

import com.bdproject.pharmacy.dto.request.RecipeRequest;
import com.bdproject.pharmacy.model.RecipeEntity;
import com.bdproject.pharmacy.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipeController {
    
    private final RecipeService recipeService;

    @PostMapping(path = "pharmacy/recipes")
    public ResponseEntity<Integer> createRecipe(@Valid @RequestBody RecipeRequest request) {
        return ResponseEntity.ok(recipeService.createRecipe(request));
    }

    @PutMapping(path = "pharmacy/recipes/{id}")
    public ResponseEntity<Integer> updateRecipe(@PathVariable Integer id, @Valid @RequestBody RecipeRequest request) {
        return ResponseEntity.ok(recipeService.updateRecipe(id, request));
    }

    @DeleteMapping(path = "pharmacy/recipes/{id}")
    public void deleteRecipe(@PathVariable Integer id) {
        recipeService.deleteRecipe(id);
    }

    @GetMapping(path = "pharmacy/recipes/{id}")
    public ResponseEntity<RecipeEntity> getRecipeById(@PathVariable Integer id) {
        return ResponseEntity.ok(recipeService.getRecipeById(id));
    }

    @GetMapping(path = "pharmacy/recipes")
    public ResponseEntity<List<RecipeEntity>> getRecipes() {
        return ResponseEntity.ok(recipeService.getRecipes());
    }
}
