package brands;

public enum SmartWatchBrand implements IBrand{
	AGU(2),CELLULAR(11),DIVA(13),FIBIT(28),GARMIN(29),HUAWEI(27),LEMFO(33),LENOVO(34),LG(35),MOTOROLA(42),SAMSUNG(58),XIAOMI(70);
	
	private int id;
	
	SmartWatchBrand(int id) {
		this.id=id;
	}
	@Override
	public int getId() {
		return this.id;
	}
}
