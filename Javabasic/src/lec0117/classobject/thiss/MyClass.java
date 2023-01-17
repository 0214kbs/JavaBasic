package lec0117.classobject.thiss;

public class MyClass {
	int i;
	String s;
	
	void m() {
		// this란, this를 수행하는 코드의 "객체의 자기자신"
		System.out.println(this);
		System.out.println(this.i);
		System.out.println(this.s);
		
		this.m2();
		System.out.println("m()");
	}
	
	void m2() {
		System.out.println("m2()");
	}
	
	//생성자
	MyClass(){
		System.out.println("MyClass");
	}
	MyClass(int i){
		this.i = i;
		System.out.println("MyClass(int i)");
	}
	MyClass(int i, String s){
		this.i = i;
		this.s = s;
		/* 오류 (시험 다수 출제) 
		 * this.s = s;
		 * this(i); //첫번째줄에 와야함!!
		 * */
		System.out.println("MyClass(int i, String s)");
	}
}
