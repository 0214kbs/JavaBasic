package lec0126.functionalInterface;
// lambda사용시 없어도 되는 class
public class MyFuncIFImpl implements MyFuncIF{
	@Override
	public int proc1(int n1, int n2) {
		return n1+n2;
	}
}
