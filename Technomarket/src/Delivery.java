import java.util.ArrayList;

import products.Product;
import users.User;

public class Delivery {
	
	private User user;
	private ArrayList<Product> productsForDelivery;

	public Delivery(User user, ArrayList<Product> shopingCart) {
		this.user = user;
		this.productsForDelivery = shopingCart;
	}

	public User getUser() {
		return user;
	}

	public ArrayList<Product> getProductsForDelivery() {
		return productsForDelivery;
	}

	
}
