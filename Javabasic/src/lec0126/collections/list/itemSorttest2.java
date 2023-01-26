package lec0126.collections.list;

import java.util.ArrayList;
import java.util.Collections;


public class itemSorttest2 {
	public static void main(String[] args) {
		ArrayList<Node> al2  = new ArrayList<>();
		al2.add(new Node(2,7,4));
		al2.add(new Node(6,4,8));
		al2.add(new Node(1,9,6));
		al2.add(new Node(5,8,2));
		al2.add(new Node(5,2,1));
		al2.add(new Node(5,6,9));
		System.out.println(al2);
//		<Node> void java.util.Collections.sort(List<Node> list, Comparator<? super Node> c) 
//																-> lambda 이용
		Collections.sort(al2, (n1,n2)-> n1.y==n2.y ? n1.x-n2.x : n1.y-n2.y); 
		System.out.println(al2);
	}
	static class Node{
		int y;
		int x;
		int v;
		
		Node(int y,int x, int v){
			this.y = y;
			this.x = x;
			this.v = v;
			
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", v=" + v + "]";
		}
		
		
	}
}
