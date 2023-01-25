package lec0125.exception;

public class SimpleException {

	public static void main(String[] args) {
		int[] intArray = {10};
		try {
			System.out.println(intArray[2]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("예외 처리 완료");
		}
		System.out.println("프로그램 종료");
	}

}
