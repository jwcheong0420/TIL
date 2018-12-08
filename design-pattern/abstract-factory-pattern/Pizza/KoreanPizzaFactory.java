package designpattern.abstractfactory.pizza;

public class KoreanPizzaFactory implements PizzaAbstractFactory {

	@Override
	public Dough kneadDough() {
		return new RiceDough();
	}

	@Override
	public Sauce makeSauce() {
		return new ChilliSauce();
	}

	@Override
	public Topping prepareTopping() {
		return new BulgogiTopping();
	}

}
