package org.Task.ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	private final BlockingQueue<Integer> blockingQueue;
	public Consumer(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue=blockingQueue;
	}
	public void run() 
	{
		while(true) {
		try {
			System.out.println("Data consumed"+blockingQueue.take());
		}
		catch (InterruptedException e) {
			System.out.println("Consumer interrupt");
		}
	}
}
}
