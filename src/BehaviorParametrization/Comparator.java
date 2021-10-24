package BehaviorParametrization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparator {

	public static void main(String[] args) {
		List<Apple> apples = AppleFactory.apples;
		
		//AppleFactory.apples creates list using List.of which creates immutable list and because of this Collections.sort can't be applied on immutable list
		//hence this new list created
		List<Apple> appleList = new ArrayList<>(apples);
		
		System.out.println(appleList);
		
		Collections.sort(appleList, (a1,a2) -> a1.getWeight().compareTo(a2.getWeight()));
		
		
		System.out.println(appleList);
	}
}
