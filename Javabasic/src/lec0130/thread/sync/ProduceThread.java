package lec0130.thread.sync;

public class ProduceThread extends Thread {
	Gas gas;
	public ProduceThread(Gas gas) {
		this.gas = gas;
	}
	
	
	@Override
	public void run() {
		gas.produce();
	}
}
