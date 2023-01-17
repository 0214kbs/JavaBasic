package lec0117.classobject.Constructor;

public class Test {

	public static void main(String[] args) {
		MyClass mc = new MyClass(); // 생성자 만들면 error
		// error message: The constructor MyClass() is undefined
		
		mc.n = 3;
		mc.str = "Hello";
		
		MyClass mc2 = new MyClass(1);
		MyClass mc3 = new MyClass(2,"Hello");
		
		System.out.println(mc.n);
		System.out.println(mc2.n);
		System.out.println(mc3.n);
		
		System.out.println(mc.str);
		System.out.println(mc2.str);
		System.out.println(mc3.str);
	}

}
