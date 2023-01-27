package training.book;

public class QuantityException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuantityException(String exCode, String message) {
		super(message);
		this.exCode = exCode;
		
	}

	public QuantityException(String message) {
		super(message);
		
	}
	String exCode; // ERR_01 : 해당 도서의 ISBN이 존재하지 않는다. 
	
}
