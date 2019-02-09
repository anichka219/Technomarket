
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.decimal4j.util.DoubleRounder;

import brands.AirConditionerBrand;
import brands.AudioSystemBrand;
import brands.CameraBrand;
import brands.ComputerBrand;
import brands.FridgeBrand;
import brands.HomeCinemaBrand;
import brands.IBrand;
import brands.LaptopBrand;
import brands.MicrowaveBrand;
import brands.MonitorBrand;
import brands.PhoneBrand;
import brands.SmartWatchBrand;
import brands.TabletBrand;
import brands.TelevisionBrand;
import brands.VacuumCleanerBrand;
import brands.WashingMachineBrand;
import products.Category;
import products.Kind;
import products.Product;
import users.User;

public class Technomarket {
	private Map<Category, Map<Kind,Map<Product,Integer>>> products;
	private Set<User> users;
	private static Technomarket technomarket=null;
	
	private Technomarket() {
		this.products=new HashMap();
		this.users=new HashSet<User>();
	}
	
	public static Technomarket getInstance() {
		if(Technomarket.technomarket==null) {
			Technomarket.technomarket=new Technomarket();
		}
		return Technomarket.technomarket;
	}
	public Product getProduct(Category category,Kind kind) {

		if(category.equals(Category.TV_AUDIO)) {
			return Technomarket.getRandomTvAndAudio(kind);
		}
		if(category.equals(Category.CP_PERIPHERALS)) {
			return Technomarket.getRandomCpAndPeripherals(kind);
		}
		if(category.equals(Category.PHONES_TABLETS)) {
			return Technomarket.getRandomPhonesAndTablets(kind);
		}
		if(category.equals(Category.ELECTRICAL_APPLIANCE)) {
			return Technomarket.getRandomElectricalAppliance(kind);
		}
		return Technomarket.getRandomPhotoAndVideo(kind);
	}
	
	public static Product getRandomTvAndAudio(Kind kind) {
		
		IBrand brand;
		String model=kind+" "+(new Random().nextInt(900)+100)+" ";
		double price=DoubleRounder.round(179+9820*new Random().nextDouble(),2);
		
		if(kind.equals(Kind.TELEVISION)) {
			
			brand=TelevisionBrand.values()[new Random().nextInt(TelevisionBrand.values().length)];
			model+=brand;		
			
			return  new Product.Television(model,price,Product.getRandomColor(), (TelevisionBrand) brand);
		}
		if(kind.equals(Kind.HOMECINEMA)) {
			brand=HomeCinemaBrand.values()[new Random().nextInt(HomeCinemaBrand.values().length)];
			model+=brand;
			
			return new Product.HomeCinema(model,price,Product.getRandomColor(),(HomeCinemaBrand) brand);
		}
		
		brand=AudioSystemBrand.values()[new Random().nextInt(AudioSystemBrand.values().length)];
		model+=brand;
			
		return new Product.AudioSystem(model,price,Product.getRandomColor(),(AudioSystemBrand) brand);
	}
	public static Product getRandomCpAndPeripherals(Kind kind) {
		
		IBrand brand;
		String model=kind+" "+(new Random().nextInt(900)+100)+" ";
		double price=200+2000*new Random().nextDouble();
		
		if(kind.equals(Kind.LAPTOP)) {
			
			brand=LaptopBrand.values()[new Random().nextInt(LaptopBrand.values().length)];
			model+=brand;			
			
			return new Product.Laptop(model,price,Product.getRandomColor(),(LaptopBrand) brand);
		}
		if(kind.equals(Kind.COMPUTER)) {
			brand=ComputerBrand.values()[new Random().nextInt(ComputerBrand.values().length)];
			model+=brand;
			
			return new Product.Computer(model,price,Product.getRandomColor(),(ComputerBrand) brand);
		}
		
		brand=MonitorBrand.values()[new Random().nextInt(MonitorBrand.values().length)];
		model+=brand;
			
		return new Product.Monitor(model,price,Product.getRandomColor(),(MonitorBrand) brand);
		
	}
	public static Product getRandomPhonesAndTablets(Kind kind) {		

		IBrand brand;
		String model=kind+" "+(new Random().nextInt(900)+100)+" ";
		double price=200+2000*new Random().nextDouble();
		
		if(kind.equals(Kind.PHONE)) {	
			brand=PhoneBrand.values()[new Random().nextInt(PhoneBrand.values().length)];
			model+=brand;			
			
			return new Product.Phone(model,price,Product.getRandomColor(), (PhoneBrand) brand);
		}
		if(kind.equals(Kind.SMARTWATCH)) {
			brand=SmartWatchBrand.values()[new Random().nextInt(SmartWatchBrand.values().length)];
			model+=brand;
			
			return new Product.SmartWatch(model,price,Product.getRandomColor(), (SmartWatchBrand) brand);
		}
		
		brand=TabletBrand.values()[new Random().nextInt(TabletBrand.values().length)];
		model+=brand;
			
		return new Product.Tablet(model,price,Product.getRandomColor(), (TabletBrand) brand);
	}
	public static Product getRandomElectricalAppliance(Kind kind) {
		
		IBrand brand;
		String model=kind+" "+(new Random().nextInt(900)+100)+" ";
		double price=200+2000*new Random().nextDouble();
		
		if(kind.equals(Kind.AIRCONDITIONER)) {
			
			brand=AirConditionerBrand.values()[new Random().nextInt(AirConditionerBrand.values().length)];
			model+=brand;			
			
			return new Product.AirConditioner(model,price,Product.getRandomColor(), (AirConditionerBrand) brand);
		}
		if(kind.equals(Kind.FRIDGE)) {
			brand=FridgeBrand.values()[new Random().nextInt(FridgeBrand.values().length)];
			model+=brand;
			
			return new Product.Fridge(model,price,Product.getRandomColor(), (FridgeBrand) brand);
		}
		if(kind.equals(Kind.MICROWAVE)) {
			brand=MicrowaveBrand.values()[new Random().nextInt(MicrowaveBrand.values().length)];
			model+=brand;
			
			return new Product.Microwave(model,price,Product.getRandomColor(), (MicrowaveBrand) brand);
		}
		if(kind.equals(Kind.VACUUMCLEANER)) {
			brand=VacuumCleanerBrand.values()[new Random().nextInt(VacuumCleanerBrand.values().length)];
			model+=brand;
			
			return new Product.VacuumCleaner(model,price,Product.getRandomColor(), (VacuumCleanerBrand) brand);
		}
		brand=WashingMachineBrand.values()[new Random().nextInt(WashingMachineBrand.values().length)];
		model+=brand;
			
		return new Product.WashingMachine(model,price,Product.getRandomColor(), (WashingMachineBrand) brand);
	}
	public static Product getRandomPhotoAndVideo(Kind kind) {
		
		CameraBrand brand=CameraBrand.values()[new Random().nextInt(CameraBrand.values().length)];;
		String model=kind+" "+(new Random().nextInt(900)+100)+" ";
		double price=200+2000*new Random().nextDouble();
		
		return new Product.Camera(model, price,Product.getRandomColor(),brand);
	}
	
	public void login(String email,String password) {
		Set<String> emails=this.users.stream().map(u->u.getEmail()).collect(Collectors.toSet());
		Set<String> passwords=this.users.stream().map(u->u.getPassword()).collect(Collectors.toSet());
		
		if(emails.contains(email) && passwords.contains(password)) {
			User user=this.users.stream()
			.filter(u->u.getEmail().equals(email) 
					&& u.getPassword().equals(password))
			.findFirst()
			.get();
			user.setLogged(true);
			System.out.println("Successful login!");
			return;
		}
		System.out.println("Invalid email or password!");
	}
	
	public void register(User user) {
		this.users.add(user);
		System.out.println("Successful register!");		
	}
	
}
