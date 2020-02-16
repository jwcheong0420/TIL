package design_pattern.abstract_factory.pizza;

public class Pizza {
	private Dough dough;
	private Sauce sauce;
	private Topping topping;

	public Dough getDough() {
		return dough;
	}

	private void setDough(Dough dough) {
		this.dough = dough;
	}

	public Sauce getSauce() {
		return sauce;
	}

	private void setSauce(Sauce sauce) {
		this.sauce = sauce;
	}

	public Topping getTopping() {
		return topping;
	}

	private void setTopping(Topping topping) {
		this.topping = topping;
	}

	public void cookPizza(PizzaAbstractFactory pizzaFactory) {
		setDough(pizzaFactory.kneadDough());
		setSauce(pizzaFactory.makeSauce());
		setTopping(pizzaFactory.prepareTopping());
	}

	public static void main(String[] args) {
		System.out.println("===Cook Pepperoni Pizza===");
		Pizza pepperoniPizza = new Pizza();
		PepperoniPizzaFactory pepperoniPizzaFactory = new PepperoniPizzaFactory();
		pepperoniPizza.cookPizza(pepperoniPizzaFactory);
		System.out.println(pepperoniPizza.getDough().getDescription());
		System.out.println(pepperoniPizza.getSauce().getDescription());
		System.out.println(pepperoniPizza.getTopping().getDescription());

		System.out.println("===Cook Korean Pizza===");
		Pizza koreanPizza = new Pizza();
		KoreanPizzaFactory koreanPizzaFactory = new KoreanPizzaFactory();
		koreanPizza.cookPizza(koreanPizzaFactory);
		System.out.println(koreanPizza.getDough().getDescription());
		System.out.println(koreanPizza.getSauce().getDescription());
		System.out.println(koreanPizza.getTopping().getDescription());
	}
}
