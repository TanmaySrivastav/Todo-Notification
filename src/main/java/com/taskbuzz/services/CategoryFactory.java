package com.taskbuzz.services;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CategoryFactory {

	private final Map<String, Function<String, String>> categoryMap = new HashMap<>();

	public CategoryFactory() {
		categoryMap.put("grocery", new Grocery()::getCategory);
		categoryMap.put("assignment", new Assignment()::getCategory);
		categoryMap.put("fitness", new Fitness()::getCategory);
		categoryMap.put("default", new Others()::getCategory);
	}

	public String getCategoryType(String categoryType) {
		return categoryMap.getOrDefault(categoryType.toLowerCase(), categoryMap.get("default")).apply(categoryType);
	}

}
