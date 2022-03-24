package org.Task.ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	private final BlockingQueue<Integer> blockingQueue;

	public Producer(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	
	public void run()
	{
		for(int i=10;i<=100;i+=10) { 
			try {
				
				blockingQueue.put(i);
				System.out.println("Producer"+i);
			}
			catch (InterruptedException e) {
				System.out.println("Producer Interrupt");
			}
		}
	} 
}
