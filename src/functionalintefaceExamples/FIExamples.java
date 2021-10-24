package functionalintefaceExamples;

public class FIExamples {
	
	public static void main(String[] args) {
		
		//create a thread and run a loop to print 1 to 10
		new Thread(()->{
			for(int i = 1; i <=10; i++) {
				System.out.println(i);
			}
		}).start();
		
		
	}

}
