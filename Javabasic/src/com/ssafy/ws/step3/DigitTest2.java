package com.ssafy.ws.step3;

public class DigitTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// right answer(prof. sol)
		int target = 5/2; // 행이 위에서 아래로 내려가면서 blank가 증가에서 감소로 전환되는 변곡 지점
		int blank = 0; // 각 행에서 빈칸을 몇번 출력하는가
		boolean isIncrease = true; // blank 값의 증감을 판단하는 논리변수 
		 
		int no = 1;
		while (no<=17) { // 1~17 까지 진행
			
			//빈칸 blank 만큼 출력
			for (int i = 0; i < blank; i++) {
				System.out.printf("%3s"," ");
			}
			
			//숫자 출력
			for (int i = 0; i < 5-blank*2; i++) {
				System.out.printf("%3d",no++);
			}
			
			// isIncrease에 의해 blank를 증감시킴
			if(isIncrease) {
				blank++;
			}else {
				blank--;
			}
			//변곡점이면 isIncrease를 반대로
			if (blank == target) {
				isIncrease = false;
			}
			
			System.out.println();
		}
		
		//my sol 
		//review: for문을 여러개 만들기 보다 변곡점 check 
//		int i=1;
//		for(int j=0;j<3;j++){
//			for(int k=0;k<j;k++) {
//				System.out.printf("%3s"," ");
//			}
//			for(int k=i;k<(5-j*2)+i;k++) {
//				System.out.printf("%3d",k);
//			}
//			for(int k=0;k<j;k++) {
//				System.out.printf("%3s"," ");
//			}
//			System.out.println();
//			i= i+(5-j*2);
//		}
//		for(int j=1;j>=0;j--){
//			for(int k=0;k<j;k++) {
//				System.out.printf("%3s"," ");
//			}
//			for(int k=i;k<(5-j*2)+i;k++) {
//				System.out.printf("%3d",k);
//			}
//			for(int k=0;k<j;k++) {
//				System.out.printf("%3s"," ");
//			}
//			System.out.println();
//			i= i+(5-j*2);
//		}
		
	}

}
