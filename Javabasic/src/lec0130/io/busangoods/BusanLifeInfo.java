package lec0130.io.busangoods;


import java.util.Date;

public class BusanLifeInfo {
	public String kind; // pumNm
	public String productName; // itemName
	public double price; // unitprice / unit
	
	public BusanLifeInfo() { super(); }
	public BusanLifeInfo(String kind, String productName, double price, String storeName, Date examineDate) {
		super();
		this.kind = kind;
		this.productName = productName;
		this.price = price;
		this.storeName = storeName;
		this.examineDate = examineDate;
	}

	public String storeName; // bsshNm
	public Date examineDate; // examinDe
	
	public String getKind() { return kind; }
	public String getProductName() { return productName; }
	public double getPrice() { return price; }
	public String getStoreName() { return storeName; }
	public Date getexamineDate() { return examineDate; }
	
	public void setKind(String kind) { this.kind = kind; }
	public void setProductName(String productName) { this.productName = productName; }
	public void setPrice(double price) { this.price = price; }
	public void setStoreName(String storeName) { this.storeName = storeName; }
	public void setexamineDate(Date examineDt) { this.examineDate = examineDt; }
	
	@Override
	public String toString() {
		return "Good [kind=" + kind + ", productName=" + productName + ", price=" + price + ", storeName=" + storeName
				+ ", examineDt=" + examineDate + "]";
	}
}
