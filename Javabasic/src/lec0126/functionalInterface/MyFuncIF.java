package lec0126.functionalInterface;

@FunctionalInterface
public interface MyFuncIF {
	int proc1(int n1, int n2); // public, abstract
	
	// default method는 가질 수 있다. 
//	default int proc2(int n1, int n2) {
//		return n1+n2;
//	}
	
}
