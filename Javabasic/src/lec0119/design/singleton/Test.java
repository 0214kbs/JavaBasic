package lec0119.design.singleton;

public class Test {
	public static void main(String[] args) {
//		Logger logger = new Logger(); // new Logger()(생성자)가 public이기 때문에 error
		Logger logger = Logger.getInstance();
		logger.log("Hello");
		
		Logger logger2 = Logger.getInstance();
		logger2.log("Hello");
	}
}
