package brands;

public enum VacuumCleanerBrand implements IBrand{
	BOSCH(9),BRAVISSIMO(16),DAEWOO(17),DYSON(18),ELECTROLUX(15),GORENJE(20),IROBOT(31),KARCHER(32),LG(35),MIELE(45),MYDOMO(46),
	NEO(47),PHILIPS(51),ROHNSON(55),ROWENTA(56),RUSSELL_HOBBS(57),SAMSUNG(58),SAPIR(59),SINGER(60),WHIRLPOOL(69),ZELMER(73),ZEPHYR(74);
	
	private int id;
	
	VacuumCleanerBrand(int id) {
		this.id=id;
	}
	@Override
	public int getId() {
		return this.id;
	}
}
