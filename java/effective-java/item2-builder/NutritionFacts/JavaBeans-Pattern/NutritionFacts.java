package effectivejava.builder.nutritionfacts.javabeanspattern;

public class NutritionFacts {
	// initialize optional member fields to default value
	private int servingSize = -1;	// no default value
	private int servings = -1;		// no default value
	private int calories = 0;
	private int fat = 0;
	private int sodium = 0;
	private int carbohydrate = 0;

	public NutritionFacts() {
	}

	public void setServingSize(int val) {
		this.servingSize = val;
	}

	public void setServings(int val) {
		this.servings = val;
	}

	public void setCalories(int val) {
		this.calories = val;
	}

	public void setFat(int val) {
		this.fat = val;
	}

	public void setSodium(int val) {
		this.sodium = val;
	}

	public void setCarbohydrate(int val) {
		this.carbohydrate = val;
	}

	public static void main(String[] args) {
		NutritionFacts cocaCola = new NutritionFacts();
		cocaCola.setServingSize(240);
		cocaCola.setServings(8);
		cocaCola.setCalories(100);
		cocaCola.setSodium(35);
		cocaCola.setCarbohydrate(27);
	}
}