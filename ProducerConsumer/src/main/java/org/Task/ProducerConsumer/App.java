package org.Task.ProducerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		BlockingQueue<Integer> blockingQueue=new LinkedBlockingQueue<Integer>();
		Thread producer=new Thread(new Producer(blockingQueue));
		Thread consumer=new Thread(new Consumer(blockingQueue));
		producer.start();
		consumer.start();
}
}
