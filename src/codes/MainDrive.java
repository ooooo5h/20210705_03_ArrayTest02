package codes;

import java.util.Scanner;

public class MainDrive {
	
	public static void main(String[] args) {
		
//		숫자 야구 게임을 만들자
//		긴 풀이가 될 예정이니까 단계별로 다시 복습하기 !!
		
//		임시 : 3자리 숫자를 3칸짜리 배열에 나눠서 저장 ex) 741
		
		int[] questionNumbers = new int[3];
		
//		임시 : 직접 741이라는 숫자를 저장했지만, 
//		향후 : 컴퓨터가 랜덤으로 숫자 3개를 뽑아서 저장하도록 바꿔줄 예정
		
		questionNumbers[0] = 7;
		questionNumbers[1] = 4;
		questionNumbers[2] = 1;
		
		
//		사용자에게 3자리 숫자를 무한히 입력받기
//		'무한히' 라는 건 몇번을 입력해야 3S가 될까?
//		반복 횟수가 불명확한 반복이니까 무한으로 while문 활용
		
		Scanner myScan = new Scanner(System.in);
		
		while (true) {
			
			System.out.print("3자리 숫자를 입력하세요 : ");
			int inputNum = myScan.nextInt();
			
//			입력받은 숫자도 3자리 배열에 나눠서 저장하자
//			ex) 123이라는 숫자를 넣었다면 [1,2,3]으로 쪼개주자는 이야기
			
			int[] inputNumbers = new int[3];
			
//			0번칸 : ex) 123을 쳤다면 => 1이 들어가야함. 어떻게? 입력값 / 100 한 값 
			inputNumbers[0] = inputNum / 100;
//			1번칸 : ex) 123을 쳤다면 => 2가 들어가야함. 어떻게? 123 => 12 => 1의 자리
			inputNumbers[1] = inputNum / 10 % 10;
//			2번칸 : ex) 123을 쳤다면 => 3이 들어가야함. 어떻게? 입력값 / 10 한 값
			inputNumbers[2] = inputNum % 10;
			
//			검사를 하기 전에, S / B 의 갯수를 기록할 변수를 만들자
			int strikeCount = 0;
			int ballCount = 0;			
			
//			내가 입력한 숫자는 i가 담당을 하고 ( 덜 바쁜 반복 ) 
//			문제 숫자는 j가 담당을 한다 ( 바쁜 반복 ) => for 중첩
			
			for(int i = 0 ; i < inputNumbers.length ; i++) {
				
				for(int j = 0; j < questionNumbers.length ; j++) {
					
//					먼저 검사 : 내 숫자 == 문제의 숫자 ?  -> 배열 안에 적힌 숫자끼리 같은가?
//					== 면 추가 검사 -> 둘의 위치도 ==?
//					if문 중첩을 해야한다!!
					
//					중간 테스트
//					System.out.println("내 숫자 : " + inputNumbers[i] + ", 문제 숫자 : " + questionNumbers[j]);
					
					if(inputNumbers[i] == questionNumbers[j]) {
						
//						추가 질문 : S / B = > 둘의 위치가 같은 가 다른가 질문해야한다 => i와 j가 같은가 다른가에 대한 질문을 해야한다는 뜻
						if( i == j) {
//							숫자도 같고, 위치도 같은 상황 => S 하나 발견
							strikeCount++;
						}
						else {
//							숫자는 같지만, 위치만 다른 상황 => B 하나 발견
							ballCount++;
						}
						
					}
					
					
					
				}
			}
			
//			?S ?B 이 되었는지 출력해보자
			System.out.println(strikeCount + "S " + ballCount + "B 입니다.");
			
			
			
			
			
		}
		
	}

}
