package lec0120.abstractclass;

// interface를 implement한 추상클래스를 상속받아 필요한 것만 처리할 수 잇도록 함
public class MouseHandler2 extends MouseAdapter{

	@Override
	public void click() {
		System.out.println("난 click만 처리하고 싶음");
	}
	@Override
	public void about() {
		
	}
}
