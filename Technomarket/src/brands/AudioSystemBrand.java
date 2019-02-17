package brands;

public enum AudioSystemBrand implements IBrand{
	DIVA(13),LG(35),PHILIPS(51),PIONEER(52),SONY(62),XMART(71);
	
	private int id;
	
	AudioSystemBrand(int id) {
		this.id=id;
	}
	@Override
	public int getId() {
		return this.id;
	}
}
