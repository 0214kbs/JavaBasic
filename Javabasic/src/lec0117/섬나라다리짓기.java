package lec0117;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//0116 과제 풀이

public class 섬나라다리짓기 {

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
		
		//풀이
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				
				if(map[y][x]==1) {

					for (int d = 0; d < 4; d++) {
						int nx = x;
						int ny = y;
						
						int len = 1;
						while(true) {
							ny = dy[d]+ny;
							nx = dx[d]+nx;
							
							/*bug
							 * if(nx<0 || ny<0||nx>=N || ny>=N || map[ny][nx]==1) 인경우
							 * 0100001 -> "1"도 len++처리됨 
							 */
							if(nx<0 || ny<0||nx>=N || ny>=N) {
								if(map[ny][nx]==1) {
									len = 0;
								}
								else break;
							}
							
							len++;
						}
						ans = Math.max(len,ans);
					}
				}
			}
		}
		
		System.out.println(ans);
	}
}
