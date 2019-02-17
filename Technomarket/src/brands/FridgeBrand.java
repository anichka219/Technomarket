package brands;

public enum FridgeBrand implements IBrand{
	AEG(1),AMICA(6),BOSCH(9),ELECTROLUX(15),GORENJE(20),HISENSE(22),HOTPOINT_ARISTON(23),INDESIT(30),LG(35),LIEBHERR(36),MIDEA(44),
	MIELE(45),NEO(47),SAMSUNG(58),SKYWORTH(61),WHIRLPOOL(69),ZANUSSI(72);
	
	private int id;
	
	FridgeBrand(int id) {
		this.id=id;
	}
	@Override
	public int getId() {
		return this.id;
	}
}
