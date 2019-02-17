package brands;

public enum AirConditionerBrand implements IBrand{
	NEO(47),PANASONIC(50),DAIKIN(53),FUJITSU(54),LG(35),SAMSUNG(58),SKYWORTH(61),TESLA(66);

	private int id;
	
	AirConditionerBrand(int id) {
		this.id=id;
	}
	@Override
	public int getId() {
		return this.id;
	}
}
