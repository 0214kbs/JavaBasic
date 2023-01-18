package lec0118.oop.inheritance;

public class Test1 {

	public static void main(String[] args) {
//		Parent1 p1 = new Parent1();
//		System.out.println(p1.name);
//		
//		Child1 c1 = new Child1();
//		System.out.println(c1.name);
		
		Child1 c1 = new Child1();
		c1.m();
	
	}

}

class Parent1{
	String name = "Parent";
}

class Child1 extends Parent1{
	
	String name = "Child";	//comment 처리 시, name, this.name, super.name 모두 "Child" 출력됨 
	
	void m() {
		System.out.println(name);	// "Child" 출력 -> name = "Parent"였는데 "Child"로 덮여씌어진 것이다? XXXXXX
		System.out.println(this.name);
		System.out.println(super.name);	// 부모 영역
	}
}