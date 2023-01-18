package lec0118.pkg.home;

//import lec0118.pkg.StaticClass;
import static lec0118.pkg.StaticClass.sm1;

import lec0118.pkg.main.Main;
import lec0118.pkg.main.sub.Sub;

public class Home {

	public static void main(String[] args) {
		//full package name + class
		
//		lec0118.pkg.main.sub.Sub sub = new lec0118.pkg.main.sub.Sub();
		Sub sub = new Sub();
		
		Main main = new Main(); //lec0118.pkg.main.Main
		
		//static method
//		StaticClass.sm1(); // lec0118.pkg 패키지의 StaticClass
		// import 에 바로 사용할 수 있음
		sm1();
		
		
	}

}
