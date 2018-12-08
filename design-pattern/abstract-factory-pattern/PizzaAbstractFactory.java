package designpattern.abstractfactory.pizza;

public interface PizzaAbstractFactory {
	Dough kneadDough();

	Sauce makeSauce();

	Topping prepareTopping();
}
