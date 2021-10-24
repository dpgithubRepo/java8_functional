package functionalintefaceExamples;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer {

	BlockingQueue<Integer> queue;

	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void produce() {
		Random rand = new Random();

		while (true) {
			try {
				Thread.sleep(1000);
				Integer prodVal = Integer.valueOf(rand.nextInt());
				queue.put(prodVal);
				System.out.println("produced " + prodVal);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer {
	BlockingQueue<Integer> queue;

	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void consume() {
		
		while(true) {
		try {
			Thread.sleep(2000);
			System.out.println("consumed :: "+queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}

}

public class ProdConsThreadProb {
	public static void main(String[] args) {
		
		BlockingQueue<Integer> queue  = new ArrayBlockingQueue<>(4);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		new Thread(()->{
			producer.produce();
		}).start();
		
		new Thread(()->{
			consumer.consume();
		}).start();
		
	}
}
