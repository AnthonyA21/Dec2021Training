package jdbcProject;

import java.sql.*;

public class JdbcTest {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/sakila";

	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
	
		  conn = DriverManager.getConnection(DB_URL,USER,PASS);
		  stmt = conn.createStatement();
		  String sql = "";
		  sql = "SELECT city FROM sakila.city ORDER BY city DESC LIMIT 10;";
		  ResultSet rs = stmt.executeQuery(sql);
		  System.out.println("10 cities displayed in descending alphabetical order:");
		  while(rs.next()) {
		       String city = rs.getString("city");

		       System.out.println(city);
		  }
		  System.out.println("");
		  
		  sql = "SELECT title FROM sakila.film WHERE title LIKE '%airplane%';";
		  rs = stmt.executeQuery(sql);
		  System.out.println("All films with \"Airplane\" in title:");		  
		  while(rs.next()) {
		       String title = rs.getString("title");

		       System.out.println(title);
		  }
		  System.out.println("");
		  
		  sql = "SELECT MAX(amount) FROM payment;";
		  rs = stmt.executeQuery(sql);
		  System.out.println("Highest payment amount:");		  
		  while(rs.next()) {
		       Float maxAmount = rs.getFloat("MAX(amount)");

		       System.out.println(maxAmount);
		  }
		  System.out.println("");
		  
		  sql = "SELECT COUNT(*) FROM customer AS c WHERE c.store_id = 1;";
		  rs = stmt.executeQuery(sql);
		  System.out.println("Number of records in customer table for Store ID #1:");		  
		  while(rs.next()) {
		       int custRecCount = rs.getInt("COUNT(*)");

		       System.out.println(custRecCount);
		  }
		  System.out.println("");
		  
		  sql = "SELECT p.* FROM payment AS p INNER JOIN customer AS c ON c.customer_id = p.customer_id "
		  	  + "WHERE c.email = 'NANCY.THOMAS@sakilacustomer.org';";
		  rs = stmt.executeQuery(sql);
		  System.out.println("All payment records for customer with e-mail address \"NANCY.THOMAS@sakilacustomer.org\"");		  
		  while(rs.next()) {
			     System.out.println("Payment_ID:" + rs.getInt("payment_id") + " Customer_ID:" + rs.getInt("customer_id") 
			     					+ " Staff_ID:" + rs.getInt("staff_id") + " Rental_ID:" + rs.getInt("staff_id")
			     					+ " Amount:" + rs.getFloat("amount") + " Payment_Date:" + rs.getDate("payment_date")
			     					+ " Last_Update:" + rs.getDate("last_update"));
		  }
		  System.out.println("");
		  
		  sql = "SELECT * FROM film_list WHERE actors LIKE ? ;";
		  PreparedStatement preparedStmt = conn.prepareStatement(sql);
		  preparedStmt.setString(1, "%BOB FAWCETT%");
		  
		  rs = preparedStmt.executeQuery();	  
		  System.out.println("Film info for actor Bob Fawcett:");		  
		  while(rs.next()) {
			     System.out.println("FID:" + rs.getInt("FID") + " Title:" + rs.getString("title") 
			     					+ " Description:" + rs.getString("description") + " Category:" + rs.getString("category")
			     					+ " Price:" + rs.getFloat("price") + " Length:" + rs.getInt("length")
			     					+ " Rating:" + rs.getString("rating") + " Actors:" + rs.getString("actors"));
		  }
		  System.out.println("");
		  
		  sql = "SELECT f.film_id FROM film AS f WHERE f.title = 'Alien Center'";
		  rs = stmt.executeQuery(sql);
		  int filmId = 0; 		  
		  while (rs.next()) {
			  filmId = rs.getInt("film_id");			  
		  }
		  String storedProcSql = "CALL film_in_stock(?, 2, ?);";
		  CallableStatement callableStmt = conn.prepareCall(storedProcSql);
		  callableStmt.setInt(1, filmId);
		  callableStmt.setInt(2, 0);
		  
		  rs = callableStmt.executeQuery();	  
		  System.out.println("4 inventory IDs for the film \"Alien Center\" at Store #2:");		  
		  while(rs.next()) {
			     System.out.println("Inventory_ID:" + rs.getInt("inventory_id"));
		  }
		  System.out.println("");
		  
		  System.out.println("Start inserting new database record and rolling back");
		  sql = "START TRANSACTION;"
		  	  + "INSERT INTO staff (first_name, last_name, address_id, email, store_id, `active`, username) "
		  	  + "VALUES (\"John\", \"Doe\", \"18\", \"rando@gmail.com\", \"2\", \"1\", \"newJohn\");"
		  	  + "SET @staffId = LAST_INSERT_ID();"
		  	  + "INSERT INTO address (address, district, city_id, phone, location) \r\n"
		  	  + "VALUES ('110 Main', 'Dime Box', 300, 7137778888, ST_GeomFromText('POINT(1 1)'));"
		  	  + "SET @addressId = LAST_INSERT_ID();"
		  	  + "INSERT INTO store (manager_staff_id, address_id) "
		  	  + "VALUES (@staffId, @addressId);"
		  	  + "SET @storeId = LAST_INSERT_ID();\r\n"
		  	  + "UPDATE staff "
		  	  + "SET store_id = @storeId "
		  	  + "WHERE staff_id = @staffId;"
		  	  + "ROLLBACK;";
		  rs = preparedStmt.executeQuery();
		  System.out.println("Finished inserting new database record and rolling back");		  

		  rs.close();
		  stmt.close();
		  conn.close();
		}
		catch(SQLException se) {
			se.printStackTrace(); 
		}
		catch(Exception e){  
			e.printStackTrace(); 
		}
	}
}
	  
