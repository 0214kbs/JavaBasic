package lec0119.design.methodchain;

public class Calculator {
	private int first;
	private int second;
	public Calculator setFirst(int first) {
		this.first = first;
		return this;
	}
	public Calculator setSecond(int second) {
		this.second = second;
		return this;
	}
	
	public Calculator showAdd() {
		System.out.println("Add "+this.first+ " and "+this.second+" = " +(this.first+this.second));
		return this;
	}
	public Calculator showSub() {
		System.out.println("Sub "+this.first+ " and "+this.second+" = " +(this.first-this.second));
		return this;
	}
}
