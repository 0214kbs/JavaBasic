package lec0120.abstractclass;

public interface IA {
	void m1();
	default void m2() {
		System.out.println("IA-m2");
	}
	
	void m3();
}
