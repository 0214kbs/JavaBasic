package lec0130.thread.sync;

public class ThreadTest {

	public static void main(String[] args) {
		Gas gas = new Gas();
		gas.setAmount(100);
		
		for(int i=0;i<1000;i++) {
			ConsumerThread ct = new ConsumerThread(gas);
			ProduceThread pt = new ProduceThread(gas);
			ct.start();
			pt.start();
		}
		
	}

}
