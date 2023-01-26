package lec0126.collections.list;

import java.util.ArrayList;
import java.util.Iterator;

public class itemListTest {
	public static void main(String[] args) {
		ArrayList<Item> al  = new ArrayList<>();
		al.add(new Item(1,"item1"));
		al.add(new Item(2,"item2"));
		al.add(new Item(3,"item3"));
		System.out.println("---");
		
		// for
		for(int i=0;i<al.size();i++) {
			Item item = al.get(i);
			System.out.println(item);
		}
		
		System.out.println("---");
		// foreach
		for (Item item : al) {
			System.out.println(item);
		}
		
		System.out.println("---");
		// Iterator 
		Iterator<Item> itr = al.iterator();
		while(itr.hasNext()) {
//			Item item = itr.next();
//			System.out.println(item);
			System.out.println(itr.next());
		}
		
		System.out.println("---");
		// forEach
		al.forEach(item -> System.out.println(item));
	}
	
	static class Item{
		int itemId;
		String itemNm;
		
		Item(int itemId, String itemNm){
			this.itemId = itemId;
			this.itemNm = itemNm;
		}
	}
}
