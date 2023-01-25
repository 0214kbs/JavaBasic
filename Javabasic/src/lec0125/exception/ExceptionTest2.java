package lec0125.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// Call-Stack에 따른 예외 처리 
public class ExceptionTest2 {
	
	public static void main(String[] args) throws IOException  {
		System.out.println("main");
		Controller controller = new Controller();
		controller.m();
	}
}

class Controller{
	public void m() throws IOException {
		System.out.println("Controller-m()");
		Service service = new Service();
		service.m();
	}	
}
class Service{
	public void m() throws IOException {
		System.out.println("Service-m()");
		Dao dao = new Dao();
		/* 
		 try{
			dao.m();
		 }catch(IOException e) {
			e.printStackTrace();
		 }
		 */
		// Controller에서 처리해야 한다.
		dao.m();
	}
}
class Dao{
	public void m() throws IOException {
		System.out.println("Dao()");
		}
	
	
}