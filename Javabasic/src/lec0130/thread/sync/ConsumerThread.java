package lec0130.thread.sync;

public class ConsumerThread extends Thread {

	Gas gas;
	public ConsumerThread(Gas gas) {
		this.gas = gas;
	}
	
	
	@Override
	public void run() {
		gas.consume();
	}
}
