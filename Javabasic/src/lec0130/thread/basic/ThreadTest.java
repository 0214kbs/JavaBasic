package lec0130.thread.basic;

public class ThreadTest {

	public static void main(String[] args) {
		ConsumerThread c1 = new ConsumerThread(1); //이미 thread
		Thread c2 = new Thread(new ConsumerRunnable(2));
		Thread c3 = new Thread(()-> {
			System.out.println("#"+3+" is started!");
			for(int i=0;i<1000;i++) {
				System.out.println("#"+3+" : "+i);
			}
			System.out.println("#"+3+" is Done!");
		});
		// Thread를 호출(실행)할 때는 start() 메소드로 호출한다
		// JVM이 start()된 thread객체를 Runnable state에 올려놓고 경쟁 시킴 
		// 경쟁을 이긴 thread가 선택되면 run() 수행 
		// run() 를 수행 도중에 다시 경쟁이 이어져서 특정한 thread객체에게 모든 자원을 다 주지 않음
		// 따라서 run()을 수행하다가도 다른 thread 객체가 경쟁을 이기게 되면 run() 하던 thread는 다시 
		// runnable 상태로 돌아와서 경쟁을 다시 시작 
		c1.start();
		c2.start();
		c3.start();
		
	}

}
