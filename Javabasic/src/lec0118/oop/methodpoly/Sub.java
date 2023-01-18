package lec0118.oop.methodpoly;

import java.io.IOException;
import java.io.FileNotFoundException;

public class Sub extends Super{
	
	// compiler 오버라이딩 확인 방법 @Override 해서 에러 유무 확인 
	@Override
//	int m(int i) { // e.m. The method m(int) of type Sub must override or implement a supertype method	
	int m(){
		System.out.println("Sub - m()");
		return 1; // 내용이 변경되어도 error 발생
	}
	
	// return type이 reference이면
	// 부모 return type보다 상위 type이면 XX
	// 부모 return type보다 하위 type이면 OO
	@Override
	C m2() {
		System.out.println("Sub - m2()");
		return new C();
	}
	
	// access modifier
	// 부모보다 줄일 수 없다. (늘리는 건 가능)
	// private < default < protected < public
	@Override
	public void m3() {
		// private, default라면, e.m.  Cannot reduce the visibility of the inherited method from Super
		// protected, public은 가능
		System.out.println("Sub - m3()");
	}
	
	// throws 예외는 같거나 부모보다 더 적은(하위) 예외를 throws해야함 
	@Override
	void m4() throws FileNotFoundException { 
		// Exception > IOException >FileNotFoundException
		// IOException 대신 Exception 할경우 : e.m.  Exception is not compatible with throws clause in Super.m4()
		System.out.println("Sub - m4() ");
	}
	
	void m5() {
		
	}
}
