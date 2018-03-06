package com.ningning.meals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class MealsServiceTest {

	@Autowired
	private MealsService mealsService;

	@MockBean
	private MealRepository mealRepository;

	@Test
	public void getMeals_ShouldReturnMeals(){

	}

}