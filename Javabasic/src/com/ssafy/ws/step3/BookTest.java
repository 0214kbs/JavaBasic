package com.ssafy.ws.step3;

import java.util.Arrays;

public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Book("1111","JAVA","KBS","SSAFY",50000,"JAVA 기본 학습");
		Book b2 = new Book("2222","JAVA v2","SBS","부울경2",50000,"JAVA 기본 학습2");
		Book b3 = new Book("3333","JAVA v3","HBS","부울경3",50000,"JAVA 기본 학습3");
		
//		System.out.println(b1);
//		System.out.println(b2.toString());
		
		BookManager bm = new BookManager();
		bm.add(b1);
		bm.add(b2);
		bm.add(b3);
		
		System.out.println("====================== 도서 목록 ======================");
		for(Book book : bm.getList()) {
			System.out.println(book);
		}
//		System.out.println(Arrays.toString(bm.getList()));
		
		System.out.println("====================== 도서 조회 2222 ======================");
		Book book = bm.searchByIsbn("2222");
		System.out.println(book);
//		System.out.println(bm.searchByIsbn(b2.getIsbn()));
		
		//remove 2222
		System.out.println("====================== 도서 삭제 2222 ======================");
//		bm.remove(b2.getIsbn());
		bm.remove("2222");
		
		System.out.println("====================== 도서 목록 ======================");
		for(Book book2 : bm.getList()) {
			System.out.println(book2);
		}
//		System.out.println(Arrays.toString(bm.getList()));
		
		System.out.println("====================== 도서 조회 2222 ======================");
		Book book3 = bm.searchByIsbn("2222");
		if(book3== null) System.out.println("찾는 도서가 없습니다. ");
		else 		System.out.println(book3);
	}

}
