import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) {
        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        // SQL Query to retrieve data from Employee table
        String query = "SELECT EmpID, Name, Salary FROM Employee";

        try {
            // Load and register JDBC driver (optional for newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!");

            // Create statement
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Display retrieved data
            System.out.println("EmpID | Name | Salary");
            while (rs.next()) {
                int empID = rs.getInt("EmpID");
                String name = rs.getString("Name");
                double salary = rs.getDouble("Salary");
                System.out.println(empID + " | " + name + " | " + salary);
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
