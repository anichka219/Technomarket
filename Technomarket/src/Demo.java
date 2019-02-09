import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import brands.TelevisionBrand;
import products.Category;
import products.Kind;
import products.Product;
import products.Product.Television;
import users.Gender;
import users.User;


public class Demo {
	public static void main(String[] args) {
		Technomarket t=Technomarket.getInstance();
			
		Product p=t.getProduct(Category.TV_AUDIO, Kind.TELEVISION);
		
		System.out.println(p.getModel());
		System.out.println(p.getPrice());
		System.out.println(p.getColor());
		System.out.println(p.getBrand());
		
		Scanner sc = new Scanner(System.in);
		HashMap<Product, Integer> shopingCart = new HashMap<Product, Integer>();
		boolean hasLoggedIn = false;
		User user = null;
		System.out.println("Dobre doshli v saita na Technomarket!");
		while (true) {
			
			System.out.println("Natisnete 1 za vlizane v profil");
			System.out.println("Natisnete 2 za razglejdane na produkti");
			System.out.println("Natisnete 0 za izhod ot saita");
			int input1 = sc.nextInt();
			
			switch(input1) {
			
			case 1:
				boolean flag1 = true;
				while (flag1) {
					
					System.out.println("Natisnete 1 za log in");
					System.out.println("Natisnete 2 za registraciq");
					System.out.println("Natisnete 3 za da se vurnete v predishnoto menu");
					System.out.println("Natisnete 0 za izhod ot saita");
					int input2 = sc.nextInt();

					switch(input2) {
					
					case 1:
						System.out.println("Molq vuvedete email:");
						String email1 = sc.next();
						System.out.println("Molq vuvedete parola:");
						String password1 = sc.next();
						if (t.checkUser(email1) == true) {
							try {
								user = t.getUser(email1);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("Vlqzohte v profila si uspeshno!");
							hasLoggedIn = true;
						}
						else {
							System.out.println("Ne ste registriran v saita!");
						}
						break;
					case 2:
						System.out.println("Molq vuvedete ime:");
						String ime2 = sc.next();
						System.out.println("Molq vuvedete familiq:");
						String familiq2 = sc.next();
						System.out.println("Molq vuvedete email:");
						String email2 = sc.next();
						System.out.println("Molq vuvedete parola:");
						String password2 = sc.next();
						System.out.println("Molq vuvedete pol(male/female):");
						String gender = sc.next();
						while (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
							System.out.println("Greshni danni!");
							System.out.println("Molq vuvedete pol(male/female):");
							gender = sc.next();
						}
						Gender gender2 = (gender.equalsIgnoreCase("male")) ? Gender.MALE : Gender.FEMALE;
						System.out.println("Molq vuvedete den na rajdane:");
						int day = sc.nextInt();;
						while (!(day > 0 && day <= 31)) {
							System.out.println("Greshni danni!");
							System.out.println("Molq vuvedete den na rajdane:");
							day = sc.nextInt();
						}
						System.out.println("Molq vuvedete mesec na rajdane:");
						int month = sc.nextInt();
						while (!(month > 0 && month <= 12)) {
							System.out.println("Greshni danni!");
							System.out.println("Molq vuvedete mesec na rajdane:");
							month = sc.nextInt();
						}
						System.out.println("Molq godina den na rajdane:");
						int year = sc.nextInt();
						while (!(year > 1900 && year <= LocalDate.now().getYear())) {
							System.out.println("Greshni danni!");
							System.out.println("Molq godina den na rajdane:");
							year = sc.nextInt();
						}
						LocalDate birthDate = LocalDate.of(year, month, day);
						if (t.checkUser(email2) == false) {
							user = new User(ime2, familiq2, email2, password2, gender2, birthDate);
							t.add(user);
							System.out.println("Registrirahte se uspeshno!");
							hasLoggedIn = true;
						}
						else {
							System.out.println("Tova potrebitelsko ime veche e zaeto!");
						}
						break;
					case 3:
						flag1 = false;
						break;
					case 0:
						return;					
					default:
						System.out.println("Bad input!");
						break;
				}
					
					
				}
				break;
			case 2:
				
			break;
			case 0:
				return;
			default:
				System.out.println("Bad input!");
			break;
		}
			
			
			
		}
		
	}
}
