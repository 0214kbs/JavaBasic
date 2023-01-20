package lec0120.abstractclass;

public interface IB {
	void m1();
	// e.m.1 원인 IA와 IB에 동일한 m2()
	default void m2() {
		System.out.println("IB-m2");
	}
}
