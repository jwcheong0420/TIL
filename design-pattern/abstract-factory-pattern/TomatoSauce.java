package designpattern.abstractfactory.pizza;

public class TomatoSauce implements Sauce {

	final String DESCRIPTION = "TomatoSauce";

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
