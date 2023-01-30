package lec0130.thread.sync;

public class Gas {
	private int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public synchronized void consume() {
		this.amount -= 100;
		
		// Thread 작업을 일시 중지 -> 다른 thread에게 기회를 넘길 확률이 높아진다. 
		try {
			Thread.sleep(10);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(this.amount);
	}
	// 어떤 쓰레드가 synchronized 메소드를 호출하면
	// 다른 thread가 이 메소드가 끝날때까지 중간에 끼어들지 못함 
	public synchronized void produce() {
		this.amount += 100;
		try {
			Thread.sleep(10);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(this.amount);
	}
}
