package design_pattern.abstract_factory.pizza;

public class BulgogiTopping implements Topping {

	final String DESCRIPTION = "BulgogiTopping";

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
