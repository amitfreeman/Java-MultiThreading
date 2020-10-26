package org.base;

public class MultiThreadPriority {

	public static void main(String[] args) throws InterruptedException {
 
		//this is just like anonymous class
		// Runnable obj1 = new Runnable() { //run method };
		
		Thread t1=new Thread(() -> {
    		for(int i=0; i<5; ++i) {
    			System.out.println("Hi");
    			try { Thread.sleep(800); } catch (InterruptedException e) { e.printStackTrace(); }
    		}
    	} , "Hi-Thread");
		
		Thread t2=new Thread(() -> {
    		for(int i=0; i<5; ++i) {
    			System.out.println("Hello");
    			try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace();}
    		}
    	}, "Hello-Thread" );
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		System.out.println("Starting: "+t1.getName()+" prio:"+t1.getPriority());
		System.out.println("Starting: "+t2.getName()+" prio: "+t2.getPriority());
		
        t1.start();
        try{ Thread.sleep(10); } catch(Exception e) {}
        t2.start();
        
        System.out.println("t1 Alive? : "+t1.isAlive());
        
        t1.join(); 
        t2.join();
        
        System.out.println("t1 Alive? : "+t1.isAlive());
        
        System.out.println("Bye");
	}

}
