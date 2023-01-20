package training.book;

public interface IbookManager {
	public void add(Book book);
	public void remove(String isbn);
	Book[] getList();
	Book searchByIsbn(String isbn);
	Book[] searchByTitle(String title);
	Magazine[] getMagazines();
	Book[] getBooks();
	
	int getTotalPrice();
	double getPriceAvg();
	
}
