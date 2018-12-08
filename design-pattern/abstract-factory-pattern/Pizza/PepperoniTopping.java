package designpattern.abstractfactory.pizza;

public class PepperoniTopping implements Topping {

	final String DESCRIPTION = "PepperoniTopping";

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
