package lec0119.design.methodchain;

public class Test {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.setFirst(3);
		c.setSecond(7);
		c.showAdd();
		c.showSub();
	}

}
