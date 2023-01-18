package lec0118.oop.inheritance;

import lec0118.oop.inheritance.another.DefaultParent;

// Access Modifier
// private < default( keyword X. 아무것도 안 붙이면) < protected < public
// 접근 제한자 : 자바의 특정 코드에서 다른 영역에 접근할 수 있는지 여부를 결정 (클래스의 멤버들에 대한 선언으로 결정) 
	// private : 자기 자신의 클래스 안에서만 접근 가능
	// default : 자신 클래스와 같은 패키지에서만 접근 가능 (상속관계에서 불가능)-> 다른 패키지의 클래스를 상속받으면, 접근 불가  
	// protected : 같은 패키지에서도 가능. 다른/같은 패키지의 상속관계에서 가능 
	// public : 접근 제한 X (Universe)
public class Test4 {

	public static void main(String[] args) {
		Parent4 p4 = new Parent4();
		
//		p4.privateInt = 20; // error.m : The field Parent4.privateInt is not visible 
		
		p4.publicInt =30;
	}

}

class Parent4{
	
	private int privateInt = 10;
	public int publicInt = 20;
	int defaultInt = 30;	
	
	
	void m() {
		this.privateInt = 20;
	}
}

class Child4 extends Parent4{
	
	
	void m() {
		
//		super.privateInt = 10;// error.m : The field Parent4.privateInt is not visible 		
		// Quiz : Private는 자식에게 상속이 안된다 
		// Answer : No. 상속은 되지만, 접근 권한은 없음 
		
		super.defaultInt = 20; // 상속인데, 접근 가능한 이유는? 같은 패키지 이기 때문에 가능 
	}
}

class DefaultChild extends DefaultParent{	// 다른 패키지
	void m() {
//		super.defaultInt = 10; //The field DefaultParent.defaultInt is not visible
		//다른 패키지 상속 -> default는 불가. protected는 가능 
		super.protectedInt = 10; 
	}
	
}