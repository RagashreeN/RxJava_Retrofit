package com.rxjava.example.adapter;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class EmployeeResponse{

	private List<String> fruits;

	public void setFruits(List<String> fruits){
		this.fruits = fruits;
	}

	public List<String> getFruits(){
		return fruits;
	}

	@Override
 	public String toString(){
		return 
			"EmployeeResponse{" + 
			"fruits = '" + fruits + '\'' + 
			"}";
		}
}