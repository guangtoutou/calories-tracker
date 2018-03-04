package com.ningning.meals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Date;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(MealsController.class)
public class MealsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MealsService mealsService;

	//return all meals
	@Test
	@WithMockUser
	public void getMeals_ShouldReturnMeals() throws Exception {
		given(mealsService.getMeals()).willReturn(Arrays.asList(new Meal(new Date(),100)));

		mockMvc.perform(MockMvcRequestBuilders.get("/meals"))
				.andExpect(status().isOk())
				//.andExpect(model().size(1))
				.andExpect(jsonPath("[0].calories").value("100"));
	}


}