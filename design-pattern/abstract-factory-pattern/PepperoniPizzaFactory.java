package designpattern.abstractfactory.pizza;

public class PepperoniPizzaFactory implements PizzaAbstractFactory {

	@Override
	public Dough kneadDough() {
		return new WheatDough();
	}

	@Override
	public Sauce makeSauce() {
		return new TomatoSauce();
	}

	@Override
	public Topping prepareTopping() {
		return new PepperoniTopping();
	}

}
