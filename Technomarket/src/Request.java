import products.Product;
import users.User;

public class Request {
	
	private User user;
	private Product product;

	public Request(User user, Product product) {
		this.user = user;
		this.product = product;
	}

}
