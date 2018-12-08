package designpattern.abstractfactory.pizza;

public class WheatDough implements Dough {

	final String DESCRIPTION = "WheatDough";

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
