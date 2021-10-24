package functionalintefaceExamples;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalIntfMain {
	public static void main(String[] args) {
			int incr = incr(0);
			System.out.println(incr);
			//function
			incr = incrFunction.apply(0);
			System.out.println(incr);
			
			//chaining functions
			int res = incrFunction.andThen(mulBy10).apply(5); //first calls incrFunction & then mulBy10
			System.out.println(res);
			
			
			System.out.println(incrByOneMulBy(1, 10));
			//bi-function
			System.out.println(incrByOneMulByFunc.apply(1, 10));
	}

	static Function<Integer, Integer> incrFunction = n -> n+1;
	static Function<Integer,Integer> mulBy10 =  n -> n*10;
	static BiFunction<Integer, Integer, Integer> incrByOneMulByFunc = (n,multiplier) -> (n+1)*multiplier;

	
	static int incr(int number) {
		return number+1;
	}
	
	static int incrByOneMulBy(int n, int multiplier) {
		n = n+1;
		return n* multiplier;
	}
}
