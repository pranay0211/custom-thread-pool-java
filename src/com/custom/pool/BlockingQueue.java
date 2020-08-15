package com.custom.pool;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {

	private Queue<T> queue = new LinkedList<T>();

	private int EMPTY = 0;
	private int MAX_TASK_IN_QUEUE = 1;

	public BlockingQueue(int size) {
		this.MAX_TASK_IN_QUEUE = size;
	}

	public synchronized void enqueue(T task) throws InterruptedException {
		while (this.MAX_TASK_IN_QUEUE == this.queue.size()) {
			wait();
		}
		if (this.EMPTY == this.queue.size()) {
			notifyAll();
		}
		this.queue.offer(task);
	}

	public synchronized T dequeue() throws InterruptedException {
		while (this.EMPTY == this.queue.size()) {
			wait();
		}
		if (this.MAX_TASK_IN_QUEUE == this.queue.size()) {
			notifyAll();
		}
		return this.queue.poll();
	}

}
