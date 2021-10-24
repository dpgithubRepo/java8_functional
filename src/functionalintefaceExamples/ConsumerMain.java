package functionalintefaceExamples;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerMain {

	public static void main(String[] args) {
		greetCustomer(new Customer("Mr.xyz", "12345678"));
		
		//consumer function
		greetCustFunc.accept(new Customer("Mr.xyz", "12345678"));
		
		greetCustByMsg.accept(new Customer("Mr.xyz","123456"), " howdy !!! HAVE A GREAT DAY !!!");
		greetCustomerMob.accept(new Customer("Mr.xyz","123456"), true);
		greetCustomerMob.accept(new Customer("Ms.celeb","98768"), false);
	}
	
	
	static Consumer<Customer> greetCustFunc = customer -> System.out.println("Hello "+customer.name +" you are now registered with "+ customer.mob);
	static BiConsumer<Customer, String> greetCustByMsg = (c,m) -> System.out.println("Hello "+ c.name + " "+ m);
	static BiConsumer<Customer, Boolean> greetCustomerMob = (c,showMob) -> System.out.println("Hello " +c.name + "Thanks for registering "+ (showMob?c.mob:""));
	
	
	static void greetCustomer(Customer customer) {
		System.out.println("Hello "+customer.name +" you are now registered with "+ customer.mob);
	}
	
	static class Customer{
		private final String name;
		private final String mob;
		public Customer(String name, String mob) {
			super();
			this.name = name;
			this.mob = mob;
		}
		@Override
		public String toString() {
			return "Customer [name=" + name + ", mob=" + mob + "]";
		}
		
		
	}
}
