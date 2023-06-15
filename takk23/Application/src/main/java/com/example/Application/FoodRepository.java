package com.example.Application;

import com.example.Application.Food;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called foodRepository
// CRUD refers Create, Read, Update, Delete

public interface FoodRepository extends CrudRepository<Food, Long> {

}