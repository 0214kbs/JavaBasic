package lec0125.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// 상속관계의 예외처리
public class ExceptionTest4 {
	
	public static void main(String[] args) {
		FileInputStream fis = null;
		
		/* 
		 * 상위-> 하위인 경우 error
		try {
			 fis = new FileInputStream("hello.txt");
			 // 다른 코드들... 
		}catch(Exception e) {
			System.out.println("Exception");
		}catch(IOException e) {
			// Unreachable catch block
			System.out.println("IOException");
		}catch(FileNotFoundException e) {
			//Unreachable catch block 
			System.out.println("FileNotFoundException");
		}
		*/
		try {
			 fis = new FileInputStream("hello.txt");
			 // 다른 코드들... 
		}catch(FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		}catch(NullPointerException | IOException e)  {
			System.out.println("IOException");
		}catch(Exception e) {
			System.out.println("Exception");
		}
	}
}
