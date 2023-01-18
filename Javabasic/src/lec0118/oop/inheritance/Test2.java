package lec0118.oop.inheritance;

public class Test2 {

	public static void main(String[] args) {
		
//		Child2 c = new Child2("Child");
//		c.m(); // name, this.name, super.name 모두 "Child" 출력
		
		Child2 c = new Child2();
		c.setName("Child");
		c.m();
	}

}

class Parent2{
	String name = "Parent";
}

// Child2는 Parent2로부터 상속 받은 name을 변경하고자 한다. 
// super를 이용
// 생성자 또는 setter를 이용
class Child2 extends Parent2{
	
	Child2(){}
	Child2(String name){
		super.name= name;
	}
	
	void setName(String name) {
		super.name = name;
	}
	
	void m() {
		System.out.println(name);	
		System.out.println(this.name);
		System.out.println(super.name);	
	}
}