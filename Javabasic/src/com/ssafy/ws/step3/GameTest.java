package com.ssafy.ws.step3;

import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//prof.sol
		 Scanner sc = new Scanner(System.in);    
		 // 게임 메뉴 출력
		 System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		 System.out.println("1. 5판 3승"); 
		 System.out.println("2. 3판 2승");  
		 System.out.println("3. 1판 1승");  
		 System.out.print("번호를 입력하세요.");
		 
		 int menu = sc.nextInt();    // 사용자가 선택한 메뉴 변수
		 int comWin = 0;                // 컴퓨터가 승리한 카운트 변수
		 int userWin = 0;            // 사용자가 승리한 카운트 변수
		 int totalCnt = 0;            // 총 치뤄야 하는 게임 카운트 변수            
		 int winCnt = 0;                // 승리조건을 충족하는 카운트 변수
		 int gameCnt = 0;            // 진행중인 게임 카운트 변수
		 int comNo = 0;                // 컴퓨터가 선택한 가위,바위,보 숫자
		 String userNoStr = null;
		 int userNo = 0;                // 사용자가 선택한 가위,바위,보 숫자
		 
		 // 사용자가 선택한 메뉴에 따라 총치뤄야하는 게임 카운트와 승리조건을 충족하는 카운트를 결정한다.
		 if(menu==1) {
		     totalCnt = 5;
		     winCnt = 3;
		 }else if(menu==2) {
		     totalCnt = 3;
		     winCnt = 2;
		 }else {
		     totalCnt = 1;
		     winCnt = 1;
		 }
		 
		 // 진행중인 게임 횟수가 총 게임 카운트를 넘지 않으며 컴퓨터,사용자의 승리 카운트가 승리조건을 만족하지 못한다면 반복 
		 while(gameCnt++<totalCnt && (comWin<winCnt && userWin<winCnt)) {
		     System.out.println("가위바위보 중 하나 입력: ");
		     comNo = (int)(Math.random()*3)+1;    // 난수로 컴퓨터 가위,바위,보 선택
		     userNoStr = sc.next();                // 입력으로 사용자 가위,바위,보 선택
		     switch( userNoStr ) {
		         case "가위" : userNo = 1; break;
		         case "바위" : userNo = 2; break;
		         case "보"  : userNo = 3; break;
		     }
		     
		     // 컴퓨터와 사용자가 선택한 가위,바위,보 여부에 따라 이겼을 경우에만 해당 승리 카운트 증가
		     // 사용자 입장에서 승/패/무승부 결과 출력
		     if(comNo==1) {                        // 컴퓨터가 가위를 선택했을 경우
		         if(userNo==1) {
		             System.out.println("비겼습니다.");
		         }else if(userNo==2) {
		             System.out.println("이겼습니다.");
		             userWin++;
		         }else {
		             System.out.println("졌습니다.");
		             comWin++;
		         }
		     }else if(comNo==2) {                // 컴퓨터가 바위를 선택했을 경우
		         if(userNo==1) {
		             System.out.println("졌습니다.");
		             comWin++;
		         }else if(userNo==2) {
		             System.out.println("비겼습니다.");
		         }else {
		             System.out.println("이겼습니다.");
		             userWin++;
		         }
		     }else {                                // 컴퓨터가 보를 선택했을 경우
		         if(userNo==1) {
		             System.out.println("이겼습니다.");
		             userWin++;
		         }else if(userNo==2) {
		             System.out.println("졌습니다.");
		             comWin++;
		         }else {
		             System.out.println("비겼습니다.");
		         }
		     }            
		 }
		 
		 // 사용자 승리횟수와 컴퓨터 승리횟수 비교하여 최종 결과 출력
		 if(userWin>comWin) {
		     System.out.println("### 사용자 승!!!");
		 }else if(userWin<comWin) {
		     System.out.println("### 컴퓨터 승!!!");
		 }else {
		     System.out.println("### 무승부!!!");
		 }
		 sc.close();
		/*
		 * my sol
		 * 
		System.out.println("가위바위보 게임을 시작합니다. "
				+ "아래 보기 중 하나를 고르세요. \n 1. 5판 3승 \n 2. 3판 2승 \n 3. 1판 1승");
		
		Scanner sc =  new Scanner(System.in);
		System.out.print("번호를 입력하세요.");
		int menu = sc.nextInt();
		
		// 선택된 메뉴에 따라 변수 처리 
		int game = 0;
		int win = 0;
		
		if(menu==1) {
			game = 5;
			win = 3;
		}else if(menu==2) {
			game = 3;
			win = 2;
		}else if(menu==3){
			game = 1;
			win = 1;
		}
		
		
		//  1: 가위   2: 바위   3:보
		// 반복적으로 게임이 끝날 때까지 진행
		int com_win = 0;
		int user_win = 0;
		int g = 0;
		while(g<game) {
			if(win == com_win | win==user_win) {
				break;
			}
			int comp = (int)(Math.random()*3)+1;
			System.out.print("가위바위보 중 하나 입력: ");
			String user_S = sc.next();
			int user = 0;
			if(user_S.equals("가위")) {
				user = 1;
			}else if(user_S.equals("바위")) {
				user=2;
			}else if(user_S.equals("보")){
				user=3;
			}
			System.out.println("computer: "+comp);
			
			// 맨 아래 주석(switch)문 대신 
			if((user==1&&comp==2)||(user==2&&comp==3)||(user==3&&comp==1)) {
				com_win++;
				System.out.println("졌습니다!!!");
			}else if(user==comp) {
				System.out.println("비김!!!");
			}
			else {
				user_win++;
				System.out.println("이김!!!");
			}
			
			g++;
		}
		if(win==com_win || com_win>user_win) {
			System.out.println("컴푸터 승!!!");
		}else if(win==user_win || com_win< user_win) {
			System.out.println("사용자 승!!!");
		}else {
			System.out.println("비김");
		}

	
	*/	
	}
	

}

//switch (user) {
//case 1://user가 가위 
//	if(comp==2) {
//		com_win++;
//		System.out.println("졌습니다!!!");
//	}else if(comp==3){
//		user_win++;
//	}
//	break;
//case 2:
//	if(comp==1) {
//		user_win++;
//	}else if(comp==3){
//		com_win++;
//		System.out.println("졌습니다!!!");
//	}
//default://user가 보(3)
//	if(comp==1) {
//		com_win++;
//		System.out.println("졌습니다!!!");
//	}else if(comp==2){
//		user_win++;
//	}
//	break;
//}
