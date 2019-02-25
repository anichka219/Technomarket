import products.Product;

public class Provider implements Runnable{

	private Technomarket t;

	public Provider(Technomarket t) {
		super();
		this.t = t;
	}
	
	@Override
	public void run() {
		while (!Thread.interrupted()) {
			
			try {
				Thread.sleep(10000);
				Request r = t.getNextRequest();
				Product p = r.getProduct();
				t.addProduct(p);
				String message = "Zaredihme produkt za koito imate zaqvka!";
				System.out.println(message);
				r.getUser().addMessage(message);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
	}
}
