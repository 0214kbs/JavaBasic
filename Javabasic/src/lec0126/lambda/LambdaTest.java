package lec0126.lambda;

public class LambdaTest {
	public static void main(String[] args) {
		
		// void no parameter 
		// => 빈 괄호 -> {} 
		// => return X 
		{
			UseFuncIF.exec1(()->{
				System.out.println("Hello lambda!");
				//return 1;
			});
		}
		
		// int return no param 
		{	
			UseFuncIF.exec2(()-> { 
				System.out.println("exec2");
				return 10; 
			});
			
			
			UseFuncIF.exec2(()-> 10); // 10 return 
			
			UseFuncIF.exec2( () ->{
				int n1 = 4;
				int n2 = 6;
				//...
				return n1+n2;
			});
			
			UseFuncIF.exec2(()-> sm1());
		}
		
		// String return int param 1개
		{
			UseFuncIF.exec3((n)-> {return "Hi";});
			UseFuncIF.exec3((n)-> "Hi"); // return 생략 가능 -> {;} 제거하고 return 값만 
			UseFuncIF.exec3(n-> "Hi"); // parameter 1개이므로 () 생략 가능
			UseFuncIF.exec3(n->{
				if(n%2==0) return "짝수";
				else return "홀수";
			}); 
			
			UseFuncIF.exec3(n->sm3(n));
		}
		
		
		// int return int param 2개
		{
			UseFuncIF.exec4((n1,n2) -> n1+n2);
			UseFuncIF.exec4((n1,n2) -> Math.min(n1, n2));
			UseFuncIF.exec4(24,20,(n1,n2) -> Math.min(n1, n2));
		}
		
		// reference type, return Myclass, MyClass param 2개 
		{
			// 전달되는 두 객체 중에 y좌표가 더 큰 객체를 리턴
			UseFuncIF.exec5(new MyClass(7,2), new MyClass(3,9), (mc1,mc2)  -> {
					if(mc1.y>mc2.y) return mc1;
					else return mc2;
				});
			// same
			UseFuncIF.exec5(new MyClass(7,2), new MyClass(3,9), (mc1,mc2)  -> mc1.y>mc2.y?mc1:mc2 );
			
			// 전달되는 두 객체 중에 y 좌표 + x좌표 의 합이 더 큰 객체 리턴
			UseFuncIF.exec5(new MyClass(7,2), new MyClass(3,9), (mc1,mc2)-> (mc1.y+mc1.x)>(mc2.y+mc2.x)?mc1:mc2);		}
	}
	// void, no parameter
	static interface FuncIF1{
	    void m();
	}

	// int return, no parameter
	static interface FuncIF2{
	    int m();
	}

	static interface FuncIF3{
	    String m(int n);
	}

	static interface FuncIF4{
	    int m(int n1, int n2);
	}

	static interface FuncIF5{
	    MyClass m(MyClass mc1, MyClass mc2);
	}

	static class UseFuncIF{
	    public static void exec1(FuncIF1 funcIfImpl) {
	        funcIfImpl.m();
	    }
	    
	    public static void exec2(FuncIF2 funcIfImpl) {
	        System.out.println( funcIfImpl.m() ); // return 결과를 출력
	    }
	    
	    public static void exec3(FuncIF3 funcIfImpl) {
	        System.out.println( funcIfImpl.m(5) ); // parameter 전달, return 결과를 출력
	    }
	    
	    public static void exec4(FuncIF4 funcIfImpl) {
	        System.out.println( funcIfImpl.m(5, 7) ); // parameter 전달, return 결과를 출력
	    }
	    
	    public static void exec4(int n1, int n2, FuncIF4 funcIFImpl) {
	        System.out.println( funcIFImpl.m(n1, n2) ); // 파라미터 및 리턴 결과를 출력
	    }
	    
	    public static void exec5(MyClass mc1, MyClass mc2, FuncIF5 funcIfImpl) {
	        System.out.println( funcIfImpl.m(mc1, mc2) ); // parameter 전달, return 결과를 출력
	    }
	}

	static int sm1() { return 1; }
	static String sm2() { return "Hello"; }
	static String sm3(int i) { return "Hello" + i; }

	static class MyClass{
	    int y;
	    int x;
	    
	    public MyClass(int y, int x) {
	        this.y = y;
	        this.x = x;
	    }

	    @Override
	    public String toString() {
	        return "MyClass [y=" + y + ", x=" + x + "]";
	    }
	    
	    
	}
}
