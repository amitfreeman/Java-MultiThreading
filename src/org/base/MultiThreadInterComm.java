package org.base;

class Q{
	int num;
	boolean numSet=false;

	public synchronized void getNum() {
		//System.out.println(" --- In getNum numSet = "+this.numSet);
		while(!numSet) {
			//System.out.println(" --- In while getNum numSet = "+this.numSet);
			try{ this.wait(); } catch(Exception e) { e.printStackTrace(); }
		}
		System.out.println("Get num:: "+this.num);
		
		numSet=false;
		//System.out.println(" -- notifying from getNum , numSet = "+numSet);
		notify();  //notify producer thread
		//return num;
	}

	public synchronized void setNum(int num) {
		//System.out.println(" --- In setNum setNum = "+this.numSet);
		while(numSet) {
			//System.out.println(" --- In while setNum numSet = "+this.numSet);
			try{ this.wait(); } catch(Exception e) { e.printStackTrace(); }
		}
		
		this.num = num;
		
		numSet=true;
		//System.out.println(" -- notifying from setNum , numSet = "+numSet);
		notify();  //notify consumer thread
	}

}

class Producer implements Runnable{

	private Q q;
	
	public Producer(Q q) {
		this.q = q;
		Thread t=new Thread(this, "Producer");
		t.start();
	}

	@Override
	public  void run() {
			int i=0;
			while(++i<100) {
				System.out.println("Setting num to: "+i);
				q.setNum(i);
				try { Thread.sleep(500); } catch(Exception e) { e.printStackTrace(); }
			}
	}
	
}

class Consumer implements Runnable{
    Q q;
    
	public Consumer(Q q) {
		this.q = q;
		Thread t=new Thread(this, "Consumer");
		t.start();
	}

	@Override
	public void run() {
		int i=0;
		while(++i < 10000) {
			q.getNum();
			//System.out.println("Get num: "+q.getNum());
			try { Thread.sleep(2000); } catch(Exception e) { e.printStackTrace(); }
		}
	}
	
}


public class MultiThreadInterComm {

	public static void main(String[] args) {
		Q q=new Q();
		new Consumer(q);
		new Producer(q);
	}

}
