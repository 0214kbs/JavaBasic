package lec0120.abstractclass;

public class C implements IA,IB{

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m3() {
		// TODO Auto-generated method stub
		
	}
	
	//e.m.1 : Duplicate default methods named m2 with the parameters () and () are inherited from the types IB and IA
	// 		하나 선택하면 됨 
	@Override
	public void m2() {
		// TODO Auto-generated method stub
		IA.super.m2();
	}
	
	
	

}
