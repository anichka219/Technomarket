package brands;

public enum HomeCinemaBrand implements IBrand{
	DIVA(13),GOLLA(21),JAMO(37),LG(35),PHILIPS(51),SAMSUNG(58),SONY(62);
	
	private int id;
	
	HomeCinemaBrand(int id) {
		this.id=id;
	}
	@Override
	public int getId() {
		return this.id;
	}
}
