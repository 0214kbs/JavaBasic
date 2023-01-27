package training.book;

import java.util.Arrays;
import java.util.Iterator;

import lec0125.exception.custom.EmpDto;
import lec0125.exception.custom.EmpException;
import lec0127.io.serialization.MyClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookManagerimpl implements IbookManager {
	private static int MAX_SIZE = 100; // 관리할 최대 도서 수
	// private -> BookManager안에서만 접근 가능
	
	
	//클래스 다이어그램- books:Book[] 
//	private Book[] books = new Book[MAX_SIZE]; // 도서 목록 배열
	private static ArrayList<Book> books = new ArrayList<>(); // 도서 목록 배열
	
	private int size;
	
	
	// singleton design pattern -> private
	private BookManagerimpl() {}
	private static IbookManager instance = new BookManagerimpl();
	public static IbookManager getInstance() {
		((BookManagerimpl)instance).loadData();
		return instance;
	}
	
	
	@Override
	public void add(Book book) {
		// 전달되는 book 객체를 배열에 담는다. 
		// 앞에서부터 순차적으로 담는다. 
		// MAX_SIZE 범위 내에서만 담는다. 만약. Full이면? 아무일도 안한다. 
		// size 변수를 고려 
		if (books.size() <MAX_SIZE)  books.add(book); //books[size++] = book;
		
	}
	
	@Override
	// b1-b2-b3-b4-b5-
	public void remove(String isbn) {
		// 2가지 방법
		// 1. 뒤로부터 앞으로 빈칸을 모두 채워나가는 방식(순서 고려)
		// 2. 현재 삭제된 빈칸에 마지막 도서객체를 이동하는 방식 (순서 고려X) 
		
		//2번 방식
		// size 고려
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
//				books[i] = books[size-1];
//				books[size-1] = null;
//				size--;
				books.remove(i);
				break;
			}
		}
	}
	
	@Override
	//클래스 다이어그램- getList(): Book[]
	public Book[] getList(){
		// books를 통째로 return하지 않는다. 
		// 대신 새로운 Books 객체의 배열을 return 한다. 
		// 1. System.arraycopy() -> 옛날 방식
		// 2. Arrays.copyOfRange()
		
		
//		return Arrays.copyOfRange(books,0,size);
		Book[] res = new Book[books.size()];
		return this.books.toArray(res);
	}
	
	@Override
	//클래스 다이어그램- searchByIsbn(isbn: String): Book
	public Book searchByIsbn(String isbn) {
		// books 배열 순회하면서 isbn이 같은 Book 객체가 있으면 그걸 return, 없으면 null return 
		for(int i = 0 ;i<books.size();i++) {
			String Isbn_i = books.get(i).getIsbn();
//			System.out.println(Isbn_i);
			if(Isbn_i.equals(isbn)) {
				return books.get(i);
			}
		}
		return null;
	}
	
	@Override
	public Book[] searchByTitle(String title) {
		// 전체 중에 title을 포함한 항목의 수를 계산 => 배열 생성
		// 해당 항목을 배열에 다시 담고 리턴
		int count = 0;
		for(int i = 0;i<books.size();i++) {
			if(books.get(i).getTitle().contains(title)) count ++;
		}
		
		Book[] titles = new Book[count];
		
		int idx = 0;
		for(int i = 0;i<books.size();i++) {
			if(books.get(i).getTitle().contains(title)) {
				titles[idx++] = books.get(i);
			}
			
		}		

		return titles;
	}
	
	@Override
	public Magazine[] getMagazines() {
		
		// 전체 중에 Magazine의  수를 계산 => size를 통해 배열 생성
		int count = 0;
		for(int i = 0;i<books.size();i++) {
			if(books.get(i) instanceof Magazine) count ++;
		}
		
		Magazine[] mg = new Magazine[count];
		// 전체 중에  Magazine인 경우만 새로운 배열에 담아서 return <- instanceof 활용해서 작업할 것 

		int idx = 0;
		for(int i = 0;i<books.size();i++) {
			if(books.get(i) instanceof Magazine) {
				mg[idx++] = (Magazine)books.get(i);
			}
		}		

		return mg;
	}
	
	@Override
	public Book[] getBooks() {
		
		// 전체 중에 Book의  수를 계산 => size를 통해 배열 생성
		int count = 0;
		for(int i = 0;i<books.size();i++) {
			if(!(books.get(i) instanceof Magazine)) count ++;
		}
		
		Book[] b = new Book[count];
		// 전체 중에  Book인 경우만 새로운 배열에 담아서 return <- instanceof 활용해서 작업할 것 
		int idx = 0;
		for(int i = 0;i<books.size();i++) {
			if(!(books.get(i) instanceof Magazine)) {
				b[idx++] = books.get(i);
			}
		}	
		return b;
	}
	@Override
	public int getTotalPrice() {
		//전체 순회하면서 price 합 계산, 리턴
		int total = 0;
		for (int i = 0; i < books.size(); i++) {
			total+= books.get(i).getPrice();
		}
		return total;
	}
	@Override
	public double getPriceAvg() {
		// getTotalPrice()를 활용
		// return 이 double이므로 형변환 해서 return 
		
		return (double)getTotalPrice()/books.size();
	}
	
	/*
		public int addEmpVocation(EmpDto dto, int days) throws EmpException{
			// DB에 최종적인 데이터 등록 처리
			// DB 저장에 위배되는 데이터 검증 <= 사번(empNo는 emp 문자열로 시작해야함)
			if(!(dto.getEmpNo().indexOf("emp")==0)){
				throw new EmpException("ERR_03","사원의 사번이 올바르지 않음");
			}
			
			System.out.println("사원"+dto.getEmpNo()+"의 휴가를 등록함");
			return 1;
		}
	*/


	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		
		if(searchByIsbn(isbn)==null) throw new ISBNNotFoundException("ERR_01 해당 ISBN이 존재하지 않음");
		else 
			searchByIsbn(isbn).setQuantity(searchByIsbn(isbn).getQuantity()+quantity);


		
	}
	@Override
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException {
		
		if(searchByIsbn(isbn)==null) throw new ISBNNotFoundException("ERR_01 해당 ISBN이 존재하지 않음");
		else {
			if(searchByIsbn(isbn).getQuantity()>=quantity) searchByIsbn(isbn).setQuantity(searchByIsbn(isbn).getQuantity()-quantity);
			else throw new QuantityException("ERR_02 재고가 없음 ");
		}

	}
	
	
	public void saveData() {

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.dat"))){
			oos.writeObject(books);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void loadData() {

		File file = new File("book.dat"); // File(directory 이름, "파일이름");
		if(!file.exists()) System.out.println("없음");
		else {
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.dat"))){
				books = (ArrayList)ois.readObject();
				books.forEach(System.out::println);
			}catch(IOException|ClassNotFoundException e) {
				e.printStackTrace();
			}
		}


	}
}
