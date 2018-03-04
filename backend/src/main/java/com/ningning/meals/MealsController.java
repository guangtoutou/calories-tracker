package com.ningning.meals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MealsController {

	@Autowired
	private MealsService mealsService;

	@GetMapping("/meals")
	public List<Meal> getMeals(){
		return mealsService.getMeals();
	}
}
