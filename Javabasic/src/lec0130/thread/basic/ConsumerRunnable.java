package lec0130.thread.basic;
//Thread가 되기위한 조건 2가지
//1. 
//2. implements Runnable 
//	- 이 클래스의 객체는 아직 thread가 아님. Thread 객체를 따로 만들어주어야함 
public class ConsumerRunnable implements Runnable {
	
	int num;
	
	public ConsumerRunnable(int num) {
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
		
		StringBuffer sb = new StringBuffer();
		sb.append("a");
		StringBuilder sb2 = new StringBuilder();
		sb2.append("b");

	}
}
