import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
			
//		Product p=t.getProduct(Category.TV_AUDIO, Kind.TELEVISION);
//		
//		System.out.println(p.getModel());
//		System.out.println(p.getPrice());
//		System.out.println(p.getColor());
//		System.out.println(p.getBrand());
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Product> shopingCart = new ArrayList();
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
								kind = Kind.TELEVISION;
								currentList = t.getProductList(category, kind);
								while (flag4) {
									
									currentList.forEach(product -> System.out.println(product));
									System.out.println();
									System.out.println("Natisnete 1 za sortirane po cena vuv vuzhodqsht red");
									System.out.println("Natisnete 2 za sortirane po cena v nizhodqsht red");
									System.out.println("Natisnete 3 za sortirane po azbuchen red na modela");
									System.out.println("Natisnete 4 za filtrirane po maximalna cena");
									System.out.println("Natisnete 5 za filtrirane po maximalna cena");
									System.out.println("Natisnete 6 za da se vurnete v predishnoto menu");
									System.out.println("Natisnete 7 za da dobavqne na ured v kolichkata");
									System.out.println("Natisnete 8 za pregled na kolichkata vi");
									System.out.println("Natisnete 9 za kupuvane na uredite v kolichkata vi");
									System.out.println("Natisnete 0 za izhod ot saita");
									int input4 = sc.nextInt();
									
									switch (input4) {
									
									case 1:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p1.getPrice() - (int)p2.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 2:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p2.getPrice() - (int)p1.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 3:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> p1.getModel().compareTo(p2.getModel()))
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 4:
										System.out.println("Molq vuvedete maximalna cena:");
										int input5 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() < input5).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() < input5)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
										}
										break;
									case 5:
										System.out.println("Molq vuvedete minimalna cena:");
										int input6 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() > input6).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() > input6)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 6:
										kind = null;
										flag4 = false;
										break;
									case 7:
										System.out.println("Molq vuvedete ID na ureda:");
										int input7 = sc.nextInt();
										if(!t.containsProductID(category, kind, input7)) {
											System.out.println("Greshno ID!");
										}
										else {
											if (!t.hasProductInStock(category, kind, input7)) {
												System.out.println("Ureda ne e nalichen v momenta!");
												if (hasLoggedIn) {
													System.out.println("Shte poluchite suobshtenie kogato zaredime broiki!");
													Request request = new Request(user, t.getProduct(category, kind, input7));
													try {
														t.addRequest(request);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
											}
											else {
												shopingCart.add(t.getProduct(category, kind, input7));
											}
										}
										break;
									case 8:
										if(shopingCart.isEmpty()) {
											System.out.println("Kolichkata vi e prazna!");
										}
										else {
											shopingCart.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 9:
										if (!hasLoggedIn) {
											System.out.println("Ne ste vleznali v profila si!");
										}
										else {
											System.out.println("Vuvedete nomer na kreditna karta:");
											String input8 = sc.next();
											CreditCard card = new CreditCard(input8);
											int sum = 0;
											for (Product p1 : shopingCart) {
												sum += p1.getPrice();
											}
											if (sum > card.getMoney()) {
												System.out.println("Nqmate dostatuchno pari v smetkata si!");
											}
											else {
												card.setMoney(card.getMoney() - sum);
												System.out.println("Chestito kupihte uredite! Shte poluchite suobshtenie v denq na dostavka!");
												Delivery delivery = new Delivery (user, shopingCart);
												try {
													t.addDelivery(delivery);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												sum = 0;
												shopingCart.clear();
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
								break;
							case 2:
								boolean flag5 = true;
								kind = Kind.HOMECINEMA;
								currentList = t.getProductList(category, kind);
								while (flag5) {
									
									currentList.forEach(product -> System.out.println(product));
									System.out.println();
									System.out.println("Natisnete 1 za sortirane po cena vuv vuzhodqsht red");
									System.out.println("Natisnete 2 za sortirane po cena v nizhodqsht red");
									System.out.println("Natisnete 3 za sortirane po azbuchen red na modela");
									System.out.println("Natisnete 4 za filtrirane po maximalna cena");
									System.out.println("Natisnete 5 za filtrirane po maximalna cena");
									System.out.println("Natisnete 6 za da se vurnete v predishnoto menu");
									System.out.println("Natisnete 7 za da dobavqne na ured v kolichkata");
									System.out.println("Natisnete 8 za pregled na kolichkata vi");
									System.out.println("Natisnete 9 za kupuvane na uredite v kolichkata vi");
									System.out.println("Natisnete 0 za izhod ot saita");
									int input9 = sc.nextInt();
									
									switch (input9) {
									
									case 1:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p1.getPrice() - (int)p2.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 2:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p2.getPrice() - (int)p1.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 3:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> p1.getModel().compareTo(p2.getModel()))
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 4:
										System.out.println("Molq vuvedete maximalna cena:");
										int input10 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() < input10).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() < input10)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 5:
										System.out.println("Molq vuvedete minimalna cena:");
										int input11 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() > input11).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() > input11)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 6:
										kind = null;
										flag5 = false;
										break;
									case 7:
										System.out.println("Molq vuvedete ID na ureda:");
										int input12 = sc.nextInt();
										if(!t.containsProductID(category, kind, input12)) {
											System.out.println("Greshno ID!");
										}
										else {
											if (!t.hasProductInStock(category, kind, input12)) {
												System.out.println("Ureda ne e nalichen v momenta!");
												if (hasLoggedIn) {
													System.out.println("Shte poluchite suobshtenie kogato zaredime broiki!");
													Request request = new Request(user, t.getProduct(category, kind, input12));
													try {
														t.addRequest(request);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
											}
											else {
												shopingCart.add(t.getProduct(category, kind, input12));
											}
										}
										break;
									case 8:
										if(shopingCart.isEmpty()) {
											System.out.println("Kolichkata vi e prazna!");
										}
										else {
											shopingCart.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 9:
										if (!hasLoggedIn) {
											System.out.println("Ne ste vleznali v profila si!");
										}
										else {
											System.out.println("Vuvedete nomer na kreditna karta:");
											String input13 = sc.next();
											CreditCard card = new CreditCard(input13);
											int sum = 0;
											for (Product p1 : shopingCart) {
												sum += p1.getPrice();
											}
											if (sum > card.getMoney()) {
												System.out.println("Nqmate dostatuchno pari v smetkata si!");
											}
											else {
												card.setMoney(card.getMoney() - sum);
												System.out.println("Chestito kupihte uredite! Shte poluchite suobshtenie v denq na dostavka!");
												Delivery delivery = new Delivery (user, shopingCart);
												try {
													t.addDelivery(delivery);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												sum = 0;
												shopingCart.clear();
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
								break;
							case 3:
								boolean flag6 = true;
								kind = Kind.AUDIOSYSTEM;
								currentList = t.getProductList(category, kind);
								while (flag6) {
									
									currentList.forEach(product -> System.out.println(product));
									System.out.println();
									System.out.println("Natisnete 1 za sortirane po cena vuv vuzhodqsht red");
									System.out.println("Natisnete 2 za sortirane po cena v nizhodqsht red");
									System.out.println("Natisnete 3 za sortirane po azbuchen red na modela");
									System.out.println("Natisnete 4 za filtrirane po maximalna cena");
									System.out.println("Natisnete 5 za filtrirane po maximalna cena");
									System.out.println("Natisnete 6 za da se vurnete v predishnoto menu");
									System.out.println("Natisnete 7 za da dobavqne na ured v kolichkata");
									System.out.println("Natisnete 8 za pregled na kolichkata vi");
									System.out.println("Natisnete 9 za kupuvane na uredite v kolichkata vi");
									System.out.println("Natisnete 0 za izhod ot saita");
									int input14 = sc.nextInt();
									
									switch (input14) {
									
									case 1:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p1.getPrice() - (int)p2.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 2:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p2.getPrice() - (int)p1.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 3:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> p1.getModel().compareTo(p2.getModel()))
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 4:
										System.out.println("Molq vuvedete maximalna cena:");
										int input15 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() < input15).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() < input15)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 5:
										System.out.println("Molq vuvedete minimalna cena:");
										int input16 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() > input16).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() > input16)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 6:
										kind = null;
										flag6 = false;
										break;
									case 7:
										System.out.println("Molq vuvedete ID na ureda:");
										int input17 = sc.nextInt();
										if(!t.containsProductID(category, kind, input17)) {
											System.out.println("Greshno ID!");
										}
										else {
											if (!t.hasProductInStock(category, kind, input17)) {
												System.out.println("Ureda ne e nalichen v momenta!");
												if (hasLoggedIn) {
													System.out.println("Shte poluchite suobshtenie kogato zaredime broiki!");
													Request request = new Request(user, t.getProduct(category, kind, input17));
													try {
														t.addRequest(request);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
											}
											else {
												shopingCart.add(t.getProduct(category, kind, input17));
											}
										}
										break;
									case 8:
										if(shopingCart.isEmpty()) {
											System.out.println("Kolichkata vi e prazna!");
										}
										else {
											shopingCart.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 9:
										if (!hasLoggedIn) {
											System.out.println("Ne ste vleznali v profila si!");
										}
										else {
											System.out.println("Vuvedete nomer na kreditna karta:");
											String input18 = sc.next();
											CreditCard card = new CreditCard(input18);
											int sum = 0;
											for (Product p1 : shopingCart) {
												sum += p1.getPrice();
											}
											if (sum > card.getMoney()) {
												System.out.println("Nqmate dostatuchno pari v smetkata si!");
											}
											else {
												card.setMoney(card.getMoney() - sum);
												System.out.println("Chestito kupihte uredite! Shte poluchite suobshtenie v denq na dostavka!");
												Delivery delivery = new Delivery (user, shopingCart);
												try {
													t.addDelivery(delivery);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												sum = 0;
												shopingCart.clear();
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
						boolean flag7 = true;
						while (flag7) {
							category = Category.CP_PERIPHERALS;
							System.out.println("Natisnete 1 za razglejdane na Laptopi");
							System.out.println("Natisnete 2 za razglejdane na Kompiutri");
							System.out.println("Natisnete 3 za razglejdane na Monitori");
							System.out.println("Natisnete 4 za da se vurnete v predishnoto menu");
							System.out.println("Natisnete 0 za izhod ot saita");
							int input19 = sc.nextInt();
							
							switch (input19) {
							
							case 1:
								boolean flag8 = true;
								kind = Kind.LAPTOP;
								currentList = t.getProductList(category, kind);
								while (flag8) {
									
									currentList.forEach(product -> System.out.println(product));
									System.out.println();
									System.out.println("Natisnete 1 za sortirane po cena vuv vuzhodqsht red");
									System.out.println("Natisnete 2 za sortirane po cena v nizhodqsht red");
									System.out.println("Natisnete 3 za sortirane po azbuchen red na modela");
									System.out.println("Natisnete 4 za filtrirane po maximalna cena");
									System.out.println("Natisnete 5 za filtrirane po maximalna cena");
									System.out.println("Natisnete 6 za da se vurnete v predishnoto menu");
									System.out.println("Natisnete 7 za da dobavqne na ured v kolichkata");
									System.out.println("Natisnete 8 za pregled na kolichkata vi");
									System.out.println("Natisnete 9 za kupuvane na uredite v kolichkata vi");
									System.out.println("Natisnete 0 za izhod ot saita");
									int input20 = sc.nextInt();
									
									switch (input20) {
									
									case 1:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p1.getPrice() - (int)p2.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 2:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p2.getPrice() - (int)p1.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 3:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> p1.getModel().compareTo(p2.getModel()))
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 4:
										System.out.println("Molq vuvedete maximalna cena:");
										int input21 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() < input21).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() < input21)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 5:
										System.out.println("Molq vuvedete minimalna cena:");
										int input22 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() > input22).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() > input22)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 6:
										kind = null;
										flag8 = false;
										break;
									case 7:
										System.out.println("Molq vuvedete ID na ureda:");
										int input23 = sc.nextInt();
										if(!t.containsProductID(category, kind, input23)) {
											System.out.println("Greshno ID!");
										}
										else {
											if (!t.hasProductInStock(category, kind, input23)) {
												System.out.println("Ureda ne e nalichen v momenta!");
												if (hasLoggedIn) {
													System.out.println("Shte poluchite suobshtenie kogato zaredime broiki!");
													Request request = new Request(user, t.getProduct(category, kind, input23));
													try {
														t.addRequest(request);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
											}
											else {
												shopingCart.add(t.getProduct(category, kind, input23));
											}
										}
										break;
									case 8:
										if(shopingCart.isEmpty()) {
											System.out.println("Kolichkata vi e prazna!");
										}
										else {
											shopingCart.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 9:
										if (!hasLoggedIn) {
											System.out.println("Ne ste vleznali v profila si!");
										}
										else {
											System.out.println("Vuvedete nomer na kreditna karta:");
											String input24 = sc.next();
											CreditCard card = new CreditCard(input24);
											int sum = 0;
											for (Product p1 : shopingCart) {
												sum += p1.getPrice();
											}
											if (sum > card.getMoney()) {
												System.out.println("Nqmate dostatuchno pari v smetkata si!");
											}
											else {
												card.setMoney(card.getMoney() - sum);
												System.out.println("Chestito kupihte uredite! Shte poluchite suobshtenie v denq na dostavka!");
												Delivery delivery = new Delivery (user, shopingCart);
												try {
													t.addDelivery(delivery);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												sum = 0;
												shopingCart.clear();
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
								break;
							case 2:
								boolean flag9 = true;
								kind = Kind.COMPUTER;
								currentList = t.getProductList(category, kind);
								while (flag9) {
									
									currentList.forEach(product -> System.out.println(product));
									System.out.println();
									System.out.println("Natisnete 1 za sortirane po cena vuv vuzhodqsht red");
									System.out.println("Natisnete 2 za sortirane po cena v nizhodqsht red");
									System.out.println("Natisnete 3 za sortirane po azbuchen red na modela");
									System.out.println("Natisnete 4 za filtrirane po maximalna cena");
									System.out.println("Natisnete 5 za filtrirane po maximalna cena");
									System.out.println("Natisnete 6 za da se vurnete v predishnoto menu");
									System.out.println("Natisnete 7 za da dobavqne na ured v kolichkata");
									System.out.println("Natisnete 8 za pregled na kolichkata vi");
									System.out.println("Natisnete 9 za kupuvane na uredite v kolichkata vi");
									System.out.println("Natisnete 0 za izhod ot saita");
									int input25 = sc.nextInt();
									
									switch (input25) {
									
									case 1:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p1.getPrice() - (int)p2.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 2:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p2.getPrice() - (int)p1.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 3:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> p1.getModel().compareTo(p2.getModel()))
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 4:
										System.out.println("Molq vuvedete maximalna cena:");
										int input26 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() < input26).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() < input26)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 5:
										System.out.println("Molq vuvedete minimalna cena:");
										int input27 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() > input27).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() > input27)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 6:
										kind = null;
										flag9 = false;
										break;
									case 7:
										System.out.println("Molq vuvedete ID na ureda:");
										int input28 = sc.nextInt();
										if(!t.containsProductID(category, kind, input28)) {
											System.out.println("Greshno ID!");
										}
										else {
											if (!t.hasProductInStock(category, kind, input28)) {
												System.out.println("Ureda ne e nalichen v momenta!");
												if (hasLoggedIn) {
													System.out.println("Shte poluchite suobshtenie kogato zaredime broiki!");
													Request request = new Request(user, t.getProduct(category, kind, input28));
													try {
														t.addRequest(request);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
											}
											else {
												shopingCart.add(t.getProduct(category, kind, input28));
											}
										}
										break;
									case 8:
										if(shopingCart.isEmpty()) {
											System.out.println("Kolichkata vi e prazna!");
										}
										else {
											shopingCart.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 9:
										if (!hasLoggedIn) {
											System.out.println("Ne ste vleznali v profila si!");
										}
										else {
											System.out.println("Vuvedete nomer na kreditna karta:");
											String input29 = sc.next();
											CreditCard card = new CreditCard(input29);
											int sum = 0;
											for (Product p1 : shopingCart) {
												sum += p1.getPrice();
											}
											if (sum > card.getMoney()) {
												System.out.println("Nqmate dostatuchno pari v smetkata si!");
											}
											else {
												card.setMoney(card.getMoney() - sum);
												System.out.println("Chestito kupihte uredite! Shte poluchite suobshtenie v denq na dostavka!");
												Delivery delivery = new Delivery (user, shopingCart);
												try {
													t.addDelivery(delivery);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												sum = 0;
												shopingCart.clear();
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
								break;
							case 3:
								boolean flag10 = true;
								kind = Kind.MONITOR;
								currentList = t.getProductList(category, kind);
								while (flag10) {
									
									currentList.forEach(product -> System.out.println(product));
									System.out.println();
									System.out.println("Natisnete 1 za sortirane po cena vuv vuzhodqsht red");
									System.out.println("Natisnete 2 za sortirane po cena v nizhodqsht red");
									System.out.println("Natisnete 3 za sortirane po azbuchen red na modela");
									System.out.println("Natisnete 4 za filtrirane po maximalna cena");
									System.out.println("Natisnete 5 za filtrirane po maximalna cena");
									System.out.println("Natisnete 6 za da se vurnete v predishnoto menu");
									System.out.println("Natisnete 7 za da dobavqne na ured v kolichkata");
									System.out.println("Natisnete 8 za pregled na kolichkata vi");
									System.out.println("Natisnete 9 za kupuvane na uredite v kolichkata vi");
									System.out.println("Natisnete 0 za izhod ot saita");
									int input30 = sc.nextInt();
									
									switch (input30) {
									
									case 1:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p1.getPrice() - (int)p2.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 2:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p2.getPrice() - (int)p1.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 3:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> p1.getModel().compareTo(p2.getModel()))
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 4:
										System.out.println("Molq vuvedete maximalna cena:");
										int input31 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() < input31).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() < input31)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 5:
										System.out.println("Molq vuvedete minimalna cena:");
										int input32 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() > input32).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() > input32)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 6:
										kind = null;
										flag10 = false;
										break;
									case 7:
										System.out.println("Molq vuvedete ID na ureda:");
										int input33 = sc.nextInt();
										if(!t.containsProductID(category, kind, input33)) {
											System.out.println("Greshno ID!");
										}
										else {
											if (!t.hasProductInStock(category, kind, input33)) {
												System.out.println("Ureda ne e nalichen v momenta!");
												if (hasLoggedIn) {
													System.out.println("Shte poluchite suobshtenie kogato zaredime broiki!");
													Request request = new Request(user, t.getProduct(category, kind, input33));
													try {
														t.addRequest(request);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
											}
											else {
												shopingCart.add(t.getProduct(category, kind, input33));
											}
										}
										break;
									case 8:
										if(shopingCart.isEmpty()) {
											System.out.println("Kolichkata vi e prazna!");
										}
										else {
											shopingCart.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 9:
										if (!hasLoggedIn) {
											System.out.println("Ne ste vleznali v profila si!");
										}
										else {
											System.out.println("Vuvedete nomer na kreditna karta:");
											String input34 = sc.next();
											CreditCard card = new CreditCard(input34);
											int sum = 0;
											for (Product p1 : shopingCart) {
												sum += p1.getPrice();
											}
											if (sum > card.getMoney()) {
												System.out.println("Nqmate dostatuchno pari v smetkata si!");
											}
											else {
												card.setMoney(card.getMoney() - sum);
												System.out.println("Chestito kupihte uredite! Shte poluchite suobshtenie v denq na dostavka!");
												Delivery delivery = new Delivery (user, shopingCart);
												try {
													t.addDelivery(delivery);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												sum = 0;
												shopingCart.clear();
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
								break;
							case 4:
								category = null;
								flag7 = false;
								break;
							case 0:
								return;					
							default:
								System.out.println("Bad input!");
								break;
							}
					
						}
	
					break;
					case 3:
						boolean flag11 = true;
						while (flag11) {
							category = Category.PHONES_TABLETS;
							System.out.println("Natisnete 1 za razglejdane na Telefoni");
							System.out.println("Natisnete 2 za razglejdane na Smart Chasovnici");
							System.out.println("Natisnete 3 za razglejdane na Tableti");
							System.out.println("Natisnete 4 za da se vurnete v predishnoto menu");
							System.out.println("Natisnete 0 za izhod ot saita");
							int input35 = sc.nextInt();
							
							switch (input35) {
							
							case 1:
								boolean flag12 = true;
								kind = Kind.PHONE;
								currentList = t.getProductList(category, kind);
								while (flag12) {
									
									currentList.forEach(product -> System.out.println(product));
									System.out.println();
									System.out.println("Natisnete 1 za sortirane po cena vuv vuzhodqsht red");
									System.out.println("Natisnete 2 za sortirane po cena v nizhodqsht red");
									System.out.println("Natisnete 3 za sortirane po azbuchen red na modela");
									System.out.println("Natisnete 4 za filtrirane po maximalna cena");
									System.out.println("Natisnete 5 za filtrirane po maximalna cena");
									System.out.println("Natisnete 6 za da se vurnete v predishnoto menu");
									System.out.println("Natisnete 7 za da dobavqne na ured v kolichkata");
									System.out.println("Natisnete 8 za pregled na kolichkata vi");
									System.out.println("Natisnete 9 za kupuvane na uredite v kolichkata vi");
									System.out.println("Natisnete 0 za izhod ot saita");
									int input36 = sc.nextInt();
									
									switch (input36) {
									
									case 1:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p1.getPrice() - (int)p2.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 2:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p2.getPrice() - (int)p1.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 3:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> p1.getModel().compareTo(p2.getModel()))
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 4:
										System.out.println("Molq vuvedete maximalna cena:");
										int input37 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() < input37).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() < input37)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 5:
										System.out.println("Molq vuvedete minimalna cena:");
										int input38 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() > input38).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() > input38)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 6:
										kind = null;
										flag12 = false;
										break;
									case 7:
										System.out.println("Molq vuvedete ID na ureda:");
										int input39 = sc.nextInt();
										if(!t.containsProductID(category, kind, input39)) {
											System.out.println("Greshno ID!");
										}
										else {
											if (!t.hasProductInStock(category, kind, input39)) {
												System.out.println("Ureda ne e nalichen v momenta!");
												if (hasLoggedIn) {
													System.out.println("Shte poluchite suobshtenie kogato zaredime broiki!");
													Request request = new Request(user, t.getProduct(category, kind, input39));
													try {
														t.addRequest(request);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
											}
											else {
												shopingCart.add(t.getProduct(category, kind, input39));
											}
										}
										break;
									case 8:
										if(shopingCart.isEmpty()) {
											System.out.println("Kolichkata vi e prazna!");
										}
										else {
											shopingCart.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 9:
										if (!hasLoggedIn) {
											System.out.println("Ne ste vleznali v profila si!");
										}
										else {
											System.out.println("Vuvedete nomer na kreditna karta:");
											String input40 = sc.next();
											CreditCard card = new CreditCard(input40);
											int sum = 0;
											for (Product p1 : shopingCart) {
												sum += p1.getPrice();
											}
											if (sum > card.getMoney()) {
												System.out.println("Nqmate dostatuchno pari v smetkata si!");
											}
											else {
												card.setMoney(card.getMoney() - sum);
												System.out.println("Chestito kupihte uredite! Shte poluchite suobshtenie v denq na dostavka!");
												Delivery delivery = new Delivery (user, shopingCart);
												try {
													t.addDelivery(delivery);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												sum = 0;
												shopingCart.clear();
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
								break;
							case 2:
								boolean flag13 = true;
								kind = Kind.SMARTWATCH;
								currentList = t.getProductList(category, kind);
								while (flag13) {
									
									currentList.forEach(product -> System.out.println(product));
									System.out.println();
									System.out.println("Natisnete 1 za sortirane po cena vuv vuzhodqsht red");
									System.out.println("Natisnete 2 za sortirane po cena v nizhodqsht red");
									System.out.println("Natisnete 3 za sortirane po azbuchen red na modela");
									System.out.println("Natisnete 4 za filtrirane po maximalna cena");
									System.out.println("Natisnete 5 za filtrirane po maximalna cena");
									System.out.println("Natisnete 6 za da se vurnete v predishnoto menu");
									System.out.println("Natisnete 7 za da dobavqne na ured v kolichkata");
									System.out.println("Natisnete 8 za pregled na kolichkata vi");
									System.out.println("Natisnete 9 za kupuvane na uredite v kolichkata vi");
									System.out.println("Natisnete 0 za izhod ot saita");
									int input41 = sc.nextInt();
									
									switch (input41) {
									
									case 1:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p1.getPrice() - (int)p2.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 2:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p2.getPrice() - (int)p1.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 3:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> p1.getModel().compareTo(p2.getModel()))
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 4:
										System.out.println("Molq vuvedete maximalna cena:");
										int input42 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() < input42).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() < input42)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 5:
										System.out.println("Molq vuvedete minimalna cena:");
										int input43 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() > input43).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() > input43)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 6:
										kind = null;
										flag13 = false;
										break;
									case 7:
										System.out.println("Molq vuvedete ID na ureda:");
										int input44 = sc.nextInt();
										if(!t.containsProductID(category, kind, input44)) {
											System.out.println("Greshno ID!");
										}
										else {
											if (!t.hasProductInStock(category, kind, input44)) {
												System.out.println("Ureda ne e nalichen v momenta!");
												if (hasLoggedIn) {
													System.out.println("Shte poluchite suobshtenie kogato zaredime broiki!");
													Request request = new Request(user, t.getProduct(category, kind, input44));
													try {
														t.addRequest(request);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
											}
											else {
												shopingCart.add(t.getProduct(category, kind, input44));
											}
										}
										break;
									case 8:
										if(shopingCart.isEmpty()) {
											System.out.println("Kolichkata vi e prazna!");
										}
										else {
											shopingCart.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 9:
										if (!hasLoggedIn) {
											System.out.println("Ne ste vleznali v profila si!");
										}
										else {
											System.out.println("Vuvedete nomer na kreditna karta:");
											String input45 = sc.next();
											CreditCard card = new CreditCard(input45);
											int sum = 0;
											for (Product p1 : shopingCart) {
												sum += p1.getPrice();
											}
											if (sum > card.getMoney()) {
												System.out.println("Nqmate dostatuchno pari v smetkata si!");
											}
											else {
												card.setMoney(card.getMoney() - sum);
												System.out.println("Chestito kupihte uredite! Shte poluchite suobshtenie v denq na dostavka!");
												Delivery delivery = new Delivery (user, shopingCart);
												try {
													t.addDelivery(delivery);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												sum = 0;
												shopingCart.clear();
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
								break;
							case 3:
								boolean flag14 = true;
								kind = Kind.TABLET;
								currentList = t.getProductList(category, kind);
								while (flag14) {
									
									currentList.forEach(product -> System.out.println(product));
									System.out.println();
									System.out.println("Natisnete 1 za sortirane po cena vuv vuzhodqsht red");
									System.out.println("Natisnete 2 za sortirane po cena v nizhodqsht red");
									System.out.println("Natisnete 3 za sortirane po azbuchen red na modela");
									System.out.println("Natisnete 4 za filtrirane po maximalna cena");
									System.out.println("Natisnete 5 za filtrirane po maximalna cena");
									System.out.println("Natisnete 6 za da se vurnete v predishnoto menu");
									System.out.println("Natisnete 7 za da dobavqne na ured v kolichkata");
									System.out.println("Natisnete 8 za pregled na kolichkata vi");
									System.out.println("Natisnete 9 za kupuvane na uredite v kolichkata vi");
									System.out.println("Natisnete 0 za izhod ot saita");
									int input46 = sc.nextInt();
									
									switch (input46) {
									
									case 1:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p1.getPrice() - (int)p2.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 2:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p2.getPrice() - (int)p1.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 3:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> p1.getModel().compareTo(p2.getModel()))
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 4:
										System.out.println("Molq vuvedete maximalna cena:");
										int input47 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() < input47).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() < input47)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 5:
										System.out.println("Molq vuvedete minimalna cena:");
										int input48 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() > input48).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() > input48)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 6:
										kind = null;
										flag14 = false;
										break;
									case 7:
										System.out.println("Molq vuvedete ID na ureda:");
										int input49 = sc.nextInt();
										if(!t.containsProductID(category, kind, input49)) {
											System.out.println("Greshno ID!");
										}
										else {
											if (!t.hasProductInStock(category, kind, input49)) {
												System.out.println("Ureda ne e nalichen v momenta!");
												if (hasLoggedIn) {
													System.out.println("Shte poluchite suobshtenie kogato zaredime broiki!");
													Request request = new Request(user, t.getProduct(category, kind, input49));
													try {
														t.addRequest(request);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
											}
											else {
												shopingCart.add(t.getProduct(category, kind, input49));
											}
										}
										break;
									case 8:
										if(shopingCart.isEmpty()) {
											System.out.println("Kolichkata vi e prazna!");
										}
										else {
											shopingCart.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 9:
										if (!hasLoggedIn) {
											System.out.println("Ne ste vleznali v profila si!");
										}
										else {
											System.out.println("Vuvedete nomer na kreditna karta:");
											String input50 = sc.next();
											CreditCard card = new CreditCard(input50);
											int sum = 0;
											for (Product p1 : shopingCart) {
												sum += p1.getPrice();
											}
											if (sum > card.getMoney()) {
												System.out.println("Nqmate dostatuchno pari v smetkata si!");
											}
											else {
												card.setMoney(card.getMoney() - sum);
												System.out.println("Chestito kupihte uredite! Shte poluchite suobshtenie v denq na dostavka!");
												Delivery delivery = new Delivery (user, shopingCart);
												try {
													t.addDelivery(delivery);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												sum = 0;
												shopingCart.clear();
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
								break;
							case 4:
								category = null;
								flag11 = false;
								break;
							case 0:
								return;					
							default:
								System.out.println("Bad input!");
								break;
							}
					
						}
				
					break;
					case 4:
						boolean flag15 = true;
						while (flag15) {
							category = Category.ELECTRICAL_APPLIANCE;
							System.out.println("Natisnete 1 za razglejdane na Klimatici");
							System.out.println("Natisnete 2 za razglejdane na Miqlni Mashini");
							System.out.println("Natisnete 3 za razglejdane na Hladilnici");
							System.out.println("Natisnete 4 za da se vurnete v predishnoto menu");
							System.out.println("Natisnete 5 za razglejdane na Miqlni Mashini");
							System.out.println("Natisnete 6 za razglejdane na Mikrovulnovi Pechki");
							System.out.println("Natisnete 0 za izhod ot saita");
							int input51 = sc.nextInt();
							
							switch (input51) {
							
							case 1:
								boolean flag16 = true;
								kind = Kind.AIRCONDITIONER;
								currentList = t.getProductList(category, kind);
								while (flag16) {
									
									currentList.forEach(product -> System.out.println(product));
									System.out.println();
									System.out.println("Natisnete 1 za sortirane po cena vuv vuzhodqsht red");
									System.out.println("Natisnete 2 za sortirane po cena v nizhodqsht red");
									System.out.println("Natisnete 3 za sortirane po azbuchen red na modela");
									System.out.println("Natisnete 4 za filtrirane po maximalna cena");
									System.out.println("Natisnete 5 za filtrirane po maximalna cena");
									System.out.println("Natisnete 6 za da se vurnete v predishnoto menu");
									System.out.println("Natisnete 7 za da dobavqne na ured v kolichkata");
									System.out.println("Natisnete 8 za pregled na kolichkata vi");
									System.out.println("Natisnete 9 za kupuvane na uredite v kolichkata vi");
									System.out.println("Natisnete 0 za izhod ot saita");
									int input52 = sc.nextInt();
									
									switch (input52) {
									
									case 1:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p1.getPrice() - (int)p2.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 2:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p2.getPrice() - (int)p1.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 3:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> p1.getModel().compareTo(p2.getModel()))
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 4:
										System.out.println("Molq vuvedete maximalna cena:");
										int input53 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() < input53).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() < input53)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 5:
										System.out.println("Molq vuvedete minimalna cena:");
										int input54 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() > input54).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() > input54)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 6:
										kind = null;
										flag16 = false;
										break;
									case 7:
										System.out.println("Molq vuvedete ID na ureda:");
										int input55 = sc.nextInt();
										if(!t.containsProductID(category, kind, input55)) {
											System.out.println("Greshno ID!");
										}
										else {
											if (!t.hasProductInStock(category, kind, input55)) {
												System.out.println("Ureda ne e nalichen v momenta!");
												if (hasLoggedIn) {
													System.out.println("Shte poluchite suobshtenie kogato zaredime broiki!");
													Request request = new Request(user, t.getProduct(category, kind, input55));
													try {
														t.addRequest(request);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
											}
											else {
												shopingCart.add(t.getProduct(category, kind, input55));
											}
										}
										break;
									case 8:
										if(shopingCart.isEmpty()) {
											System.out.println("Kolichkata vi e prazna!");
										}
										else {
											shopingCart.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 9:
										if (!hasLoggedIn) {
											System.out.println("Ne ste vleznali v profila si!");
										}
										else {
											System.out.println("Vuvedete nomer na kreditna karta:");
											String input56 = sc.next();
											CreditCard card = new CreditCard(input56);
											int sum = 0;
											for (Product p1 : shopingCart) {
												sum += p1.getPrice();
											}
											if (sum > card.getMoney()) {
												System.out.println("Nqmate dostatuchno pari v smetkata si!");
											}
											else {
												card.setMoney(card.getMoney() - sum);
												System.out.println("Chestito kupihte uredite! Shte poluchite suobshtenie v denq na dostavka!");
												Delivery delivery = new Delivery (user, shopingCart);
												try {
													t.addDelivery(delivery);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												sum = 0;
												shopingCart.clear();
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
								break;
							case 2:
								boolean flag17 = true;
								kind = Kind.WASHINGMACHINE;
								currentList = t.getProductList(category, kind);
								while (flag17) {
									
									currentList.forEach(product -> System.out.println(product));
									System.out.println();
									System.out.println("Natisnete 1 za sortirane po cena vuv vuzhodqsht red");
									System.out.println("Natisnete 2 za sortirane po cena v nizhodqsht red");
									System.out.println("Natisnete 3 za sortirane po azbuchen red na modela");
									System.out.println("Natisnete 4 za filtrirane po maximalna cena");
									System.out.println("Natisnete 5 za filtrirane po maximalna cena");
									System.out.println("Natisnete 6 za da se vurnete v predishnoto menu");
									System.out.println("Natisnete 7 za da dobavqne na ured v kolichkata");
									System.out.println("Natisnete 8 za pregled na kolichkata vi");
									System.out.println("Natisnete 9 za kupuvane na uredite v kolichkata vi");
									System.out.println("Natisnete 0 za izhod ot saita");
									int input57 = sc.nextInt();
									
									switch (input57) {
									
									case 1:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p1.getPrice() - (int)p2.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 2:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p2.getPrice() - (int)p1.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 3:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> p1.getModel().compareTo(p2.getModel()))
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 4:
										System.out.println("Molq vuvedete maximalna cena:");
										int input58 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() < input58).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() < input58)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 5:
										System.out.println("Molq vuvedete minimalna cena:");
										int input59 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() > input59).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() > input59)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 6:
										kind = null;
										flag17 = false;
										break;
									case 7:
										System.out.println("Molq vuvedete ID na ureda:");
										int input60 = sc.nextInt();
										if(!t.containsProductID(category, kind, input60)) {
											System.out.println("Greshno ID!");
										}
										else {
											if (!t.hasProductInStock(category, kind, input60)) {
												System.out.println("Ureda ne e nalichen v momenta!");
												if (hasLoggedIn) {
													System.out.println("Shte poluchite suobshtenie kogato zaredime broiki!");
													Request request = new Request(user, t.getProduct(category, kind, input60));
													try {
														t.addRequest(request);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
											}
											else {
												shopingCart.add(t.getProduct(category, kind, input60));
											}
										}
										break;
									case 8:
										if(shopingCart.isEmpty()) {
											System.out.println("Kolichkata vi e prazna!");
										}
										else {
											shopingCart.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 9:
										if (!hasLoggedIn) {
											System.out.println("Ne ste vleznali v profila si!");
										}
										else {
											System.out.println("Vuvedete nomer na kreditna karta:");
											String input61 = sc.next();
											CreditCard card = new CreditCard(input61);
											int sum = 0;
											for (Product p1 : shopingCart) {
												sum += p1.getPrice();
											}
											if (sum > card.getMoney()) {
												System.out.println("Nqmate dostatuchno pari v smetkata si!");
											}
											else {
												card.setMoney(card.getMoney() - sum);
												System.out.println("Chestito kupihte uredite! Shte poluchite suobshtenie v denq na dostavka!");
												Delivery delivery = new Delivery (user, shopingCart);
												try {
													t.addDelivery(delivery);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												sum = 0;
												shopingCart.clear();
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
								break;
							case 3:
								boolean flag18 = true;
								kind = Kind.FRIDGE;
								currentList = t.getProductList(category, kind);
								while (flag18) {
									
									currentList.forEach(product -> System.out.println(product));
									System.out.println();
									System.out.println("Natisnete 1 za sortirane po cena vuv vuzhodqsht red");
									System.out.println("Natisnete 2 za sortirane po cena v nizhodqsht red");
									System.out.println("Natisnete 3 za sortirane po azbuchen red na modela");
									System.out.println("Natisnete 4 za filtrirane po maximalna cena");
									System.out.println("Natisnete 5 za filtrirane po maximalna cena");
									System.out.println("Natisnete 6 za da se vurnete v predishnoto menu");
									System.out.println("Natisnete 7 za da dobavqne na ured v kolichkata");
									System.out.println("Natisnete 8 za pregled na kolichkata vi");
									System.out.println("Natisnete 9 za kupuvane na uredite v kolichkata vi");
									System.out.println("Natisnete 0 za izhod ot saita");
									int input62 = sc.nextInt();
									
									switch (input62) {
									
									case 1:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p1.getPrice() - (int)p2.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 2:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p2.getPrice() - (int)p1.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 3:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> p1.getModel().compareTo(p2.getModel()))
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 4:
										System.out.println("Molq vuvedete maximalna cena:");
										int input63 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() < input63).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() < input63)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 5:
										System.out.println("Molq vuvedete minimalna cena:");
										int input64 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() > input64).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() > input64)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 6:
										kind = null;
										flag18 = false;
										break;
									case 7:
										System.out.println("Molq vuvedete ID na ureda:");
										int input65 = sc.nextInt();
										if(!t.containsProductID(category, kind, input65)) {
											System.out.println("Greshno ID!");
										}
										else {
											if (!t.hasProductInStock(category, kind, input65)) {
												System.out.println("Ureda ne e nalichen v momenta!");
												if (hasLoggedIn) {
													System.out.println("Shte poluchite suobshtenie kogato zaredime broiki!");
													Request request = new Request(user, t.getProduct(category, kind, input65));
													try {
														t.addRequest(request);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
											}
											else {
												shopingCart.add(t.getProduct(category, kind, input65));
											}
										}
										break;
									case 8:
										if(shopingCart.isEmpty()) {
											System.out.println("Kolichkata vi e prazna!");
										}
										else {
											shopingCart.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 9:
										if (!hasLoggedIn) {
											System.out.println("Ne ste vleznali v profila si!");
										}
										else {
											System.out.println("Vuvedete nomer na kreditna karta:");
											String input66 = sc.next();
											CreditCard card = new CreditCard(input66);
											int sum = 0;
											for (Product p1 : shopingCart) {
												sum += p1.getPrice();
											}
											if (sum > card.getMoney()) {
												System.out.println("Nqmate dostatuchno pari v smetkata si!");
											}
											else {
												card.setMoney(card.getMoney() - sum);
												System.out.println("Chestito kupihte uredite! Shte poluchite suobshtenie v denq na dostavka!");
												Delivery delivery = new Delivery (user, shopingCart);
												try {
													t.addDelivery(delivery);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												sum = 0;
												shopingCart.clear();
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
								break;
							case 4:
								category = null;
								flag15 = false;
								break;
							case 5:
								boolean flag19 = true;
								kind = Kind.MICROWAVE;
								currentList = t.getProductList(category, kind);
								while (flag19) {
									
									currentList.forEach(product -> System.out.println(product));
									System.out.println();
									System.out.println("Natisnete 1 za sortirane po cena vuv vuzhodqsht red");
									System.out.println("Natisnete 2 za sortirane po cena v nizhodqsht red");
									System.out.println("Natisnete 3 za sortirane po azbuchen red na modela");
									System.out.println("Natisnete 4 za filtrirane po maximalna cena");
									System.out.println("Natisnete 5 za filtrirane po maximalna cena");
									System.out.println("Natisnete 6 za da se vurnete v predishnoto menu");
									System.out.println("Natisnete 7 za da dobavqne na ured v kolichkata");
									System.out.println("Natisnete 8 za pregled na kolichkata vi");
									System.out.println("Natisnete 9 za kupuvane na uredite v kolichkata vi");
									System.out.println("Natisnete 0 za izhod ot saita");
									int input67 = sc.nextInt();
									
									switch (input67) {
									
									case 1:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p1.getPrice() - (int)p2.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 2:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p2.getPrice() - (int)p1.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 3:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> p1.getModel().compareTo(p2.getModel()))
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 4:
										System.out.println("Molq vuvedete maximalna cena:");
										int input68 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() < input68).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() < input68)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 5:
										System.out.println("Molq vuvedete minimalna cena:");
										int input69 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() > input69).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() > input69)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 6:
										kind = null;
										flag19 = false;
										break;
									case 7:
										System.out.println("Molq vuvedete ID na ureda:");
										int input70 = sc.nextInt();
										if(!t.containsProductID(category, kind, input70)) {
											System.out.println("Greshno ID!");
										}
										else {
											if (!t.hasProductInStock(category, kind, input70)) {
												System.out.println("Ureda ne e nalichen v momenta!");
												if (hasLoggedIn) {
													System.out.println("Shte poluchite suobshtenie kogato zaredime broiki!");
													Request request = new Request(user, t.getProduct(category, kind, input70));
													try {
														t.addRequest(request);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
											}
											else {
												shopingCart.add(t.getProduct(category, kind, input70));
											}
										}
										break;
									case 8:
										if(shopingCart.isEmpty()) {
											System.out.println("Kolichkata vi e prazna!");
										}
										else {
											shopingCart.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 9:
										if (!hasLoggedIn) {
											System.out.println("Ne ste vleznali v profila si!");
										}
										else {
											System.out.println("Vuvedete nomer na kreditna karta:");
											String input71 = sc.next();
											CreditCard card = new CreditCard(input71);
											int sum = 0;
											for (Product p1 : shopingCart) {
												sum += p1.getPrice();
											}
											if (sum > card.getMoney()) {
												System.out.println("Nqmate dostatuchno pari v smetkata si!");
											}
											else {
												card.setMoney(card.getMoney() - sum);
												System.out.println("Chestito kupihte uredite! Shte poluchite suobshtenie v denq na dostavka!");
												Delivery delivery = new Delivery (user, shopingCart);
												try {
													t.addDelivery(delivery);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												sum = 0;
												shopingCart.clear();
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
								break;
							case 6:
								boolean flag20 = true;
								kind = Kind.VACUUMCLEANER;
								currentList = t.getProductList(category, kind);
								while (flag20) {
								
									currentList.forEach(product -> System.out.println(product));
									System.out.println();
									System.out.println("Natisnete 1 za sortirane po cena vuv vuzhodqsht red");
									System.out.println("Natisnete 2 za sortirane po cena v nizhodqsht red");
									System.out.println("Natisnete 3 za sortirane po azbuchen red na modela");
									System.out.println("Natisnete 4 za filtrirane po maximalna cena");
									System.out.println("Natisnete 5 za filtrirane po maximalna cena");
									System.out.println("Natisnete 6 za da se vurnete v predishnoto menu");
									System.out.println("Natisnete 7 za da dobavqne na ured v kolichkata");
									System.out.println("Natisnete 8 za pregled na kolichkata vi");
									System.out.println("Natisnete 9 za kupuvane na uredite v kolichkata vi");
									System.out.println("Natisnete 0 za izhod ot saita");
									int input72 = sc.nextInt();
									
									switch (input72) {
									
									case 1:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p1.getPrice() - (int)p2.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 2:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p2.getPrice() - (int)p1.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 3:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> p1.getModel().compareTo(p2.getModel()))
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 4:
										System.out.println("Molq vuvedete maximalna cena:");
										int input73 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() < input73).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() < input73)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 5:
										System.out.println("Molq vuvedete minimalna cena:");
										int input74 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() > input74).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() > input74)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 6:
										kind = null;
										flag20 = false;
										break;
									case 7:
										System.out.println("Molq vuvedete ID na ureda:");
										int input75 = sc.nextInt();
										if(!t.containsProductID(category, kind, input75)) {
											System.out.println("Greshno ID!");
										}
										else {
											if (!t.hasProductInStock(category, kind, input75)) {
												System.out.println("Ureda ne e nalichen v momenta!");
												if (hasLoggedIn) {
													System.out.println("Shte poluchite suobshtenie kogato zaredime broiki!");
													Request request = new Request(user, t.getProduct(category, kind, input75));
													try {
														t.addRequest(request);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
											}
											else {
												shopingCart.add(t.getProduct(category, kind, input75));
											}
										}
										break;
									case 8:
										if(shopingCart.isEmpty()) {
											System.out.println("Kolichkata vi e prazna!");
										}
										else {
											shopingCart.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 9:
										if (!hasLoggedIn) {
											System.out.println("Ne ste vleznali v profila si!");
										}
										else {
											System.out.println("Vuvedete nomer na kreditna karta:");
											String input76 = sc.next();
											CreditCard card = new CreditCard(input76);
											int sum = 0;
											for (Product p1 : shopingCart) {
												sum += p1.getPrice();
											}
											if (sum > card.getMoney()) {
												System.out.println("Nqmate dostatuchno pari v smetkata si!");
											}
											else {
												card.setMoney(card.getMoney() - sum);
												System.out.println("Chestito kupihte uredite! Shte poluchite suobshtenie v denq na dostavka!");
												Delivery delivery = new Delivery (user, shopingCart);
												try {
													t.addDelivery(delivery);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												sum = 0;
												shopingCart.clear();
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
								break;
							case 0:
								return;					
							default:
								System.out.println("Bad input!");
								break;
							}
					
						}
		
					break;
					case 5:
						boolean flag21 = true;
						while (flag21) {
							category = Category.PHOTO_VIDEO;
							System.out.println("Natisnete 1 za razglejdane na Kameri");
							System.out.println("Natisnete 2 za da se vurnete v predishnoto menu");
							System.out.println("Natisnete 0 za izhod ot saita");
							int input77 = sc.nextInt();
							
							switch (input77) {
							
							case 1:
								boolean flag22 = true;
								kind = Kind.CAMERA;
								currentList = t.getProductList(category, kind);
								while (flag22) {
									
									currentList.forEach(product -> System.out.println(product));
									System.out.println();
									System.out.println("Natisnete 1 za sortirane po cena vuv vuzhodqsht red");
									System.out.println("Natisnete 2 za sortirane po cena v nizhodqsht red");
									System.out.println("Natisnete 3 za sortirane po azbuchen red na modela");
									System.out.println("Natisnete 4 za filtrirane po maximalna cena");
									System.out.println("Natisnete 5 za filtrirane po maximalna cena");
									System.out.println("Natisnete 6 za da se vurnete v predishnoto menu");
									System.out.println("Natisnete 7 za da dobavqne na ured v kolichkata");
									System.out.println("Natisnete 8 za pregled na kolichkata vi");
									System.out.println("Natisnete 9 za kupuvane na uredite v kolichkata vi");
									System.out.println("Natisnete 0 za izhod ot saita");
									int input78 = sc.nextInt();
									
									switch (input78) {
									
									case 1:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p1.getPrice() - (int)p2.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 2:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> (int)p2.getPrice() - (int)p1.getPrice())
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 3:
										currentList = currentList.stream()
										.sorted( (p1,p2) -> p1.getModel().compareTo(p2.getModel()))
										.collect(Collectors.toCollection(LinkedList::new));
										
										break;
									case 4:
										System.out.println("Molq vuvedete maximalna cena:");
										int input79 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() < input79).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() < input79)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 5:
										System.out.println("Molq vuvedete minimalna cena:");
										int input80 = sc.nextInt();
										if (currentList.stream().filter(product -> product.getPrice() > input80).count() == 0) {
											System.out.println("Nqma uredi koito otgovarqt na turseneto");
										}
										else {
											currentList = currentList.stream().filter(product -> product.getPrice() > input80)
													.collect(Collectors.toCollection(LinkedList::new));
											currentList.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 6:
										kind = null;
										flag22 = false;
										break;
									case 7:
										System.out.println("Molq vuvedete ID na ureda:");
										int input81 = sc.nextInt();
										if(!t.containsProductID(category, kind, input81)) {
											System.out.println("Greshno ID!");
										}
										else {
											if (!t.hasProductInStock(category, kind, input81)) {
												System.out.println("Ureda ne e nalichen v momenta!");
												if (hasLoggedIn) {
													System.out.println("Shte poluchite suobshtenie kogato zaredime broiki!");
													Request request = new Request(user, t.getProduct(category, kind, input81));
													try {
														t.addRequest(request);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
											}
											else {
												shopingCart.add(t.getProduct(category, kind, input81));
											}
										}
										break;
									case 8:
										if(shopingCart.isEmpty()) {
											System.out.println("Kolichkata vi e prazna!");
										}
										else {
											shopingCart.forEach(product -> System.out.println(product));
											System.out.println();
										}
										break;
									case 9:
										if (!hasLoggedIn) {
											System.out.println("Ne ste vleznali v profila si!");
										}
										else {
											System.out.println("Vuvedete nomer na kreditna karta:");
											String input82 = sc.next();
											CreditCard card = new CreditCard(input82);
											int sum = 0;
											for (Product p1 : shopingCart) {
												sum += p1.getPrice();
											}
											if (sum > card.getMoney()) {
												System.out.println("Nqmate dostatuchno pari v smetkata si!");
											}
											else {
												card.setMoney(card.getMoney() - sum);
												System.out.println("Chestito kupihte uredite! Shte poluchite suobshtenie v denq na dostavka!");
												Delivery delivery = new Delivery (user, shopingCart);
												try {
													t.addDelivery(delivery);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												sum = 0;
												shopingCart.clear();
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
								break;
							case 2:
								category = null;
								flag21 = false;
								break;
							case 0:
								return;					
							default:
								System.out.println("Bad input!");
								break;
							}
					
						}		
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
