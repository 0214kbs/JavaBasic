package lec0126.lambda;

public class Test {
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = 20;
		
		// normal
		/*
		{
			MyFuncIF func = new MyFuncIFImpl();
			int res = func.proc1(n1, n2);
			System.out.println(res);
		}
		*/
		
		
		// anonymous inner class
		// functional interface 외에서도 사용 가능
		/*
		{
			MyFuncIF func = new MyFuncIF(){

				@Override
				public int proc1(int n1, int n2) {
					return n1-n2;
				}
				
			};
			
			int res = func.proc1(n1, n2);
			System.out.println(res);
		}
		*/
		
		
		// functional interface with lambda
		/*
		{
			MyFuncIF func = (i,j) -> i+j; //MyFuncIF 메서드 하나
			int result = func.proc1(n1, n2);
			System.out.println(result);
		}
		*/
		
		
		// ** 제일 많이 쓰는 방식**
		// parameter 가 functional interface인 경우 lambda
		{
			MyFunc.m((i,j)->i+j);
			MyFunc.m((i,j)->i-j);
			MyFunc.m((i,j)->i*j);			
		}
		
	}
	
	static class MyFunc{
		static void m(MyFuncIF func) {
			// func로 할 수 있는 기능은 단 하나 
			System.out.println(func.proc1(20, 40));
		}
	}
}
