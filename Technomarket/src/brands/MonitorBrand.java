package brands;

public enum MonitorBrand implements IBrand {
	ASUS(8),BENQ(10),HP(24),LENOVO(34),LG(35),SAMSUNG(58);
	
	private int id;
	
	MonitorBrand(int id) {
		this.id=id;
	}
	@Override
	public int getId() {
		return this.id;
	}
}
