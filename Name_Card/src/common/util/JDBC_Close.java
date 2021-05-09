package common.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Close {

	public static void closeConnPrestmtRs(Connection conn,
			PreparedStatement prestmt, ResultSet rs) {

			//5. 클로징 처리에 의한 자원 반납
			
			try {
				if(rs != null) rs.close();	
//				System.out.println(">> ResultSet close 처리 완료");
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			
			try {
				if(prestmt != null) prestmt.close();	// 제대로 처리하려면 널이냐 아니냐 물어봐야 정확
//				System.out.println(">> Statement close 처리 완료");
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			
			try {
				if (conn != null) conn.close();
//				System.out.println(">> Connection close 처리 완료"); // -> SQL에 INSERT되어있는 것 확인 가능 (+ 자동 커밋 됨)
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}


	public static void closeConnPrestmt(Connection conn,
			PreparedStatement prestmt) {

		//5. 클로징 처리에 의한 자원 반납
		
		
		try {
			if(prestmt != null) prestmt.close();	// 제대로 처리하려면 널이냐 아니냐 물어봐야 정확
			//System.out.println(">> Statement close 처리 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		try {
			if (conn != null) conn.close();
			//System.out.println(">> Connection close 처리 완료"); // -> SQL에 INSERT되어있는 것 확인 가능 (+ 자동 커밋 됨)
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
