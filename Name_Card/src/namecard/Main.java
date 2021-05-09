package namecard;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static String InputNum = "";
	
public static void main(String[] args) {
	Name_Card_DAO ndao = new Name_Card_DAO();
	Name_Card_Print pr = new Name_Card_Print();
	
	do{
		System.out.println("---------------------");
		System.out.println("1.명함 입력");
		System.out.println("2.명함 검색");
		System.out.println("3.종료");
		System.out.println("---------------------");
		System.out.print("메뉴를 입력해주세요 >> ");
		InputNum = scanner.nextLine();
		
		switch(InputNum) {
		
		case "1":
			pr.uploadPrint();			//1.명함 입력
			break;
			
		case "2":			
			pr.search();			//2.명함 검색
			break;
			
		case "3":
			System.out.println("");
			System.out.println("프로그램을 종료합니다. ");	 		//3.종료
			break;
		
		default:
			System.out.println("");
			System.out.println("잘못된 입력입니다.");
			System.out.println("");
			break;
		}
	}while(!"3".equals(InputNum));
}


}