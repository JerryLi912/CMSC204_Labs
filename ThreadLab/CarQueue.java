import java.util.*;
public class CarQueue {

	private Queue<Integer> dirQueue = new PriorityQueue<Integer>();
	private Random randomNumber = new Random();
	private int delete;
	
	public CarQueue() {
		for (int i = 0; i < 20; i++) {
			dirQueue.add(randomNumber.nextInt(4));
		}
	}

	
	
	public void addToQueue() {
		class RandomThread implements Runnable{
			
			@Override
			public void run() {
				try {
					for (int i = 0; i < 6; i++) {
						dirQueue.add(randomNumber.nextInt(4));
					}
					Thread.sleep(1000);
					
				}catch(InterruptedException e) {
					e.printStackTrace();
				}	
			}
		}//end of class RandomThread
		
		RandomThread r = new RandomThread();
		Thread generateThread = new Thread(r);
		generateThread.start();
	}
	
	public int deleteQueue() {
	
		class RandomThreadTwo implements Runnable{
		public void run() {
			try {
				Thread.sleep(1000);
				
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		
			try {
				if(dirQueue.size() < 6) {
					for (int i = 0; i < 6; i++) {
					dirQueue.add(randomNumber.nextInt(4));
				}
				}
				else if (! dirQueue.isEmpty()) {
					delete = dirQueue.poll();
				}
			}finally {
				//do nothing
			}
		}
		}//end of class RandomThreadTwo
		RandomThreadTwo r2 = new RandomThreadTwo();
		Thread t2 = new Thread(r2);
		t2.start();
		return delete;
	}
}
