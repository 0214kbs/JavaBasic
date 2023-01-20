package generic;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ObjectContainer oc = new ObjectContainer();
		
		// Object type의 여러 하위 클래스의 객체를 받을 수 있으나, 
		// 꺼낼 때 ** 형변환 **  필요
		oc.setElement("hello");		
		String str = (String) oc.getElement();
		
		oc.setElement(new Integer(10));
		Integer n = (Integer) oc.getElement();
		
		// 
		GenericContainer<String> gc = new GenericContainer<>();
		gc.setElement("hello");
		String str2 = gc.getElement();
		System.out.println(str2);
		
		GenericContainer<Integer> gc2 = new GenericContainer<>();
		gc2.setElement(190); // auto boxing
		System.out.println(gc2.getElement());
	
		// 옛날 방식
		ArrayList old = new ArrayList();
		old.add(new Integer(10)); 
		
		// since 1.5
		ArrayList<String> generic = new ArrayList<>();
		generic.add("Hello");
		
		
	}
}
