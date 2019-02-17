package brands;

public enum MicrowaveBrand implements IBrand{
	BOSCH(9),ELECTROLUX(15),GORENJE(20),MIELE(45),SAMSUNG(58),TEKA(67),WHIRLPOOL(69);
	
	private int id;
	
	MicrowaveBrand(int id) {
		this.id=id;
	}
	@Override
	public int getId() {
		return this.id;
	}
}
