package lec0127.io.serialization;

import java.io.Serializable;

// 객체 직렬화를 통해서 해당 클래스의 객체를 파일로 저장하거나 복원하려면 Serializable를 구현
// serialVersionUID를 클래스가 직접 관리하지 않으면 JVM이 직접 관리
// 			-> class의 구성을 보고 임의의 랜덤 uid를 이용, 직렬화 이후 class의 구성이 변경되면 uid 호환 X
// serialVersionUID를 클래스가 직접관리하면 
// 			-> JVM은 역직렬화 과정에서 serialVersionUID가 직렬화 시점의 값과 같으면 역직렬화를 진행 

public class MyClass implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int n;
	transient int ssn;
	String str;

	int i;
}
