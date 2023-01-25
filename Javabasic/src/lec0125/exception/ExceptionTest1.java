package lec0125.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// exception
// RuntimeException - Non-RuntimeException
// UncheckedException - CheckedException


// CheckedException <- Compiler가 check <= JAVA 문법사항(Exception)을 따르는지 확인
public class ExceptionTest1 {
	
	
	public static void main(String[] args) { //#2 throws FileNotFoundException // #3 throws IOException

		
	//file로부터 내용을 읽고싶은...
//		FileInputStream fis = new FileInputStream("hello.txt");
		
		
		/* #1 try-catch-finally
		 * 이 코드에서 해당 예외를 직접 핸들링하겠다라는 의미
		FileInputStream fis =null;
		try {
			fis = new FileInputStream("hello.txt");
			// file, network port, Connection 을 통한 정상적인 작업을 수행 
			
		}catch(FileNotFoundException e) {
			// 예외 발생시 JVM이 이곳의 코드를 실행함
			// 파라미터로 예외 객체 e를 전달함
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			//예외가 발생하던 안하던 마지막으로 수행 <= JVM이 보장
			System.out.println("Finally");
			//열어놓은 자원을 닫거나 얻은 자원을 반납
			// file <- 닫는 작업
			// network port <- 닫는 작업
			// Connection 객체 <- 반납 작업 ......
			if(fis!=null) {
				try {
					fis.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		*/
		
		/* #2
		 * 이 코드(main)에서 해당 예외를 직접 핸들링 하지 않겠다라는 의미
		 * 나를 호출한 부모 코드(위)에게 그 부담을 던짐
		 *  - 나(main) 부모 (JVM)
		 * 
		 */
//		FileInputStream fis = new FileInputStream("hello.txt");
		
		/* #3 throw
		 * 내가 핸들링하긴 하지만, 예외가 발생하면 그 예외를 처리하고 그 안에서 새로운 예외를 발생시킨다. 
		 * throw A 예외 => 기존 발생 예외와는 별개로 새로운 A예외가 발생되어서 부모에게 전달
		 * 부모는 A 예외에 대한 핸들링 부담을 가지게 됨 
		
		FileInputStream fis =null;
		try {
			fis = new FileInputStream("hello.txt");			
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			throw new IOException(); 
		}finally {
			System.out.println("Finally");
			if(fis!=null) {
				try {
					fis.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			
		} 
		*/
		
		
		/* #4 AutoCloseable
		 * 단순하게 자원 반납을 위해서 필요한 많은 close() 코드를 Compiler가 대신 자동으로 코드를 삽입 처리하는 방식
		 * 어떤 클래스의 객체가 AutoClosable 인터페이스를 implements한 것이라면, 아래처럼 사용 가능
		 */
		try(FileInputStream fis = new FileInputStream("hello.txt");){
			//fis 코드
		}catch(IOException  e) { 
			e.printStackTrace();
		}// finally (close하는 목적으로는 굳이 쓰지 않음) 
	}
}
