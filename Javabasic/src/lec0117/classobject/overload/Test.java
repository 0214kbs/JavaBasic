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
	}

}
