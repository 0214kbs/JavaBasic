package lec0130.thread.deadlock;

public class ThreadTest {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		Thread1 t1 = new Thread1(obj1,obj2);
		Thread2 t2 = new Thread2(obj1,obj2);
		
		t1.start();
		t2.start();
	}
}
