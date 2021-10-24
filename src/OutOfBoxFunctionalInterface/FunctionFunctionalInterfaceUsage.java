package OutOfBoxFunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 
 * java.util.function.Function interface has abstract method apply that takes an object generic type & returns R type
 * 
 * @author Durga Prasad
 *
 */

public class FunctionFunctionalInterfaceUsage {

	public static void main(String[] args) {
		
		
		// takes list of string & returns list of integer denoting the length of the string
		Function<List<String>, List<Integer>> stringLenFunction = (strList) ->{
			List<Integer> numList = new ArrayList<>();
			for(String s: strList) {
				numList.add(s.length());
			}
			return numList;
		};
		
		List<String> strings = List.of("hello","ell", "el", "o");
		System.out.println(stringLenFunction.apply(strings));
		
		
		//bi function is similar to that of function, but takes 2 generic Objects as input and return R type
		BiFunction<Integer, Integer, Integer> multiplyFunc = (i ,j)-> i*j;
		System.out.println(multiplyFunc.apply(5, 100));
	}
}
