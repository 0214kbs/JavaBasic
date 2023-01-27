package lec0127.io.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {
	public static void main(String[] args) {
		// MyClass 객체를 생성한 뒤에 객체를 파일로 저장(직렬화)
		// 반대로 파일로부터 MyClass 객체를 복원(역직렬화)
		
		// 직렬화
		/*
		MyClass mc = new MyClass();
		mc.n = 10;
		mc.ssn = 999;
		mc.str = "Hello";
		writeObject(mc);
		*/
		
		// 역직렬화	
//		/*
		MyClass mc = readObject();
		System.out.println(mc.n);
		System.out.println(mc.ssn);
		System.out.println(mc.str);
//		*/
	}
	
	// 직렬화 메소드
	static void writeObject(MyClass mc) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MyClass.dat"))){
			oos.writeObject(mc);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// 역직렬화 메소드 
	static MyClass readObject() {
		MyClass mc = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("MyClass.dat"))){
			mc = (MyClass) ois.readObject();
			return mc;
		}catch(IOException |ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return mc;
	}
}
