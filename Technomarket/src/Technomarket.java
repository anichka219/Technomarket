
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
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
	
	private static final int MIN_PRICE=179;
	private static final int MAX_PRICE=9999;
	private static final int MIN_MODEL_NUM=100;
	private static final int MAX_MODEL_NUM=1000;
	private static final int MAX_PRODUCT_COUNT=100;
	
	private Map<Category, Map<Kind,Map<Product,Integer>>> products;
	private Map<String,User> users;
	private ArrayBlockingQueue<Delivery> deliveries;
	private ArrayBlockingQueue<Request> requests;;
	private static Technomarket technomarket=null;
	
	private void initProducts(Category category,Kind kind)
	{
		int rnd = new Random().nextInt(MAX_PRODUCT_COUNT)+1;		
		
		for(int i =0; i < rnd; i++)
		{		
			Product p = getProduct(category,kind);
			products.get(category).get(kind).put(p, new Random().nextInt(MAX_PRODUCT_COUNT));
			DBManager.getInstance().addProduct(p);

		}	
	}
	
	private void initKinds(Category category)
	{	
		switch(category)
		{		
		case TV_AUDIO:
			this.products.get(Category.TV_AUDIO).put(Kind.TELEVISION, new HashMap<Product,Integer>());
			initProducts(category,Kind.TELEVISION);
			this.products.get(Category.TV_AUDIO).put(Kind.HOMECINEMA, new HashMap<Product,Integer>());
			initProducts(category,Kind.HOMECINEMA);
			this.products.get(Category.TV_AUDIO).put(Kind.AUDIOSYSTEM, new HashMap<Product,Integer>());
			initProducts(category,Kind.AUDIOSYSTEM);
			break;
			
		case CP_PERIPHERALS:
			this.products.get(Category.CP_PERIPHERALS).put(Kind.LAPTOP, new HashMap<Product,Integer>());
			initProducts(category,Kind.LAPTOP);
			this.products.get(Category.CP_PERIPHERALS).put(Kind.COMPUTER, new HashMap<Product,Integer>());
			initProducts(category,Kind.COMPUTER);
			this.products.get(Category.CP_PERIPHERALS).put(Kind.MONITOR, new HashMap<Product,Integer>());
			initProducts(category,Kind.MONITOR);
			break;
			
		case PHONES_TABLETS:
			this.products.get(Category.PHONES_TABLETS).put(Kind.PHONE, new HashMap<Product,Integer>());
			initProducts(category,Kind.PHONE);
			this.products.get(Category.PHONES_TABLETS).put(Kind.SMARTWATCH, new HashMap<Product,Integer>());
			initProducts(category,Kind.SMARTWATCH);
			this.products.get(Category.PHONES_TABLETS).put(Kind.TABLET, new HashMap<Product,Integer>());
			initProducts(category,Kind.TABLET);
			break;
			
		case ELECTRICAL_APPLIANCE:
			this.products.get(Category.ELECTRICAL_APPLIANCE).put(Kind.AIRCONDITIONER, new HashMap<Product,Integer>());
			initProducts(category,Kind.AIRCONDITIONER);
			this.products.get(Category.ELECTRICAL_APPLIANCE).put(Kind.FRIDGE, new HashMap<Product,Integer>());
			initProducts(category,Kind.FRIDGE);
			this.products.get(Category.ELECTRICAL_APPLIANCE).put(Kind.MICROWAVE, new HashMap<Product,Integer>());
			initProducts(category,Kind.MICROWAVE);
			this.products.get(Category.ELECTRICAL_APPLIANCE).put(Kind.VACUUMCLEANER, new HashMap<Product,Integer>());
			initProducts(category,Kind.VACUUMCLEANER);
			this.products.get(Category.ELECTRICAL_APPLIANCE).put(Kind.WASHINGMACHINE, new HashMap<Product,Integer>());
			initProducts(category,Kind.WASHINGMACHINE);
			break;
		case PHOTO_VIDEO:
			this.products.get(Category.PHOTO_VIDEO).put(Kind.CAMERA, new HashMap<Product,Integer>());
			initProducts(category,Kind.CAMERA);			
			break;
		}		
		
	}
	private void init()
	{		
		this.products.put(Category.TV_AUDIO, new HashMap<Kind, Map<Product,Integer>>());
		initKinds(Category.TV_AUDIO);		
		this.products.put(Category.CP_PERIPHERALS, new HashMap<Kind, Map<Product,Integer>>());
		initKinds(Category.CP_PERIPHERALS);		
		this.products.put(Category.PHONES_TABLETS, new HashMap<Kind, Map<Product,Integer>>());
		initKinds(Category.PHONES_TABLETS);		
		this.products.put(Category.ELECTRICAL_APPLIANCE, new HashMap<Kind, Map<Product,Integer>>());
		initKinds(Category.ELECTRICAL_APPLIANCE);		
		this.products.put(Category.PHOTO_VIDEO, new HashMap<Kind, Map<Product,Integer>>());				
		initKinds(Category.PHOTO_VIDEO);
	}
	

	
	private Technomarket() {
		this.products=new HashMap();
		this.users=new HashMap<String,User>();
		this.deliveries = new ArrayBlockingQueue<Delivery>(100);
		this.requests = new ArrayBlockingQueue<Request>(100);
		DBManager.getInstance().deleteProducts();
		init();	
		
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
		String model=kind+" "+(new Random().nextInt(MAX_MODEL_NUM-MIN_MODEL_NUM)+MIN_MODEL_NUM)+" ";
		double price=DoubleRounder.round(MIN_PRICE+(MAX_PRICE-MIN_PRICE)*new Random().nextDouble(),2);
		
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
		String model=kind+" "+(new Random().nextInt(MAX_MODEL_NUM-MIN_MODEL_NUM)+MIN_MODEL_NUM)+" ";
		double price=DoubleRounder.round(MIN_PRICE+(MAX_PRICE-MIN_PRICE)*new Random().nextDouble(),2);
		
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
		String model=kind+" "+(new Random().nextInt(MAX_MODEL_NUM-MIN_MODEL_NUM)+MIN_MODEL_NUM)+" ";
		double price=DoubleRounder.round(MIN_PRICE+(MAX_PRICE-MIN_PRICE)*new Random().nextDouble(),2);
		
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
		String model=kind+" "+(new Random().nextInt(MAX_MODEL_NUM-MIN_MODEL_NUM)+MIN_MODEL_NUM)+" ";
		double price=DoubleRounder.round(MIN_PRICE+(MAX_PRICE-MIN_PRICE)*new Random().nextDouble(),2);
		
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
		String model=kind+" "+(new Random().nextInt(MAX_MODEL_NUM-MIN_MODEL_NUM)+MIN_MODEL_NUM)+" ";
		double price=DoubleRounder.round(MIN_PRICE+(MAX_PRICE-MIN_PRICE)*new Random().nextDouble(),2);
		
		return new Product.Camera(model, price,Product.getRandomColor(),brand);
	}
	
	public boolean login(String email,String password) {	
		
		if(!this.users.containsKey(email)) 
			return false;
		
		User user=this.users.get(email);
		
		if(!user.getPassword().equals(password)) 
			return false;
			
		user.setLogged(true);
		return true;
	}
	
	public void register(User user) {
		
		System.out.println("Successful register!");		
	}
	
	public LinkedList<Product> getProductList(Category category,Kind kind) {
		LinkedList<Product> list = new LinkedList<Product>();
		this.products.get(category).get(kind).keySet().forEach(product -> list.add(product));
		return list;
	}
	
	boolean checkUser(String email) {
		if (email == null) {
			return false;
		}
		else {
			if (this.users.containsKey(email)) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	public void add(User user) {
		if (user != null) {
			this.users.put(user.getEmail(), user);
			DBManager.getInstance().addUser(user);
		}
	}
	
	public User getUser(String email) throws Exception {
		if (!this.users.containsKey(email)) {
			throw new Exception();
		}
		return this.users.get(email);
	}

	public boolean containsProductID(Category category, Kind kind, int input7) {
		HashSet<Product> tempSet = new HashSet<Product>();
		//tempSet = (HashSet<Product>) this.products.get(category).get(kind).keySet();
		boolean contains = false;
		for (Product p : this.products.get(category).get(kind).keySet()) {
			if (p.getProductID() == input7) {
				contains = true;
				break;
			}
		}
		return contains;
	}

	public Product getProduct(Category category, Kind kind, int input7) {
		HashSet<Product> tempSet = new HashSet<Product>();
		//tempSet = (HashSet<Product>) this.products.get(category).get(kind).keySet();
		Product product = null;
		for (Product p : this.products.get(category).get(kind).keySet()) {
			if (p.getProductID() == input7) {
				product = p;
				break;
			}
		}
		return product;
	}

	public boolean hasProductInStock(Category category, Kind kind, int input7) {
		HashSet<Product> tempSet = new HashSet<Product>();
		//tempSet = (HashSet<Product>) this.products.get(category).get(kind).keySet();
		boolean contains = false;
		Product product = null;
		for (Product p : this.products.get(category).get(kind).keySet()) {
			if (p.getProductID() == input7) {
				product = p;
				break;
			}
		}
		if (this.products.get(category).get(kind).get(product) > 0) {
			contains = true;
		}
		return contains;
	}

	public void addDelivery(Delivery delivery) throws InterruptedException {
		this.deliveries.put(delivery);
		
	}

	public void addRequest(Request request) throws InterruptedException {
		this.requests.put(request);
	}

	public Request getNextRequest() throws InterruptedException {
		
		return this.requests.take();
	}

	public void addProduct(Product p) {
		this.products.get(p.getCategory()).get(p.getKind())
		.put(p, this.products.get(p.getCategory()).get(p.getKind()).get(p) + 1);
		
	}

	public Delivery getNextDelivery() throws InterruptedException {
		
		return this.deliveries.take();
	}	
	
}
