package OutOfBoxFunctionalInterface;

import java.util.List;
import java.util.function.Consumer;

/**
 * 
 * The java.util.function.Consumer<T> interface defines an abstract method accept that takes an object 
 * of generic type and returns no result (void)
 * 
 * @author Durga Prasad
 *
 */
public class ConsumerFunctionalInterfaceUsage {

	public static void main(String[] args) {
		 List<Integer> nums = List.of(1,2,3,4,5,6,7,8);
		 Consumer<List<Integer>> printConsumer = (list)->{
			 for(int i : list) {
				 System.out.println(i);
			 }
		 };
		 
		 printConsumer.accept(nums);
		 
		 
	}
}
