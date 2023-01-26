package lec0126.functionalInterface;

public class Test {
	public static void main(String[] args) {
		UseMyFuncIF func = new UseMyFuncIF();
		func.m1(10, 20, new MyFuncIFImpl());
		
		// lambda로 표현하는 방식 
		func.m1(10, 20, (n1,n2)->n1+n2);
		func.m1(10, 20, (n1,n2)->n1*n2);
	}
}
