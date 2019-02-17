import java.util.Random;

public class CreditCard {
	
	private String creditCardNumber;
	private int money;

	public CreditCard(String input8) {
		this.creditCardNumber = input8;
		this.money = new Random().nextInt(5000) + 50000;
	}

	int getMoney() {
		return money;
	}

	void setMoney(int money) {
		this.money = money;
	}

}
