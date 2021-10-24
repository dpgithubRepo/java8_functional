package LambdasUsage;


/**
 * 
 * @author Durga Prasad
 * 
 * 
 * Where to use lambdas?  Lambdas can be used in context of FunctionalInterface
 * 
 * What is Functional Interface? A interface only with single abstract method
 *
 */
public class LambdasUsage {
	
	public static void main(String[] args) {
		 new ProcessImpl().process(()->{}); //valid runnable is void and takes no arguments
		 new ProcessImpl().process(()->System.out.println("lambda runnable"));
		 
		 new ProcessImpl().process(new Runnable() {
			 public void run() {
				 System.out.println("Anonymous runnable class");
			 }
		 });
		 
	//	 new ProcessImpl().process(()->{ return "hello";}); //not valid because runnable is void and expects no return
		 
	}

}


@FunctionalInterface   // this annotation is not mandatory but on violations of functional interface this gives compilation error.
interface Process{
	public void process(Runnable  r);
}


class ProcessImpl implements Process{

	@Override
	public void process(Runnable r) {
		r.run();
		
	}
	
}