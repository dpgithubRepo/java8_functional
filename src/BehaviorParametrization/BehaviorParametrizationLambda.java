package BehaviorParametrization;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

interface ApplePredicate{
	boolean test(Apple apple);
}


public class BehaviorParametrizationLambda {
	
	/**
	 * /**
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
	 * 
	 * @param apples
	 * @param predicate
	 * @return
	 */
	public static List<Apple> filterApple(List<Apple> apples, ApplePredicate predicate){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: apples) {
			if(predicate.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<Apple> apples = AppleFactory.apples;
		
		//strategies passed as lambda expression
		System.out.println(filterApple(apples, apple->apple.getWeight()>=150));
		System.out.println(filterApple(apples, apple->apple.getWeight()<150));
		System.out.println(filterApple(apples, apple->apple.getColor().equals("Green")));
		System.out.println(filterApple(apples, apple->apple.getColor().equals("Red")));
		
		
	}

}
