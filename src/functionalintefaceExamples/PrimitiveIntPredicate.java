package functionalintefaceExamples;

import java.util.function.IntPredicate;

/**
 * 
 * @author Durga Prasad
 *
 *
 *
 *Converting a primitive to it's corresponding reference type is called Boxing and vice-versa of converting reference type to
 * corresponding primitive is called un-boxing. Boxing has performance cost as the reference  type gets stored in heap where as
 * the primitives gets stored in stack.Taking this to consideration there are primitive version of functional interfaces to avoid
 * this boxing work
 */
public class PrimitiveIntPredicate {

	public static void main(String[] args) {
		
		IntPredicate intPred = i -> i % 2 == 0;  //no boxing
		
		System.out.println(intPred.test(4));  
		System.out.println(intPred.test(5));
		
	}
}
