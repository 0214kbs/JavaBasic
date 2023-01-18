package lec0118.oop.methodpoly;
//method Polymorphism 2가지
// 1. overloading -> 이번 코드 생략  
// 2. overriding 

import java.io.IOException;

// # Overriding
// method signature = name+ param 
// method poly는 선언부의 메소드를 호출해도 구현부의 메소드가 실행된다. 

public class Test {
	public static void main(String[] args) throws IOException {
		Super s = new Sub();
		s.m();
		s.m2();
		s.m3();
		s.m4(); //e.m.  Unhandled exception type IOException
		
//		s.m5(); // 호출 불가 
	}
}


// compiler는 overriding 의 판단은 method signature의 일치여부로 판단한다.
// 일치해서 overriding 이라고 판명하면 overriding 규칙을 적용/확인
/* 
 * overriding 규칙(overriding을 할지말지 조건이 아님) 
 * 
 * 1. return type이 primitive이면 일치
 * 		int m()이면 똑같이 "int" (void, double, 이런거 안됨) 
 * 2. return type이 reference이면 부모 return type보다 하위 type이면 O
 * 3. access modifier인 경우, 부모보다 줄일 수 없다. (늘리는 건 가능)
 * 4. throws 예외는 같거나 부모보다 더 적은(하위) 예외를 throws해야함 
 * 
 * */

//# type poly + method poly
// 	=> 전달(parameter), 호출(부모쪽의 호출)은 type을 따르고 실행은 구현 객체를 따른다. 
