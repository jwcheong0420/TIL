package design_pattern.abstract_factory.pizza;

public interface PizzaAbstractFactory {
	Dough kneadDough();

	Sauce makeSauce();

	Topping prepareTopping();
}
