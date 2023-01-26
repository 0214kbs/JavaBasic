package lec0126.collections.list;

import java.util.ArrayList;
import java.util.Collections;

public class itemSortTest {
	public static void main(String[] args) {
		ArrayList<Item> al  = new ArrayList<>();
		al.add(new Item(2,"item2"));
		al.add(new Item(1,"item1"));
		al.add(new Item(3,"item3"));
		System.out.println(al);
		Collections.sort(al);
		
		System.out.println(al);
		System.out.println("----");
		
		ArrayList<Node> al2  = new ArrayList<>();
		al2.add(new Node(2,7,4));
		al2.add(new Node(6,4,8));
		al2.add(new Node(1,9,6));
		al2.add(new Node(5,8,2));
		al2.add(new Node(5,2,1));
		al2.add(new Node(5,6,9));
		System.out.println(al2);
		Collections.sort(al2);
		System.out.println(al2);
		System.out.println("--lambda--");
		Collections.sort(al2, (n1,n2)->n1.x-n2.x); 
		System.out.println(al2);
	}
	static class Item implements Comparable<Item>{
		int itemId;
		String itemNm;
		
		Item(int itemId, String itemNm){
			this.itemId = itemId;
			this.itemNm = itemNm;
		}

		@Override
		public String toString() {
			return "Item [itemId=" + itemId + ", itemNm=" + itemNm + "]";
		}

		@Override
		public int compareTo(Item o) {
			return this.itemId -o.itemId; // natural ordering 
			//return -(this.itemId -o.itemId); // 역순 
		}
		
		
	}
	
	static class Node implements Comparable<Node>{
		int y;
		int x;
		int v;
		
		Node(int y,int x, int v){
			this.y = y;
			this.x = x;
			this.v = v;
			
		}
		
		@Override
		public int compareTo(Node o) {
//			return this.y == o.y? this.x-o.x : this.y-o.y; // y가 같으면 x로 이어서 비교하는 형태 
			return this.y-o.y;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", v=" + v + "]";
		}
		
		
	}
}
