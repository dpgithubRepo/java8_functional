package ExecuteAroundPattern;

import java.util.List;

import ExecuteAroundPattern.Customer.CustomerFactory;

/**
 * 
 * @author Durga Prasad
 *
 */


/**
 * 
 * 
 * Requirement
 * 
 * acquire DB Connection
 * Fetch customer records from DB  
 * Greet Customer*****
 * close DB connection
 *
 *
 * acquire DB Connection
 * Fetch customer records from DB  
 * Remind Customer about payment*****
 * close DB connection
 *
 *
 *acquire DB Connection
 *Fetch customer records from DB  
 *Notify Customer about special discount offers*****
 *close DB connection
 *
 *
 *
 *
 * Pre Operations => 1. acquire DB connection 2. Fetch Customer Records from DB
 * Post Operation => close DB connection
 * 
 * This Pre & Post operations can be considered as execute around operations and actual operation/behavior is passed
 *
 */

class CustomerNotificationService{
	
	public void acquireDatabaseConnection() {
		System.out.println("PRE-STEP ::: acquired db connection and test connect success....\n");
	}
	
	
	public List<Customer> getCustomers() {
		System.out.println("PRE-STEP ::: fetching Customers \n");
		return CustomerFactory.customers;
	}
	
	public void closeDbConnection() {
		System.out.println("POST-STEP ::: db connection closed success...\n");
	}
	
	
	public void notifyCustomer(ProcessMessage pm, String msg) {
		acquireDatabaseConnection();
		List<Customer> cutomers = getCustomers();
		pm.sendMessage(cutomers, msg);
		closeDbConnection();
	}
	
}



public class DatabaseExecuteAroundPattern {
	
	public static void main(String[] args) {
		
		ProcessMessage newYearMsgProcessor  =  (customers, msg) -> {
			for(Customer c: customers) {
				System.out.println("Hello "+ c.getName() + ", " + msg );
			}
		};
		
		
		
		
		CustomerNotificationService cns = new CustomerNotificationService();
		
		// An Execute Around Method is where you pass arbitrary code to a method, which may perform Pre Step and/or Post step code and execute passed code in between.
		// we are using the functional interface to pass the arbitrary code
		
		
		//greet the users
		cns.notifyCustomer(newYearMsgProcessor, "HAPPY Holidays !!! \n");
		
		//payment reminder
		cns.notifyCustomer(newYearMsgProcessor, "Auto Payment Reminder for this month......ignore if already paid !!!  \n");
		
		// discount notification
		cns.notifyCustomer(newYearMsgProcessor, "This festive season we are running, special discounts..check our website ;-) !!! \n");
	}
	
	

}

interface ProcessMessage{
	void sendMessage(List<Customer> customers, String msg);
}

 class Customer{
	private final String name;
	private final String mob;
	public Customer(String name, String mob) {
		super();
		this.name = name;
		this.mob = mob;
	}
	public String getName() {
		return name;
	}
	public String getMob() {
		return mob;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", mob=" + mob + "]";
	}
	
	
	
	class CustomerFactory{
		
		static List<Customer> customers = List.of(new Customer("Mr.Bob", "12345"),
				new Customer("Mr.xyz", "9089"),new Customer("Mrs.lmn", "67658")	);
	}
	
}

