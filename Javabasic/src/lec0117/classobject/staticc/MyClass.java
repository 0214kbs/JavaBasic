package lec0117.classobject.staticc;

public class MyClass {
	static int COUNT =10; // java에서 static 변수는 대문자로 쓰는것이 일반적임
	int num = 20;
	
	//static block
	//해당 클래스가 메모리에 load될 때 수행
	static {
		System.out.println(2);
	}
	
	void method() {
		System.out.println("non static method");
		System.out.println(num);
		//일반 메소드에서 static 변수에 접근 가능
		System.out.println(COUNT);
	}
	
	//static method
	static void staticMethod() {
		System.out.println("static method");
		
		// System.out.println(num); //error
		// num : 객체가 만들어져야지만 접근할 수 있음
		// 즉, static 메소드에서는 일반 멤버변수에 접근할 수 없다. 
		
		System.out.println(COUNT);
	}
	
	//static block
	//해당 클래스가 메모리에 load될 때 수행
	static {
		System.out.println(3);
	}
}
