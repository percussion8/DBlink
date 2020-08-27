
import java.sql.*;
 
public class DBLink {
	public static void main(String[] args) {
		String driver = "org.mariadb.jdbc.Driver";
	    Connection con;
	    Statement pstmt;
	    ResultSet rs;

	    
	         try {
	            Class.forName(driver);
	            con = DriverManager.getConnection(
	                    "jdbc:mariadb://localhost:3306/first",
	                    "root",
	                    "2579");
	            
	            if( con != null ) {
	                System.out.println("DB 접속 성공");
	                
	                
	                pstmt = con.createStatement();
	                String useSimple = "use first";
	                pstmt.executeUpdate(useSimple);
	                
	                String showall = "select * from simple_user";
	                rs = pstmt.executeQuery(showall);
	                while (rs.next()) {
						System.out.printf("%-14s\t", rs.getString(1));
						System.out.printf("%-14s\t", rs.getString(2));
						System.out.printf("%-14s\t\n", rs.getString(3));
					}
	                
	            }
	            
	        } catch (ClassNotFoundException cnfe) { 
	            System.out.println("드라이버 로드 실패");
	        } catch (SQLException e) {
	            System.out.println("DB 접속 실패");
	            e.printStackTrace();
	        }
	}
    
    
}
