package com.ssafy.ws.step3;

import java.util.Arrays;
import java.util.Iterator;

public class BookManager {
	private static int MAX_SIZE = 100; // 관리할 최대 도서 수
	// private -> BookManager안에서만 접근 가능
	
	//클래스 다이어그램- books:Book[] 
	private Book[] books = new Book[MAX_SIZE]; // 도서 목록 배열
	private int size;
	
	public void add(Book book) {
		// 전달되는 book 객체를 배열에 담는다. 
		// 앞에서부터 순차적으로 담는다. 
		// MAX_SIZE 범위 내에서만 담는다. 만약. Full이면? 아무일도 안한다. 
		// size 변수를 고려 
		if (size <MAX_SIZE)  books[size++] = book;

	}
	
	// b1-b2-b3-b4-b5-
	public void remove(String isbn) {
		// 2가지 방법
		// 1. 뒤로부터 앞으로 빈칸을 모두 채워나가는 방식(순서 고려)
		// 2. 현재 삭제된 빈칸에 마지막 도서객체를 이동하는 방식 (순서 고려X) 
		
		//2번 방식
		// size 고려
		for (int i = 0; i < size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				books[i] = books[size-1];
				books[size-1] = null;
				size--;
				break;
			}
		}
	}
	
	//클래스 다이어그램- getList(): Book[]
	public Book[] getList(){
		// books를 통째로 return하지 않는다. 
		// 대신 새로운 Books 객체의 배열을 return 한다. 
		// 1. System.arraycopy() -> 옛날 방식
		// 2. Arrays.copyOfRange()
		
		return Arrays.copyOfRange(books,0,size);
	}
	
	//클래스 다이어그램- searchByIsbn(isbn: String): Book
	public Book searchByIsbn(String isbn) {
		
		// books 배열 순회하면서 isbn이 같은 Book 객체가 있으면 그걸 return, 없으면 null return 
		for(int i = 0 ;i<size;i++) {
			String Isbn_i = books[i].getIsbn();
			if(Isbn_i.equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}
}
