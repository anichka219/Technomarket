package brands;

public enum LaptopBrand implements IBrand{
	ACER(3),APPLE(7),ASUS(8),HP(24),LENOVO(34);
	
	private int id;
	
	LaptopBrand(int id) {
		this.id=id;
	}
	@Override
	public int getId() {
		return this.id;
	}
}
