package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test2  {

	private static List<Long> list = new ArrayList<Long>();

	public static void main(String[] args) throws InterruptedException {
		// Write 2 Threads
		// 1 thread that write to the list a random long number every 10 ms second
		// 1 thread that read from the list the first number every 15ms, output it to
		// the console and delete it from the list.
		// the program runs for 15 seconds

		Thread workerThread1 = addRondomNumberThread(15000, 1000);
		
		Thread workerThread2 = removeRandomNumberThread(15000, 1500);

		// Start the worker thread
		workerThread1.start();
		workerThread2.start();

		try {
			// Wait for the worker thread to finish (optional)
			workerThread1.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

	}

	private static Thread removeRandomNumberThread(long inTimeout, long inSleep) {
		return new Thread(() -> {
			try {
				long startTime = System.currentTimeMillis();
				long timeout = inTimeout; // 15 seconds in milliseconds

				while (System.currentTimeMillis() - startTime < timeout) {
					// Perform some task here
					
					removeRandomNumber();					

					// Simulate a task by sleeping for a short interval (e.g., 1 second)
					Thread.sleep(inSleep); // Sleep for 1 second (adjustable)
				}

			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread was interrupted");
			}
		});
	}

	private static Thread addRondomNumberThread(long inTimeout, long inSleep) {
		Thread workerThread1 = new Thread(() -> {
			try {
				long startTime = System.currentTimeMillis();
				long timeout = inTimeout; // 15 seconds in milliseconds

				while (System.currentTimeMillis() - startTime < timeout) {
					// Perform some task here
					
					addRandomNumber();

					// Simulate a task by sleeping for a short interval (e.g., 1 second)
					Thread.sleep(inSleep); // Sleep for 1 second (adjustable)
				}

				

			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread was interrupted");
			}
		});
		return workerThread1;
	}

	private static void removeRandomNumber() {
		if (!list.isEmpty()) {
			//output it to
			// the console and delete it from the list
			System.out.println(list.get(0));
			list.remove(0);
		}
	}

	private static void addRandomNumber() {
		Random rand = new Random();
		list.add(rand.nextLong());
	}
}
