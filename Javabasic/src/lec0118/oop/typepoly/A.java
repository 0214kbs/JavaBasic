package lec0118.oop.typepoly;

public class A {
	void m() {
		System.out.println("A - m()");
	}
}

class B extends A{
	void m() {
		System.out.println("B - m()");
	}

}

class C extends B{
	void m() {
		System.out.println("C - m()");
	}

}

class D extends C{
	void m() {
		System.out.println("D - m()");
	}

}