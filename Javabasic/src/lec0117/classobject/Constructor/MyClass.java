package lec0117.classobject.Constructor;

public class MyClass {
	int n;
	String str;

	//생성자
	MyClass(){};
	MyClass(int n){
		this.n = n;
	}
	MyClass(int n, String str){
		this.n = n;
		this.str = str;
	}

}
