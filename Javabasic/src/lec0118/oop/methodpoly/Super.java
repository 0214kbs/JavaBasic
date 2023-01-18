package lec0118.oop.methodpoly;

import java.io.IOException;

public class Super {
	// return : primitive
	int m() {
		System.out.println("Super - m()");
		return 1;
	}
	
	// return : reference 
	B m2() {
		System.out.println("Super - m2()");
		return new B();
	}
	
	protected void m3() {
		System.out.println("Super - m3()");
	}
	
	void m4() throws IOException {
		System.out.println("Super - m4()");

	}
}
