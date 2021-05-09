package namecard;

import java.util.List;
import java.util.Scanner;

public class Name_Card_Print {
	Name_Card_DAO upload;
	Name_Card_DAO nameAll;
	static String name;
	
	public Name_Card_Print() {
		upload = new Name_Card_DAO();
		nameAll = new Name_Card_DAO();
	}
	
	//---------------------------------------------------------------------------------------->
	//명함 정보 입력
	public void uploadPrint() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름을 입력하세요: ");
		name = scanner.next();
		System.out.print("전화번호를 입력하세요: ");
		String phoneNum = scanner.next();
		System.out.print("회사명을 입력하세요: ");
		String company = scanner.next();
		
		Name_Card_VO vo = new Name_Card_VO(name, phoneNum, company);
		upload.InputNameCard(vo);
	}
	//---------------------------------------------------------------------------------------->
	//명함 리스트(이름으로 검색)
	public void search() {
		   Scanner scanner = new Scanner(System.in);
	       System.out.println("");
	       System.out.print("검색할 이름을 입력하세요: ");
	       name = scanner.next();
	       System.out.println("");
	        
	       List<Name_Card_VO> search = nameAll.nameAll();
			 
			 for (Name_Card_VO nvo : search) {
				 System.out.println(nvo);
			 }
	
}
}
