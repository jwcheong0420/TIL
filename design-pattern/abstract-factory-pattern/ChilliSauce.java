package designpattern.abstractfactory.pizza;

public class ChilliSauce implements Sauce {

	final String DESCRIPTION = "ChilliSauce";

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
