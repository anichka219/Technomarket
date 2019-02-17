package brands;

public enum ComputerBrand implements IBrand {
	APPLE(7),HP(24),LENOVO(34);
	
	private int id;
	
	ComputerBrand(int id) {
		this.id=id;
	}
	@Override
	public int getId() {
		return this.id;
	}
}
