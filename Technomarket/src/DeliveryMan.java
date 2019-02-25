import products.Product;

public class DeliveryMan implements Runnable{

	private Technomarket t;

	public DeliveryMan(Technomarket t) {
		super();
		this.t = t;
	}
	
	@Override
	public void run() {
		while (!Thread.interrupted()) {
			
			try {
				Thread.sleep(10000);
				Delivery d = t.getNextDelivery();
				String message = "Dneska shte vi dostavim vashata pratka!";
				System.out.println(message);
				d.getUser().addMessage(message);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	}
}
