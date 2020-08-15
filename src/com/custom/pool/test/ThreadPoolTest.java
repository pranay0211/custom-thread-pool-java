package com.custom.pool.test;

import com.custom.pool.ThreadPool;

public class ThreadPoolTest {

	public static void main(String... strings) throws InterruptedException {
		ThreadPool pool = new ThreadPool(3, 4);
		for (int i = 1; i <= 7; i++) {
			TestTask t = new TestTask(i);
			pool.submitTask(t);
		}
	}

}
