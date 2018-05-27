package com.infotech.client1;

public class StringHandingThread implements Runnable {
	private String s;

	// Constructor
	public StringHandingThread(String s) {
		this.s = s;
	}

	@Override
	public void run() {
		System.out.println("in run method " + Thread.currentThread().getName());

		try {
			// introducing some delay
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Adding to String
		s = s + Thread.currentThread().getName();
		System.out.println("String " + s);
	}

	public static void main(String[] args) {
		String str = "abc";
		// Three threadss
		Thread t1 = new Thread(new StringHandingThread(str));
		Thread t2 = new Thread(new StringHandingThread(str));
		Thread t3 = new Thread(new StringHandingThread(str));
		t1.start();
		t2.start();
		t3.start();
		// Waiting for all of them to finish
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("String is " + str.toString());
	}
}