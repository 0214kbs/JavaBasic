package lec0117.classobject;

public class PassByValue {

	public static void main(String[] args) {
		
		int i = 10;
		setVal(i); //main이 static이기 때문에 setVal 바로 호출하려면 setVal 도 static
		System.out.println(i);
		
		Pass p  = new Pass();
		setVal(p);
		System.out.println(p.val);
	}
	
	static void setVal(int x) {
		x=5;
	}
	
	static void setVal(Pass p) {
		p.val -= 5;
	}
	static class Pass{ // PassByValueTest안에서 static 안에서만 사용ㅇ할 수 있는 class (static inner class)
		int val = 10;
	}
}
