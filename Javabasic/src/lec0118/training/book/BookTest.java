package lec0118.training.book;
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
		bm.add(new Magazine("4444","JAVA v3","CBS","부울경4",50000,"JAVA 기본 학습4",2023,1));
		
		System.out.println("====================== 도서 목록 ======================");
		for(Book book : bm.getList()) {
			System.out.println(book);
		}
//		System.out.println(Arrays.toString(bm.getList()));
		
		System.out.println("====================== 일반 도서 ======================");
		for(Book book : bm.getBooks()) {
			System.out.println(book);
		}
		
		System.out.println("====================== 잡지 ======================");
		for(Magazine magazine : bm.getMagazines()) {
			System.out.println(magazine);
		}
		
		System.out.println("====================== 총합, 평균 ======================");
		System.out.println(bm.getTotalPrice());
		System.out.println(bm.getPriceAvg());
	}

}
