package lec0126.collections.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class setTest {
	public static void main(String[] args) {
		Set<Node> set = new TreeSet<>();
		set.add(new Node(1,2));
		set.add(new Node(3,1));
		set.add(new Node(1,2));
		
		for (Node node : set) {
			System.out.println(node);
		}
		
		/* HashSet일 때 출력
		 * Node [y=1, x=2]
		 * Node [y=3, x=1]
		 */
	}
	
	
	/* HashSet : hashCode, equals 를 따라감 
	 * TreeSet " implements Comparable / compareTo를 따라감 
	 */
	
	/// error cannot be cast to java.lang.Comparable 이면, 
	/// 1. static class Node implements Comparable<Node>
	//  2. @Override compareTo 메소드 추가 
	static class Node implements Comparable<Node>{
		int y;
		int x;
	
		Node(int y,int x){
			this.y = y;
			this.x = x;	
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x+ "]";
		}
/*
		@Override
		public int hashCode() {
			return Objects.hash(this.y, this.x);
		}

		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Node) {
				Node n = (Node) obj;
				if(this.y == n.y && this.x == n.x) return true;
			}
			return false;
		}
	*/	
		@Override
		public int compareTo(Node o) {
			return this.y == o.y ? this.x-o.x : this.y-o.y;
		}
		
	}
}
