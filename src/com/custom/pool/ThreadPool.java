package com.custom.pool;

public class ThreadPool {

	BlockingQueue<Runnable> queue;

	public ThreadPool(int queueSize, int nThread) {
		queue = new BlockingQueue<>(queueSize);
		String threadName = null;
		TaskExecutor task = null;

		for (int count = 0; count < nThread; count++) {
			threadName = "Thread" + count;
			task = new TaskExecutor(queue);
			Thread t = new Thread(task, threadName);
			t.start();
		}
	}
	
	public void submitTask(Runnable task) throws InterruptedException {
		queue.enqueue(task);
	}

}
