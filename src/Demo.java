import java.sql.SQLException;

import brands.TelevisionBrand;
import products.Category;
import products.Kind;
import products.Product;
import products.Product.Television;


public class Demo {
	public static void main(String[] args) {
		Technomarket t=Technomarket.getInstance();
			
		Product p=t.getProduct(Category.TV_AUDIO, Kind.TELEVISION);
		
		System.out.println(p.getModel());
		System.out.println(p.getPrice());
		System.out.println(p.getColor());
		System.out.println(p.getBrand());
		
	}
}
