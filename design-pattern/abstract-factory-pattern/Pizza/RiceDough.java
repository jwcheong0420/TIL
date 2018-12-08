package designpattern.abstractfactory.pizza;

public class RiceDough implements Dough {

	final String DESCRIPTION = "RiceDough";

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
