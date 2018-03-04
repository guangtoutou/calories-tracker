package com.ningning.meals;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Meal {

	@Id
	@GeneratedValue
	private Long id;
	private Date date;
	private int calories;

	public Meal(){}

	public Meal(Date date, int calories){
		this.date = date;
		this.calories = calories;
	}
}
