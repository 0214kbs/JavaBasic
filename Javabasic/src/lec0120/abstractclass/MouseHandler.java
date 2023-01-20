package lec0120.abstractclass;

// 전체 listener에 있는 메소드를 사용하지 않음 (click()만 처리하고자 하는 클래스) 
public class MouseHandler implements MouseListener{

	@Override
	public void click() {
		System.out.println("난 click만 처리하고 싶음");
	}

	// click만 처리하고 싶다고해서 나머지 구현을 안하면 error. 
	// 즉 , 아래코드는 필요없지만, 문법 처리를 우히ㅐ 껍데기만 구현 
	@Override
	public void doubleClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void over() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void out() {
		// TODO Auto-generated method stub
		
	}
	
}
