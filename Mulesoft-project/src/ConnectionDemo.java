import java.sql.*;
import java.util.*;
public class ConnectionDemo {
  public static void main(String[] args) {
    try {
      Scanner sc = new Scanner(System.in);
      Class.forName("org.sqlite.JDBC");
      Connection con = DriverManager.getConnection("jdbc:sqlite:Movies.db");
      if(con != null) {
    	Statement st=con.createStatement();
    	//int n=st.executeUpdate("create table movie_details(name text,actor_name text,actress_name text,director_name text,release_year int)");
    	 /*PreparedStatement pstmt = con.prepareStatement("insert into movie_details values(?,?,?,?,?)");
         String name=sc.next();
         String actor_name=sc.next();
         String actress_name=sc.next();
         String director_name=sc.next();
         int release_year=sc.nextInt();
         pstmt.setString(1,name);
         pstmt.setString(2,actor_name);
         pstmt.setString(3,actress_name);
         pstmt.setString(4,director_name);
         pstmt.setInt(5,release_year);
         int n = pstmt.executeUpdate();
         System.out.println(n);*/
    	PreparedStatement pstmt = con.prepareStatement("select * from movie_details");
        ResultSet rs = pstmt.executeQuery();
        System.out.println("Movie\t\t Actor\t\t Actress\t\t Director\t\t Releaseyear");
        System.out.println("_______________________________________________________________________________________________");
        while(rs.next()) {
          System.out.println(rs.getString(1)+"\t"+"\t"+rs.getString(2)+"\t"+"\t"+rs.getString(3)+"\t"+"\t"+rs.getString(4)+"\t"+"\t"+rs.getInt(5));
        }
        con.close();  
        
        
      }
      
    	 
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
}
 