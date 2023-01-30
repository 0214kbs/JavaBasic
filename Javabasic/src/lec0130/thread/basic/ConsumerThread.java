package lec0130.thread.basic;
// Thread가 되기위한 조건 2가지
// 1. extends Thread
// 		- 이 클래스의 객체는 이미 thread
// 2. 
public class ConsumerThread extends Thread {

	int num;
	public ConsumerThread(int num) {
		this.num = num;
	}
	@Override
	public void run() {
		// 이곳에 작성된 코드가 JVM에 의해 concurrent하게 처리됨 
		System.out.println("#"+num+" is started!");
		for(int i=0;i<1000;i++) {
			System.out.println("#"+num+" : "+i);
		}
		System.out.println("#"+num+" is Done!");
	}
}
