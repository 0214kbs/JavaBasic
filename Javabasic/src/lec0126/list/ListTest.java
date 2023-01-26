package lec0126.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    // 문자열을 저장할 List, 구현체는 ArrayList
//    List<String> friends = new ArrayList<>();
    List<String> friends = new LinkedList<>();

    public static void main(String[] args) {

        ListTest alt = new ListTest();
        alt.createTest();
        alt.retrieveTest();
        alt.updateTest();
        alt.deleteTest();
    }

    public void createTest() {
        // TODO: friends에 여러명의 친구를 등록해보자.
    	friends.add("hkd");
    	friends.add("jks");
    	friends.add("hkd"); // data 중복 
    	friends.add("ikj");
    	friends.add(0,"kbs");
    	
        // END:
        System.out.println("추가 후 내용 출력: " + friends);
        // 추가 후 내용 출력: [kbs, hkd, jks, hkd, ikj]
        // **data 중복이 될 수 있음**을 확인할 수 있음 
    }

    public void retrieveTest() {
        // TODO: 다양한 조회 기능을 사용해보자.
    	System.out.println("list size?"+friends.size());
    	
    	// 각 요소 출력 #1
//    	for(int i=0;i<friends.size();i++) {
//    		System.out.println(friends.get(i));
//    	}
    	// 각 요소 출력 #1
//    	for(String friend: friends) System.out.println(friend);
    	System.out.println(friends.contains("bsk")); //false 출력
    	System.out.println(friends.indexOf("jks")); //2
    	System.out.println(friends.indexOf("bsk")); // 없으면 -1 반환
    	System.out.println(friends.isEmpty()); // false
    	
    }

    public void updateTest() {
        // TODO: 홍길동이 있다면 값을 율도국 왕으로 변경해보자.
    	System.out.println("수정전 : "+friends);
    	int idx = friends.indexOf("hkd");
    	if(idx>=0) {
    		friends.set(idx,"udkw");
    	}
    	System.out.println("수정후 : "+friends);
    	//수정후 : [kbs, udkw, jks, hkd, ikj]
    }

    public void deleteTest() {
        // TODO: 0번째 친구와 율도국 왕을 삭제하시오.
        // END:
    	friends.remove(0);
    	friends.remove("udkw");
        System.out.println("삭제 후 : " + friends);
        // 삭제 후 : [jks, hkd, ikj]
        friends.clear();// 리스트 초기화
        System.out.println("초기화 후 : " + friends);
        // 초기화 후 : []
        
        
        // 참고 
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        
        l.remove(1); // index 1에 해당하는 위치 제거됨 ->2
        System.out.println(l);
        // 1을 지우려면?
        l.remove(Integer.valueOf(1));
        System.out.println(l);
    }
}
