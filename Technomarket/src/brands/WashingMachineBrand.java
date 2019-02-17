package brands;

public enum WashingMachineBrand implements IBrand{
	AEG(1),AMICA(6),BOSCH(9),ELECTROLUX(15),GORENJE(20),HOTPOINT_ARISTON(23),INDESIT(30),LG(35),MIELE(45),
	NEO(47),SAMSUNG(58),SKYWORTH(61),WHIRLPOOL(69),ZANUSSI(72);
	
	private int id;
	
	WashingMachineBrand(int id) {
		this.id=id;
	}
	@Override
	public int getId() {
		return this.id;
	}
}
