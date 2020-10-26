package org.base;


public class MultiThreadLambdaExpr {

	public static void main(String[] args) throws InterruptedException {
 
		//this is just like anonymous class
		// Runnable obj1 = new Runnable() { //run method };
		
		Thread t1=new Thread(() -> {
    		for(int i=0; i<5; ++i) {
    			System.out.println("Hi");
    			try { Thread.sleep(800); } catch (InterruptedException e) { e.printStackTrace(); }
    		}
    	} );
		
		Thread t2=new Thread(() -> {
    		for(int i=0; i<5; ++i) {
    			System.out.println("Hello");
    			try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace();}
    		}
    	} );
		
        t1.start();
        try{ Thread.sleep(10); } catch(Exception e) {}
        t2.start();
        
        System.out.println("Alive? : "+t1.isAlive());
        
        t1.join(); 
        t2.join();
        
        System.out.println("Alive? : "+t1.isAlive());
        
        System.out.println("Bye");
	}

}
