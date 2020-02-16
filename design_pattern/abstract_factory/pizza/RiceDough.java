package design_pattern.abstract_factory.pizza;

public class RiceDough implements Dough {

	final String DESCRIPTION = "RiceDough";

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
