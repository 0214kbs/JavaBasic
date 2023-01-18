package lec0118.oop.inheritance;

public class Test3 {

	public static void main(String[] args) {

		Child3 c = new Child3();
		c.m();
	}
}

class Parent3{
	String name = "Parent";
	
	void setName(String name) {
		this.name = name;
	}

	// 생성자 없으면   자동으로 (Parent3 extends Object)
//	Parent3(){
//		super(); 
//	}
	
	// 아래 코드가 없으면 위의 생성자가 자동으로 만들어지기 때문에 에러가 발생하지 않음.
	//하지만, 아래 코드가 있다면 -> 밑에 주석으로 달아 놓은 error  message 존재 
	Parent3(String name){
		this.name = name;
	}
	// 아래 코드를 넣으면 에러가 사라짐
	Parent3(){}
}

// 부모로부터 받은 멤버를 변경하는 건 자식이 직접 하는 것보다는 부모에 의해서 변경되는 데 더 합리적 -> Parent3 내 setName, Parent3 생성
// 상속 관계에서 자식클래스가 자신의 생성자 안에서 부모 클래스의 생성자를 명시적으로 호출하지 않으면,
// 		컴파일러가 자동으로 부모클래스의 기본생성자를 호출하는 코드 super() 를 넣어준다. 

// 먄약, 명시적으로 호출하는 생성자가 있다면, super()를 자동으로 넣어주지 않는다. *** 따라서, 기본 생성자를 만들어주지 않으면, 에러 발생!! 
class Child3 extends Parent3{
	
	// Child3() 에 error message
	// error message : Implicit super constructor Parent3() is undefined. Must explicitly invoke another constructor
		// cf) Implicit super constructor (= super() )
	Child3(){ } 
	Child3(String name){
		// this와 super 모두 맨 앞에 와야하지만, 둘다 동시에 사용은 불가능함 
//		System.out.println(this.name); 
		super(name);//		super.name= name;
	}
	
	void m() {
		System.out.println(name);	
		System.out.println(this.name);
		System.out.println(super.name);	
	}
}