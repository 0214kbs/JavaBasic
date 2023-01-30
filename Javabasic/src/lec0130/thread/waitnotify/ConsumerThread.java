package lec0130.thread.waitnotify;

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
