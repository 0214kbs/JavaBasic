package lec0117.classobject.finall;
// final 한번 객체를 가리키고 나면, 다른 걸 가리킬 수 없음 
	//class - final : 상속 X 
	//method - final : 재정의 X 
	// variable - final : 한번 설정된 값을 변경할 수 없음
public class MyClass {
	void m1() {
		final int n = 10;
		//n = 20; // error : The final local variable n cannot be assigned. It must be blank and not using a compound assignment
		final int n2;
		n2 = 10;
		//n2 = 20; //error
		
		final MySub2 ms2 = new MySub2();
		//ms2 = new MySub2(); //error 
		ms2.i = 8; // 이런건 됨 (객체가 가리키고 있는 "변수"가 final인거지 객체 안의 값이 변하면 안되는 것이 아님!!!!!!!!!) 
	}
	final void m2() {}
}


class MySub2{
	int i;  
	String s;
}

class MySub extends MyClass{
	@Override
	void m1() {}
	
	// final이기 때문에 재정의 되지 않음
	// void m2() {} // error : Cannot override the final method from MyClass 
}

// class final
final class FinalClass{
	//상속이 안됨 : extends FinalClass 안됨
	
	
}