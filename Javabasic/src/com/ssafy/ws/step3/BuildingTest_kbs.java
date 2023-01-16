package com.ssafy.ws.step3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;
// my sol 
public class BuildingTest_kbs {
	// static 변수 
	static int T, N, max_b;
	static char[][] maps;
	public static void main(String[] args) throws Exception{
		
		/*code refactoring
			1. Scanner 대신 BufferedReader (속도)
			2. static 변수 설정 (속도 변화 거의 없음, 가독성 높일 수 있음) 
		*/
		System.setIn(new FileInputStream("input.txt"));
		
		//Scanner sc = new Scanner(System.in);
		//int T = sc.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); // int T -> T
		
		
		
		
		for (int t = 1; t <= T; t++) {
			
			max_b = 0;
			
//			int N = sc.nextInt();
			N = Integer.parseInt(br.readLine());
			
			//char[][] maps = new char[N+2][N+2];
			maps = new char[N+2][N+2];
			
			/*
			for(int i=1;i<N+1;i++) {
				for(int j = 1;j<N+1;j++) {
					maps[i][j] = sc.next().charAt(0);
					
				}
			}
			 */
			for(int i=1;i<N+1;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 1;j<N+1;j++) {
					maps[i][j] = st.nextToken().charAt(0);
				}
			}
			
			for(int i=1;i<N+1;i++) {
				for(int j = 1;j<N+1;j++) {
					int cnt_B = 0;
					boolean isG = false;
					if(maps[i][j]=='G'){continue;}
					else {
						
						if(maps[i-1][j]=='G')  isG = true;//상
						else if(maps[i+1][j]=='G')  isG = true;//하					
						else if(maps[i][j-1]=='G')  isG = true;//좌					 
						else if(maps[i][j+1]=='G') isG = true;//우						
						else if(maps[i-1][j-1]=='G')  isG = true;//좌상						
						else if(maps[i-1][j+1]=='G')  isG = true;//우상						
						else if(maps[i+1][j-1]=='G') isG = true;//좌하						
						else if(maps[i+1][j+1]=='G') isG = true;//우하
						
						if(!isG) {
							for(int ki=1;ki<N+1;ki++) {
								if(maps[ki][j]=='B') {
									cnt_B ++;
								}
								if(maps[i][ki]=='B') {
									cnt_B++;
								}
							}
							cnt_B--; // 중복된 자신
						}else {
							cnt_B =2;
						}
						
						if(cnt_B>max_b) max_b = cnt_B;
						
					}
				}
			}
			
			System.out.println("#"+t+" "+max_b);
		}
		
		
	}

}
