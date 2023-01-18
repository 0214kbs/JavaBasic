package lec0118.oop.inheritance;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	void m() {
		System.out.println(name);
	}
}