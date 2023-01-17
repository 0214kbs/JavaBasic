package lec0117.classobject.overload;

public class Test {

	public static void main(String[] args) {
		
		MyClass mc = new MyClass(3,"Hello");
		// MyClass(int i, String s)	MyClass(int i, Object s)
		// String이 호출되고, String 을 없애면 Object로 호출됨
		
		mc.method(1);
		mc.method(1,"Hello");
		mc.method(1,2);
		mc.method(1,2,3);
		mc.method(1,2,3,4);
		
		
		B b = new B();
		
		// 중간자 객체를 만들어 전달하게 되면 위에꺼?가 호출됨
		MyClass mc2 = new MyClass(b); // 생성자 MyClass(B b)없애면 A a 호출
		
	
		MyClass mc3 = new MyClass(null);
		//null이면, 가장 구체화된 (가장 하위) 가 호출됨
	}

}
