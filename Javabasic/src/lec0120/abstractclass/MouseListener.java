package lec0120.abstractclass;

public interface MouseListener {
	void click();
	void doubleClick();
	void over();
	void out();
	
	default void m() { // 추상메소드 : default 필수 
		System.out.println("default method");
	}
}
