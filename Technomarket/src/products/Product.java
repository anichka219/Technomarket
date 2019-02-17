package products;
import java.util.Random;

import brands.*;

public abstract class Product {

	private static int lastProductID = 1;
	
	private String model;
	private double price;
	private String desciption;
	private Color color;
	private Category category;
	private Kind kind;
	private IBrand brand;
	private int productID;

	public Product(String model, double price,Color color,IBrand brand) {
		this.model = model;
		this.price = price;
		this.color=color;
		this.brand = brand;
		this.productID = Product.lastProductID++;
	}
	
	
	public static Color getRandomColor() {
		return Color.values()[new Random().nextInt(Color.values().length)];
	}
	
	public static class Television extends Product{
		
		public Television(String model, double price, Color color,TelevisionBrand brand) {
			super(model, price,color, brand);
			setCategory(Category.TV_AUDIO);
			setKind(Kind.TELEVISION);
		}
	}
	public static class HomeCinema extends Product{
		
		public HomeCinema(String model, double price,Color color, HomeCinemaBrand brand) {
			super(model, price,color, brand);
			setCategory(Category.TV_AUDIO);
			setKind(Kind.HOMECINEMA);
		}
		
	}
	public static class AudioSystem extends Product{
		
		public AudioSystem(String model, double price,Color color, AudioSystemBrand brand) {
			super(model, price,color, brand);
			setCategory(Category.TV_AUDIO);
			setKind(Kind.AUDIOSYSTEM);
		}
		
	}
	public static class Laptop extends Product{
		
		public Laptop(String model, double price,Color color, LaptopBrand brand) {
			super(model, price,color, brand);
			setCategory(Category.CP_PERIPHERALS);
			setKind(Kind.LAPTOP);
		}
		
	}
	public static class Computer extends Product{
		
		public Computer(String model, double price, Color color,ComputerBrand brand) {
			super(model, price,color,brand);
			setCategory(Category.CP_PERIPHERALS);
			setKind(Kind.COMPUTER);
		}
		
	}

	public static class Monitor extends Product{
		
		public Monitor(String model, double price, Color color,MonitorBrand brand) {
			super(model, price,color, brand);
			setCategory(Category.CP_PERIPHERALS);
			setKind(Kind.MONITOR);
		}
		
	}
	public static class Phone extends Product{
		
		public Phone(String model, double price,Color color,PhoneBrand brand) {
			super(model, price,color, brand);
			setCategory(Category.PHONES_TABLETS);
			setKind(Kind.PHONE);
		}
		
	}
	public static class SmartWatch extends Product{
		
		public SmartWatch(String model, double price,Color color, SmartWatchBrand brand) {
			super(model, price,color, brand);
			setCategory(Category.PHONES_TABLETS);
			setKind(Kind.SMARTWATCH);
		}
		
	}
	public static class Tablet extends Product{
		
		public Tablet(String model, double price,Color color, TabletBrand brand) {
			super(model, price,color, brand);
			setCategory(Category.PHONES_TABLETS);
			setKind(Kind.TABLET);
		}
		
	}
	public static class AirConditioner extends Product{
		
		public AirConditioner(String model, double price,Color color,AirConditionerBrand brand) {
			super(model, price,color, brand);
			setCategory(Category.ELECTRICAL_APPLIANCE);
			setKind(Kind.AIRCONDITIONER);
		}
		
	}
	public static class WashingMachine extends Product{
		
		public WashingMachine(String model, double price,Color color, WashingMachineBrand brand) {
			super(model, price,color,  brand);
			setCategory(Category.ELECTRICAL_APPLIANCE);
			setKind(Kind.WASHINGMACHINE);
		}
		
	}
	public static class Fridge extends Product{
	
	public Fridge(String model, double price, Color color, FridgeBrand brand) {
		super(model, price,color, brand);
		setCategory(Category.ELECTRICAL_APPLIANCE);
		setKind(Kind.FRIDGE);
		}
	
	}
	public static class Microwave extends Product{
	
	public Microwave(String model, double price,Color color,  MicrowaveBrand brand) {
		super(model, price, color, brand);
		setCategory(Category.ELECTRICAL_APPLIANCE);
		setKind(Kind.MICROWAVE);
		}
	
	}
	public static class VacuumCleaner extends Product{
	
	public VacuumCleaner(String model, double price,Color color, VacuumCleanerBrand brand) {
		super(model, price,color, brand);
		setCategory(Category.ELECTRICAL_APPLIANCE);
		setKind(Kind.VACUUMCLEANER);
		}
	
	}
	public static class Camera extends Product{
	
	public Camera(String model, double price,Color color, CameraBrand brand) {
		super(model, price,color, brand);
		setCategory(Category.PHOTO_VIDEO);
		setKind(Kind.CAMERA);
		}
	
	}
	
	
	@Override
	public String toString() {
		return model + " | " + price  + " | " + color + " | " + brand + " | " + productID;
	}


	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Kind getKind() {
		return kind;
	}
	public void setKind(Kind kind) {
		this.kind = kind;
	}
	public IBrand getBrand() {
		return brand;
	}
	public void setBrand(IBrand brand) {
		this.brand = brand;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}
}
