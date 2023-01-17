package lec0117;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//0116 과제 풀이2

public class 섬나라다리짓기2 {

	static int N, ans;
	static int[][] map;
	
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		//input
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//풀이2
		// 가로로 한줄씩 가면서 만들어질 수 있는 길이가 얼마인지 찾고
		// 세로로 // 
		
		//가로 
		for (int i = 0; i < N; i++) {
			boolean on = false;
			int len = 1;
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					if(on) {
						// 다리를 만들고 있다가 1을 만나면 종료. 최댓값 갱신, 1을 만나면 새로운 시작이기도 함
						ans = Math.max(ans,len);
						len = 1;
					}else {
						//다리는 만드는 시작
						on = true;
						len = 1;
					}
				}else {
					if(on) {
						len++;
					}
				}
			}
		}
		
		//세로
		for (int j = 0; j < N; j++) {
			boolean on = false;
			int len = 1;
			for (int i = 0; i < N; i++) {
				if(map[i][j]==1) {
					if(on) {
						ans = Math.max(ans,len);
						len = 1;
					}else {
						on = true;
						len =1;
					}
				}else {
					if(on) {
						len++;
					}
				}
			}
		}
		
		System.out.println(ans);
	}
}
