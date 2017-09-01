import java.sql.*;

public class jdbcConn {
   public static void main(String[] args) {
      try {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
      } catch(ClassNotFoundException e) {
         System.out.println("Class not found "+ e);
      }
      System.out.println("JDBC Class found");
      int no_of_rows = 0;
      
      try {
         Connection con = DriverManager.getConnection (
            "jdbc:derby://localhost:1527/testDb","username", "password");  
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery ("SELECT * FROM employee");
         while (rs.next()) {
            no_of_rows++;
         }
         System.out.println("There are "+ no_of_rows + " record in the table");
      } catch(SQLException e){
         System.out.println("SQL exception occured" + e);
      }
   }
}