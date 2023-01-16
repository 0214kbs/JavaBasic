package com.ssafy.ws.step3;

public class DigitTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// right answer(prof. sol)
		int cnt = 0;
		for(int i = 0;i<5;i++) {
			for(int j= 0;j<5;j++) {
				//j<i인 경우에는 공백을 출력, 그렇지 않으면 숫자를 하나씩 증가하며 출력
				if(j<i) {
					System.out.printf("%3s"," ");
				}else {
					//System.out.print(++cnt+" ");
					System.out.printf("%3d",++cnt);
				}

			}
			System.out.println();
		}
		
		//my sol
//		int i=1;
//		for(int j=0;j<5;j++){
//			for(int k=0;k<j;k++) {
//				System.out.printf("%3s"," ");
//			}
//			for(int k=i;k<(5-j)+i;k++) {
//				System.out.printf("%3d",k);
//			}
//			System.out.println();
//			i= i+(5-j);
//		}
	}

}
