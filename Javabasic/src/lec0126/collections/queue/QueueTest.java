package lec0126.collections.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
//		Queue<Node> q = new ArrayDeque<>();
		
		/*
		q.offer(new Node(7,7));
		q.offer(new Node(2,4));
		q.offer(new Node(6,1));
		q.offer(new Node(4,8));
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			// bfs 흉내 n으로 부터 갈 수 있는 다른 Node가 있으면 q.offer() ..... 
			System.out.println(n);
		}
		System.out.println("end");
		*/ 
		// 담기는 순서에 따라 꺼내는 것이 아니라 제공하는 우선 순위 기준으로 꺼낸다. 
//		PriorityQueue<Node> pq = new PriorityQueue<>(); 
		PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2) -> n1.x -n2.x); 
		pq.offer(new Node(7,7));
		pq.offer(new Node(2,4));
		pq.offer(new Node(6,1));
		pq.offer(new Node(4,8));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			System.out.println(n);
		}
	}
	/*
	static class Node implements Comparable<Node>{ // new PriorityQueue<>(); 
		int y;
		int x;
		
		Node(int y,int x){
			this.y = y;
			this.x = x;
			
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x +  "]";
		}
		
		@Override
		public int compareTo(Node o) {
//
			return this.y-o.y;
		}
	}
	*/
	static class Node{
		int y;
		int x;
		
		Node(int y,int x){
			this.y = y;
			this.x = x;
			
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}
		
		
	}
}
