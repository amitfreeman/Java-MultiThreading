package org.base;

class Hi extends Thread{
	
	public void run() {
		
		for(int i=0; i<5; ++i) {
			System.out.println("Hi");
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Hello extends Thread{
	
	public void run() {
		
		for(int i=0; i<5; ++i) {
			System.out.println("Hello");
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class MultiThreading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Hi obj1  = new Hi();
        Hello obj2 = new Hello();
        
        obj1.start();
        try{ Thread.sleep(10); } catch(Exception e) {}
        obj2.start();
        
	}

}
