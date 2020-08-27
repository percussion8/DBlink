import java.sql.*;

public class CreateDB {
	public static void main(String[] args) {
		String driver = "org.mariadb.jdbc.Driver";
		 String url = "jdbc:mariadb://localhost:3306/first";
		    Connection con = null;
		    Statement pstmt = null;
		    ResultSet rs = null;
		 
		   
		         try {
		            Class.forName(driver);
		            con = DriverManager.getConnection(url,
		                    "root",
		                    "2579");
		            
		            if( con != null ) {
		                System.out.println("DB 접속 성공");
		                
		                
//		                pstmt = con.createStatement();
//		                String create_db = "create database cosstock;";
//		                pstmt.executeUpdate(create_db);
		                
		                String useCos = "use cosstock";
		                pstmt.executeUpdate(useCos);
		                
		                String create_tb;
		                create_tb = "create table location("
		                		+"local_id int NOT NULL,"
		                		+"local_name varchar(50) NOT NULL,"
		                		+"primary key(local_id))";
		                
		                pstmt.executeUpdate(create_tb);
						} 
		            
		        } catch (ClassNotFoundException cnfe) { 
		            System.out.println("드라이버 로드 실패");
		        } catch (SQLException e) {
		            System.out.println("DB 접속 실패");
		            e.printStackTrace();
		        }
	}
	 
	    
}
