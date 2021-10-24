package BehaviorParametrization;

public class ThreadDemo {
	
	static class MyRunnable implements Runnable{

		@Override
		public void run() {
			System.out.println("Inside MyRunnable :: runnable impl class");
			
		}
		
	}

	public static void main(String[] args) {
		
		// passing Runnable impl to thread
		 new Thread(new MyRunnable()).start();
		
		
		 //// passing anonymous Runnable impl to thread
		new Thread(new Runnable() {
			public void run() {
				System.out.println("inside run method of anonymous runnable");
			}
		}).start();          
		
		
		//passing the lambda to Thread
		new Thread(()->System.out.println("inside run method of lambda runnable expression")).start();
	}
}
