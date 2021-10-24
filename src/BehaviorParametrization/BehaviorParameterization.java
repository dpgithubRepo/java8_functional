package BehaviorParametrization;

import java.util.ArrayList;
import java.util.List;

//create strategies
interface AppleFilterStategy {
	boolean test(Apple apple);
}

class AppleFilterByColorGreenStrategy implements AppleFilterStategy {
	@Override
	public boolean test(Apple apple) {
		return apple.getColor().equals("Green");
	}
}

class AppleFilterByColorRedStrategy implements AppleFilterStategy {
	@Override
	public boolean test(Apple apple) {
		return apple.getColor().equals("Green");
	}
}

class AppleFilterLightWeightStrategy implements AppleFilterStategy {
	@Override
	public boolean test(Apple apple) {
		return apple.getWeight() < 150;
	}
}

class AppleFilterHeavyWeightStrategy implements AppleFilterStategy {
	@Override
	public boolean test(Apple apple) {
		return apple.getWeight() >= 150;
	}
}

public class BehaviorParameterization {

	/**
	 * behavior parameterization means: the ability to tell a method to take
	 * multiple behaviors (or strategies) as parameters and use them internally to
	 * accomplish different behaviors
	 * 
	 * In the below method the AppleFilterStrategy takes the filter strategies which
	 * can be different and apply filter logic accordingly. This is also called the
	 * Strategy pattern.
	 * 
	 * Strategy Pattern lets you define a family of algorithms, encapsulate each
	 * algorithm (called a strategy), and select an algorithm at run-time. 
	 * 
	 * We have multiple strategies defined in the above classes.
	 * 
	 * @param apples
	 * @param strategy
	 * @return
	 */
	public static List<Apple> filterApples(List<Apple> apples, AppleFilterStategy strategy) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : apples) {
			if (strategy.test(apple)) {
				result.add(apple);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<Apple> apples = AppleFactory.apples;
		// list containing apples of weight >=150
		System.out.println(filterApples(apples, new AppleFilterHeavyWeightStrategy()));

		// list containing apples of weight < 150
		System.out.println(filterApples(apples, new AppleFilterLightWeightStrategy()));

		// list containing red apples
		System.out.println(filterApples(apples, new AppleFilterByColorRedStrategy()));

		// list containing green apples
		System.out.println(filterApples(apples, new AppleFilterByColorGreenStrategy()));
	}
}
