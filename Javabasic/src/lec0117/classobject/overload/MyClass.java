package lec0117.classobject.overload;

public class MyClass {
	
	int n1;
	int n2;
	
	//method overload
	//method signature => method name과 parameter type, count로 구별, return type은 포함되지 않음
	void method() {
		System.out.println("nothing");
	}
	void method(int i) {
		System.out.println("int i");
	}
//	int method(int i) {} // 중복 메서드로 인식해서 에러 뜸
	void method(int i, String s) {
		System.out.println("int i, String s");
	}

	void method(int... args) { // variable argument : type만 정하고 개수가 정해지진 않음 
		System.out.println("int i...");
		System.out.print(args[0]+" ");
		System.out.print(args[1]+" ");
		//System.out.print(args[2]+" ");
		// (1,2)일 때 에러남 
		System.out.println();
	}
	
	// 생성자constructor overload
	MyClass(){}

	MyClass(int i, Object s){
		System.out.println("MyClass(int i, Object s)");
		
	}
	MyClass(int i, String s){
		System.out.println("MyClass(int i, String s)");
	}
	
}
