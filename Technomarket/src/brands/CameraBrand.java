package brands;

public enum CameraBrand implements IBrand{
	SONY(62),CANON(64),BLAUPUNKT(65);
	
	private int id;
	
	CameraBrand(int id) {
		this.id=id;
	}
	@Override
	public int getId() {
		return this.id;
	}
	
}
