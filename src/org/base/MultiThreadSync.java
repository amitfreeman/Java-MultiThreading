package org.base;
///this comment should be uploaded please

class Counter{
	private int count;

	/* its thread safe
	 * multiple threads will wait will other finish operation on count
	 * word synchronized is sufficient
	 */
	public  void increment() {
		synchronized(this) {
		  count++;
		}
	}

	public int getCount() {
		return count;
	}

}

public class MultiThreadSync {

	public static void main(String[] args) throws InterruptedException {
		Counter c=new Counter();

		Thread t1=new Thread( ()->  {
			for(int i=0; i<1000; i++) {
				c.increment();
			}		
		} );

		Thread t2=new Thread( ()->  {	
			for(int i=0; i<1000; i++) {
				c.increment();
			}		
		} );


		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("count: "+c.getCount());
	}
}
