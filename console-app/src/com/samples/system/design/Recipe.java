package com.samples.system.design;


import java.util.TreeSet;

public class Recipe {
	
	TreeSet<String> ingredients;	
	int wins;	
	int loses;
	
	public Recipe (TreeSet<String> ingredients) {
		if (ingredients == null) {
			throw new IllegalArgumentException("Invalid ingredients");
		}
		
		this.ingredients = ingredients;	
	}
	
	TreeSet<String> getIngredients() {
		return this.ingredients;
	}
	
	public void incrementWins() {
		this.wins++;
	}
	
	public void incrementLoses() {
		this.loses++;
	}
	
	public double getScore() {
		return this.wins * 100/ (double)(this.loses + this.wins);
	}

	@Override
	public boolean equals(Object anotherRecipe) {
		
		Recipe recipe;
		if (anotherRecipe instanceof Recipe) {
			recipe = (Recipe) anotherRecipe;
		} else {
			return false;
		}
		
		if (this.ingredients.size() != recipe.ingredients.size()) 
			return false;
		
		for (String ingredient : this.ingredients) {
			if (!recipe.ingredients.contains(ingredient)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {		
		return this.ingredients.toString().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();		
		sb.append(this.ingredients.toString());		
		sb.append(String.format(" Wins: %d, Loses: %d, Score: %s", this.wins, this.loses, this.getScore()));		
		return sb.toString();		
	}
}
