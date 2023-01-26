package lec0126.lambda;

public class MyFuncIFImpl implements MyFuncIF{
	// 인터페이스를 구현하는 과정에서 구현 기능이 고정(덧셈)
	@Override
	public int proc1(int n1, int n2) {
		return n1+n2;
	}
}
