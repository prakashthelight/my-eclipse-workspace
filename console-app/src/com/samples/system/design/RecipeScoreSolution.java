package com.samples.system.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class RecipeScoreSolution {

	public static void main(String[] args) {
		
		ArrayList<ArrayList<String>> entries = new ArrayList<>();
		
		entries.add(new ArrayList<>(Arrays.asList("Apple", "Banana", "Grapes", "Wheat", "Sugar", "Eggs", "LeftWin")));
		entries.add(new ArrayList<>(Arrays.asList("Sugar", "Eggs", "Wheat", "Wheat", "Apple", "Banana", "LeftWin")));
		entries.add(new ArrayList<>(Arrays.asList("Sugar", "Eggs", "Wheat", "Apple", "Grapes", "Banana", "RightWin")));
		
		ArrayList<Recipe> recipes = new ArrayList<>();
		
		for (ArrayList<String> list : entries) {
			Recipe leftRecipe = new Recipe(new TreeSet<>(Arrays.asList(list.get(0), list.get(1), list.get(2))));
			Recipe rightRecipe = new Recipe(new TreeSet<>(Arrays.asList(list.get(3), list.get(4), list.get(5))));
			
			if (recipes.indexOf(leftRecipe) > -1) {
				leftRecipe = recipes.get(recipes.indexOf(leftRecipe));
			} else {
				recipes.add(leftRecipe);
			}
			
			if (recipes.indexOf(rightRecipe) > -1) {
				rightRecipe = recipes.get(recipes.indexOf(rightRecipe));
			} else {
				recipes.add(rightRecipe);
			}
			
			if ("LeftWin".equals(list.get(6))) {
				leftRecipe.incrementWins();
				rightRecipe.incrementLoses();
			} else {
				leftRecipe.incrementLoses();
				rightRecipe.incrementWins();
			}
		}		
		
		PriorityQueue<Recipe> sortedRecipes = new PriorityQueue<>(new Comparator<Recipe>(){
			@Override
			public int compare(Recipe recipe1, Recipe recipe2) {		
				return recipe1.getScore() > recipe2.getScore() ? -1 : 1;
			}			
		});
		
		for (Recipe recipe : recipes) {
			sortedRecipes.offer(recipe);
		}
		
		while (!sortedRecipes.isEmpty()) {
			System.out.println(sortedRecipes.poll().toString());
		}
	}
}
