import java.sql.*;

public class updateTable {
   public static void main(String[] args) {
      try {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
      } catch(ClassNotFoundException e) {
         System.out.println("Class not found "+ e);
      }
      try {
         Connection con = DriverManager.getConnection (
            "jdbc:derby://localhost:1527/testDb","username", "password");
         
         Statement stmt = con.createStatement();
         String query1 = "update emp set name = 'ravi' where id = 2";
         String query2 = "delete from emp where id = 1";
         String query3 = "insert into emp values (1,'ronak','manager')";
         
         stmt.execute(query1);
         stmt.execute(query2);
         stmt.execute(query3);
         
         ResultSet rs = stmt.executeQuery("SELECT * FROM emp");
         System.out.println("id  name    job");
         
         while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String job = rs.getString("job");
            System.out.println(id+"   "+name+"    "+job);
         }
      } catch(SQLException e) {
         System.out.println("SQL exception occured" + e);
      }
   }
}