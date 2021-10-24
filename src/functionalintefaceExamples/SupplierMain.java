package functionalintefaceExamples;

import java.util.List;
import java.util.function.Supplier;

public class SupplierMain {
	
	public static void main(String[] args) {
		
		System.out.println(getDBConnectionURL());
		
		System.out.println("//supplier");
		
		Supplier<String> dbConnSupplier = ()->"jdbc://localhost:5432/test_db";
		
		System.out.println(dbConnSupplier.get());
		
		
		Supplier<List<Customer>> getCustomers = ()-> List.of( new Customer("Mr.XYZ", "1223"), new Customer("ms.abc", "8979"));
		
		System.out.println(getCustomers.get());
	}

	
	static String getDBConnectionURL() {
		return "jdbc://localhost:5432/test_db";
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
