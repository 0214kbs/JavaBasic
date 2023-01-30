package lec0130.thread.waitnotify;

public class Gas {
	private int amount;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public synchronized void consume() {	
		while(this.amount<100) {
			// 무한정 기다린다. => 나 잠시 떠나 있을게.. 하지만, 내가 lock을 잡았던거 잊지마! 라는 의미 
			try {
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		this.amount -= 100;
		this.notifyAll();
		// Thread 작업을 일시 중지 -> 다른 thread에게 기회를 넘길 확률이 높아진다. 
		try {
			Thread.sleep(20);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(this.amount);
	}
	// 어떤 쓰레드가 synchronized 메소드를 호출하면
	// 다른 thread가 이 메소드가 끝날때까지 중간에 끼어들지 못함 
	public synchronized void produce() {
		while(this.amount>=1000) {
			// 무한정 기다린다. => 나 잠시 떠나 있을게.. 하지만, 내가 lock을 잡았던거 잊지마! 라는 의미 
			try {
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		this.amount += 100;
		this.notifyAll();
		try {
			Thread.sleep(40);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(this.amount);
	}
}
