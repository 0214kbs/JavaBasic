package lec0120.equalshashcode;

import java.util.Objects;

public class Item {
	
	public static void main(String[] args) {	
		// null instanceof Item 의 결과 -> false 검증 
		if(null instanceof Item)	System.out.println("Null!");
	}
	private int itemId;
	private String itemNm;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemNm() {
		return itemNm;
	}
	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
	}
	
	public Item() {}
	public Item(int itemId, String itemNm) {
		this.itemId = itemId;
		this.itemNm = itemNm;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemNm=" + itemNm + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		// null check & same type check
		// o에 대한 null 비교를 instanceof가 함께 처리 
		if(o!=null && o instanceof Item) {
			Item item = (Item)o;
			if(this.itemId == item.itemId && this.itemNm.equals(item.itemNm)) {
				return true;
			}
			return false;
		}
		
		return false;
	}

	// Collections <- 객체를 담을 수 있는 배열을 대체하는 다양한 High-level 자료구조
	// 등록, 삭제 등등의 과정에서 담겨진 두 객체를 비교하는 로직을 많이 사용
	// Collections에 있는 다양한 메소드들은 내부적인 처리(동일성 여부)를 위해서 equals()외에- hashcode()를 추가로 사용하는 경우가 많다. 
	// 	=> 매번 사용하는 Collections 자료구조를 확인하고 처리 ... => 항상 hashcode()도 overriding 해라

	// 전통적인 java 1.7 이전
//	@Override
//	public int hashCode() {
//		int res = 17;
//		res = res*31*this.itemId;
//		res = res*31*this.itemNm.hashCode();
//		return res;
//	}
	
	// java 1.7 부터
	@Override
	public int hashCode() {
		return Objects.hash(itemId,itemNm);
	}
}
