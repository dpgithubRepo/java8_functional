package OutOfBoxFunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


/**
 * 
 * @author Durga Prasad
 * 
 * The java.util.function.Predicate<T> interface defines a abstract method test which accepts Object and returns boolean
 *
 */
public class PredicateFunctionalInterfaceUsage {
 public static void main(String[] args) {
	
	 Predicate<Integer> eventNumPredicate = num -> num % 2 == 0;
	 Predicate<Integer> oddNumPredicate = num -> num % 2 == 1;
	 
	 List<Integer> nums = List.of(1,2,3,4,5,6,7,8);
	 
	 List<Integer> evenNums = filter(nums, eventNumPredicate);
	 System.out.println(evenNums);
	 
	 
	 List<Integer> oddNums = filter(nums, oddNumPredicate);
	 System.out.println(oddNums);
	 
	 
	 List<String> strs = List.of("abcd","hello","hi","bye");
	 Predicate<String> minLenStringsPred = str -> str.length() > 3;
	 
	 List<String> minLenStrings = filter(strs, minLenStringsPred);
	 System.out.println(minLenStrings);
	 
	 
	 List<Customer> customers = CustomerFactory.customers;
	 Predicate<Customer> maleCustomerPred = (c)->c.getGender()=='M';
	 List<Customer> maleCustomers = filter(customers, maleCustomerPred);
	 
	 System.out.println(maleCustomers);
			 
	 
	 
}
 
 public static <T> List<T> filter(List<T> list, Predicate<T> predicate){
	 List<T> resultList = new ArrayList<>();
	 for(T t : list) {
		 if(predicate.test(t)) {
			 resultList.add(t);
		 }
	 }
	 return resultList;
 }
}



class Customer{
	private final String name;
	private final String mob;
	private final char gender;
	public Customer(String name, String mob, char gender) {
		super();
		this.name = name;
		this.mob = mob;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public char getGender() {
		return gender;
	}
	public String getMob() {
		return mob;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", mob=" + mob + "]";
	}
	
}
	
	class CustomerFactory{
		
		static List<Customer> customers = List.of(new Customer("Mr.Bob", "12345",'M'),
				new Customer("Mr.xyz", "9089",'M'),new Customer("Mrs.lmn", "67658", 'F')	);
	}
	
