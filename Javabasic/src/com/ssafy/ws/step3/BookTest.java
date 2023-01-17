package com.ssafy.ws.step3;

public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Book("1111","JAVA","KBS","SSAFY",50000,"JAVA 기본 학습");
		Book b2 = new Book("2222","JAVA v2","SBS","부울경",50000,"JAVA 기본 학습2");
		
		System.out.println();
		System.out.println(b1);
		System.out.println(b2.toString());
	}

}
