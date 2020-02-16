package design_pattern.abstract_factory.pizza;

public class PepperoniTopping implements Topping {

	final String DESCRIPTION = "PepperoniTopping";

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
