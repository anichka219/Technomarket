import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
				boolean flag2 = true;
				while (flag2) {
					
					Category category = null;
					Kind kind = null;
					List<Product> currentList = new LinkedList<Product>();
					System.out.println("Natisnete 1 za razglejdane na TV & Audio");
					System.out.println("Natisnete 2 za razglejdane na Kompiutri & Periferiq");
					System.out.println("Natisnete 3 za razglejdane na Telefoni & Tableti");
					System.out.println("Natisnete 4 za razglejdane na Elektrouredi");
					System.out.println("Natisnete 5 za razglejdane na Kameri & Fotoaparati");
					System.out.println("Natisnete 6 za da se vurnete v predishnoto menu");
					System.out.println("Natisnete 0 za izhod ot saita");
					int input2 = sc.nextInt();
					
					switch (input2) {
					case 1:
						boolean flag3 = true;
						while (flag3) {
						category = Category.TV_AUDIO;
						System.out.println("Natisnete 1 za razglejdane na Televizori");
						System.out.println("Natisnete 2 za razglejdane na Domashno kino");
						System.out.println("Natisnete 3 za razglejdane na Audio sistemi");
						System.out.println("Natisnete 4 za da se vurnete v predishnoto menu");
						System.out.println("Natisnete 0 za izhod ot saita");
						int input3 = sc.nextInt();
						
						switch (input3) {
						
						case 1:
							boolean flag4 = true;
							while (flag4) {
							kind = Kind.TELEVISION;
							currentList = t.getProductList(category, kind);
							currentList.forEach(product -> System.out.println(product));
							System.out.println("Natisnete 1 za razglejdane na Televizori");
							System.out.println("Natisnete 2 za razglejdane na Domashno kino");
							System.out.println("Natisnete 3 za razglejdane na Audio sistemi");
							System.out.println("Natisnete 4 za da se vurnete v predishnoto menu");
							System.out.println("Natisnete 0 za izhod ot saita");
							int input4 = sc.nextInt();
							
							
							
							
							
							
							}
							break;
						case 2:
							kind = Kind.HOMECINEMA;
							break;
						case 3:
							kind = Kind.AUDIOSYSTEM;
							break;
						case 4:
							category = null;
							flag3 = false;
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
						category = Category.CP_PERIPHERALS;
						
						
					break;
					case 3:
						category = Category.PHONES_TABLETS;
						
						
					break;
					case 4:
						category = Category.ELECTRICAL_APPLIANCE;
						
						
					break;
					case 5:
						category = Category.PHOTO_VIDEO;
						
						
					break;
					case 6:
						flag2 = false;
						break;
					case 0:
						return;					
					default:
						System.out.println("Bad input!");
						break;
					}
				
				}
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
