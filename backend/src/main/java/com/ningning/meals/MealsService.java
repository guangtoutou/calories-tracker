package com.ningning.meals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealsService {

	@Autowired
	private MealRepository mealRepository;

	public List<Meal> getMeals(){
		return null;
	}
}
