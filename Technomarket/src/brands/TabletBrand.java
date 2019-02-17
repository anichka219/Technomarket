package brands;

public enum TabletBrand implements IBrand{
	ALCATEL(4),APPLE(7),ASUS(8),DIVA(13),HP(24),LENOVO(34),NAVITEL(48),SAMSUNG(58);
	
	private int id;
	
	TabletBrand(int id) {
		this.id=id;
	}
	@Override
	public int getId() {
		return this.id;
	}
}
