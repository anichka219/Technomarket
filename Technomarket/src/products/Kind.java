package products;

public enum Kind {
	TELEVISION(1),HOMECINEMA(2),PHONE(7),TABLET(9),AIRCONDITIONER(10),AUDIOSYSTEM(3),CAMERA(15),COMPUTER(5),FRIDGE(12),MICROWAVE(13),MONITOR(6),SMARTWATCH(8),
	VACUUMCLEANER(14),WASHINGMACHINE(11),LAPTOP(4);
	
	private int id;

	Kind(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
