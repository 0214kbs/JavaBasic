package lec0117.classobject;

public class MyClass {
	//멤버 변수
	int n;
	String str;
	
	//메소드 - 독립적으로 기능을 수행
	void m1() {
		System.out.println("m1()");
	}

	
	/*Getters & Setters
	 *  - encapsulation 
	 *  - 외부와 소통
	 */
	// getters
	public int getN() {
		return n;
	}
	
	//setters
	public void setN(int n) {
		this.n = n;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
}
