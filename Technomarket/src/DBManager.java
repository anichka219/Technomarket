
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import products.Product;
import users.User;

public class DBManager {
	private static final String DB_IP = "127.0.0.1";
	private static final String DB_PORT = "3306";
	private static final String DB_DBNAME = "technomarket";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "";
	
	private static DBManager instance;
	private static Connection connection;

	private DBManager() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + DB_IP + ":" + DB_PORT + "/" + DB_DBNAME, DB_USER, DB_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	public void addProduct(Product p) {
		
		String query="Insert into products values('"+p.getProductID()+"','"+p.getModel()+"',"+p.getPrice()+",'"+p.getDesciption()+"','"
	+p.getColor()+"',"+p.getKind().getId()+","+p.getBrand().getId()+");";
		
		Statement statement1 = null;
		try {
			statement1 = connection.createStatement();
			statement1.executeUpdate(query);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}
	public void addUser(User u) {
		String query="Insert into users values('"+u.getUserID()+"','"+u.getFirstName()+"','"+u.getLastName()+"','"+
	u.getEmail()+"','"+u.getPassword()+"','"+u.getGender()+"','"+u.getBirthDate()+"',true,false);";
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void deleteProducts() {
		String query="Delete from products;";
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
