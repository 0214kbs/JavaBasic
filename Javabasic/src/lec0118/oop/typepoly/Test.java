package lec0118.oop.typepoly;

//Type Polymorphism은 선언 타입을 따라간다. 
public class Test {
	public static void main(String[] args) {
		// Type Poly
		A ac = new D(); //왼쪽 선언된 것과 오른쪽에 만들어진 것이 상속관계면 가능
		
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		
		m(a);
		m(b);
		m(c);
		m(d);

		m2(c);
		m2(d);
		
		B bd = new D();
		m(bd);
		
////////////////////////////
		m3(a);
		m3(b);
		m3(c);
		m3(d);
	}
	
	
	//parameter에 type A가 전달되는 객체 A 뿐만 아니라, B,C,D를 모두 받을 수 있다. 
	static void m(A a) { // 최상위 클래스로 받고있기 때문에 에러 발생X , m(a)~m(d) 모두 정상 출력
		System.out.println("A -m()");
	}
	
	static void m(C a) {
		System.out.println("C -m()");
	}
	
	// 부모 호출 시 에러 발생 
	static void m2(C a) {
		System.out.println(" C- m2()");	
		//(B a) 일경우  m2(a) error
		// (C a) 일 경우 m2(a), m2(b) error
	}	

	
	static void m3(A m) {
		//전달되는 객체가 A,B,C,D 객체인지 구분해서 처리
		// instanceof : 상속 구분 못함
		
		
		// 따라서, 아래 코드는 "A 객체"만 출력함 
		/*
		if(m instanceof A) {
			System.out.println("A 객체");
		}else if(m instanceof B) {
			System.out.println("B 객체");
		}else if(m instanceof C) {
			System.out.println("C 객체");
		}else if(m instanceof D) {
			System.out.println("D 객체");
		}
		*/
		
		// instanceof를 상속관계에서 적용할 경우 하위 클래스 부터 적용 
		if(m instanceof D) {
			System.out.println("D 객체");
		}else if(m instanceof C) {
			System.out.println("C 객체");
		}else if(m instanceof B) {
			System.out.println("B 객체");
		}else if(m instanceof A) {
			System.out.println("A 객체");
		}
	}
}
 