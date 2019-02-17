package brands;

public enum PhoneBrand implements IBrand{
	ALCATEL(4),ALLVIEW(5),APPLE(7),CAT(12),DOOGEE(14),ENERGIZER(19),HONOR(25),HTC(26),HUAWEI(27),JUST5(38),
	LG(35),MAXCOM(39),MEIZU(40),MICROSOFT(41),MOTOROLA(42),MYPHONE(43),NOKIA(49),SAMSUNG(58),SONY(62),XIAOMI(70),ZTE(75);
	
	private int id;
	
	PhoneBrand(int id) {
		this.id=id;
	}
	@Override
	public int getId() {
		return this.id;
	}
}
