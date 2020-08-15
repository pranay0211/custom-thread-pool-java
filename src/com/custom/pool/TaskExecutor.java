package com.custom.pool;

public class TaskExecutor implements Runnable {

	BlockingQueue<Runnable> queue;

	public TaskExecutor(BlockingQueue<Runnable> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				String name = Thread.currentThread().getName();
				Runnable task = queue.dequeue();
				System.out.println("Thread " + name + " running..");
				task.run();
				System.out.println("Thread " + name + " executed.");
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

}
