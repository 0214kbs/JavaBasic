package lec0120.abstractclass;

//추상 클래스이면서
//MouseListener interface에 있는 추상 메소드를 구현 
public abstract class MouseAdapter implements MouseListener{
	@Override
	public void click() {
		System.out.println("웬만하면 이거 써라 ");
	}
	
	@Override
	public void doubleClick() {}
	
	@Override
	public void over() {}
	
	@Override
	public void out() {}
	
	// 추상 클래스에 있는 추상 메소드
	public abstract void about();
}
