package brands;

public enum TelevisionBrand implements IBrand{
	LG(35),NEO(47),PHILIPS(51),SAMSUNG(58),SKYWORTH(61),SONY(62),STRONG(63),TESLA(66),VORTEX(68);
	
	private int id;
	
	TelevisionBrand(int id) {
		this.id=id;
	}
	@Override
	public int getId() {
		return this.id;
	}
}