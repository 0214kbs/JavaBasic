package training.book;

//workshop 7 interface 및 singleton pattern 적용
public class BookTest2 {

	public static void main(String[] args) throws ISBNNotFoundException, QuantityException {
		Book b1 = new Book("1111","JAVA","KBS","SSAFY",50000,"JAVA 기본 학습",10);
		Book b2 = new Book("2222","JAVA v2","SBS","부울경2",50000,"JAVA 기본 학습2",10);
		Book b3 = new Book("3333","JAVA v3","HBS","부울경3",50000,"JAVA 기본 학습3",10);
		
		IbookManager bm = BookManagerimpl.getInstance();
		bm.add(b1);
		bm.add(b2);
		bm.add(b3);
		bm.add(new Magazine("4444","JAVA v3","CBS","부울경4",50000,"JAVA 기본 학습4",2023,1,10));
//		System.out.println("=======구매==========");
		bm.buy("2222", 10);
		
		bm.saveData();
		
		System.out.println("====================== 도서 목록 ======================");
		for(Book book : bm.getList()) {
			System.out.println(book);
		}
		
//		
//		System.out.println("====================== 일반 도서 ======================");
//		for(Book book : bm.getBooks()) {
//			System.out.println(book);
//		}
//		
//		System.out.println("====================== 잡지 ======================");
//		for(Magazine magazine : bm.getMagazines()) {
//			System.out.println(magazine);
//		}
//		
//		System.out.println("====================== 총합, 평균 ======================");
//		System.out.println(bm.getTotalPrice());
//		System.out.println(bm.getPriceAvg());
	
		
//
//		System.out.println("=======판매==========");
//		bm.sell("2222", 20);
//		

//		
		//error 확인
//		System.out.println("=======판매==========");
//		bm.sell("2222", 20);
		
	}

}
