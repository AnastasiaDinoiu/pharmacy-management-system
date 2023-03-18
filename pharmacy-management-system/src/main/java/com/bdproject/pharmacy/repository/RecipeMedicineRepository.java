package com.bdproject.pharmacy.repository;

import com.bdproject.pharmacy.model.MedicineEntity;
import com.bdproject.pharmacy.model.RecipeEntity;
import com.bdproject.pharmacy.model.RecipeMedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeMedicineRepository extends JpaRepository<RecipeMedicineEntity, Long> {

    List<RecipeMedicineEntity> findByReteta(RecipeEntity recipe);
}
