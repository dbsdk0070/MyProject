package namecard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import common.util.JDBC_Close;

public class Name_Card_DAO {

	private final String DRIVER = "oracle.jdbc.OracleDriver"; 
    private final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
    private final String USER = "mystudy";
    private final String PASSWORD = "mystudypw"; 
    
    private Connection conn;  
    private PreparedStatement prestmt;
    private ResultSet rs;
    
    public Name_Card_DAO() {
       try {
          Class.forName(DRIVER);
       } catch (ClassNotFoundException e) {
          e.printStackTrace();
       }
    }
    
    //----------------------------------------------------
    //명함 정보 입력
    public int InputNameCard(Name_Card_VO upload) {
    	int result = 0;
    
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
    		conn = DriverManager.getConnection(URL, USER, PASSWORD);
    		StringBuilder sb = new StringBuilder();
    		
    		sb.append("INSERT INTO MEMBERS");
    		sb.append("            (NAME, PHONENUMBER, COMPANY)");
    		sb.append("VALUES (?, ?, ?)");
    		
    		pstmt = conn.prepareStatement(sb.toString());
    		
    		pstmt.setString(1, upload.getName());
            pstmt.setString(2, upload.getPhoneNumber());
            pstmt.setString(3, upload.getCompany());

            result = pstmt.executeUpdate();
    	} catch (SQLException e) {
            e.printStackTrace();
         } finally {
            JDBC_Close.closeConnPrestmt(conn, pstmt);
         }
        return result;
     }
    
    //---------------------------------------------------------------------------------------->
    //명함 목록(이름으로 검색)
    public List<Name_Card_VO> nameAll() {
	      List<Name_Card_VO> nameall = null;
	      
	      try {

	         conn = DriverManager.getConnection(URL, USER, PASSWORD);

	         StringBuilder sb = new StringBuilder();
	         Name_Card_Print np = new Name_Card_Print();
	         String str = np.name;
	         
	         sb.append("SELECT * ");
	         sb.append("  FROM MEMBERS ");
	         sb.append("WHERE NAME LIKE '%" + str + "%'");
	         
	         prestmt = conn.prepareStatement(sb.toString());
	         
	         rs = prestmt.executeQuery();
	         
	         nameall = new ArrayList<Name_Card_VO>();
	         
	         while (rs.next()) {

	        	 nameall.add(new Name_Card_VO(
	                  rs.getString("NAME"),
	                  rs.getString("PHONENUMBER"),
	                  rs.getString("COMPANY") ) );
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         JDBC_Close.closeConnPrestmtRs(conn, prestmt, rs);
	      }
	      return nameall;
	   }
}
//    public List<Name_Card_VO> search() {
//	      List<Name_Card_VO> search = null;
//	      
//	      try {
//	         conn = DriverManager.getConnection(URL, USER, PASSWORD);
//	         
//	         StringBuilder sb = new StringBuilder();
//	         Name_Card_Print np = new Name_Card_Print();
//	         
//	         String str = np.name;
//	         
//	         sb.append("SELECT * ");
//	         sb.append("  FROM MEMBERS ");
//	         sb.append(" WHERE NAME like '%" + str + "%' ");
//	         sb.append(" ORDER BY NAME ");
//	         
//	         prestmt = conn.prepareStatement(sb.toString());
//	         
//	         rs = prestmt.executeQuery();
//	         
//	         search = new ArrayList<Name_Card_VO>();
//	         while (rs.next()) {
//
//	        	 search.add(new Name_Card_VO(
//	                  rs.getString("NAME"),
//	                  rs.getString("PHONENUMBER"),
//	                  rs.getString("COMPANY")));
//	         }
//	         
//	      } catch (SQLException e) {
//	         e.printStackTrace();
//	      } finally {
//	         JDBC_Close.closeConnPrestmtRs(conn, prestmt, rs);
//	      }
//	      return search;
//	   }
//}