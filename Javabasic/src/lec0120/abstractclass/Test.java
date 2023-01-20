package lec0120.abstractclass;

public class Test {
	public static void main(String[] args) {
		MouseListener ml = new MouseHandler();
		ml.click();
		ml.m();
		
		MouseListener ml2 = new MouseHandler2(); 
		ml2.click();
		
		MouseListener ml3 = new MouseHandler3();
		ml3.click();
	}
}
