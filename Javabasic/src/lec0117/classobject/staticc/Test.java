package lec0117.classobject.staticc;

public class Test {
	//static block
	//해당 클래스가 메모리에 load될 때 수행
	static {
		System.out.println(1);
	}
	public static void main(String[] args) {
		

		//static : 객체를 만들지 않고도 접근 가능
		 System.out.println(MyClass.COUNT);
		 MyClass.staticMethod();
		 
		 
		 //static : 생성된 객체를 통해서도 접근 가능
		 MyClass mc = new MyClass();
		 System.out.println(mc.COUNT);
		 mc.staticMethod(); 
		 //단, 경고 메시지 존재 : 
		 //The static ~ from the type MyClass should be accessed in a static way
		
		MyClass mc2 = new MyClass();
		mc2.method();
		 
	}

}
