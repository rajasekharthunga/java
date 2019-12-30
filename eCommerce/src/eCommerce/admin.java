package eCommerce;
import java.util.*;


public class admin {

	static Map<Integer,products>  prodMap = new HashMap<>(); 

	//Constructor for hard coding the products
	public admin() {
		addProducts();
	}
	
	public void addProducts() {
		
		//hard_coding the products list
		products p1=new ProductBuild().setId(1).setName("Zara Shirts").setPrice(2000).setStock(5).getProducts();
		products p2=new ProductBuild().setId(2).setName("vero-moda skirt").setPrice(7000).setStock(2).getProducts();
		products p3=new ProductBuild().setId(3).setName("Black shirt").setPrice(1900).setStock(3).getProducts();
		
		prodMap.put(p1.getId(), p1);
		prodMap.put(p2.getId(), p2);
		prodMap.put(p3.getId(), p3);
		
	}
	
	products getProd(int id)
	{
		return prodMap.get(id);
	}
	
	public boolean productAvailablity(int id) {
		if(prodMap.containsKey(id)) {
			return true;
		}
		return false;
	}
	
	 public boolean quantityAvailability(admin am,int id,int quantity) {
		if(am.getProd(id).getStock() >= quantity) {
			return true;
		}
		return false;
	}
	 
	 public void gettingProductDetails() {
			boolean repeat = true;
			
			while(repeat) {
				
				boolean  ch = true;
				
				System.out.println("\nEnter the id of the product to shop");
				int prodId = in.nextInt();
				
				if(am.productAvailablity(prodId)) {
					System.out.println("\nQuantity...");
					int quantityOfProd = in.nextInt();
					
					if(am.quantityAvailability(am, prodId, quantityOfProd)) {
						double price = am.getProd(prodId).getPrice();
						String name = am.getProd(prodId).getName();
						
						order.addProductToCart(prodId, name, quantityOfProd, price); //Adding Product to Cart
						am.updateStock(prodId, -quantityOfProd);
					}
					else {
						System.out.println("\nSorry...!!\n" + "Available Stock for the product " + am.getProd(prodId).getName() + " is "+ am.getProd(prodId).getStock());
					}
				}
				else {
					System.out.println("Product is not available in Product list..!");
				}
				
			while(ch) {
				
				System.out.println("\nContinue Shopping....Y/N");
				String Shop = in.next();
				
				if(Shop.toLowerCase().equals("n")) {
					repeat = false;
					ch=false;
					
					boolean other = true;
					System.out.println("Choose from the below options :");
					while(other) {
						
						System.out.println("\n1. Check Product List\n2. Check Your Cart\n3. Check Bill");
						int select = in.nextInt();
						switch(select) {
						case 1:
							prdts.printRemaining();
							break;
						case 2:
							ct.viewOrders();
							other = false;
							break;
						case 3:
							ct.goTOBill();
							other = false;
							break;
						default:
							System.out.println("Choose from the given options ..!");
						}
						
					}
					
				}
				else if(Shop.toLowerCase().equals("y")) {
					ch = false;
				}
				else {
					System.out.println("\nInvalid ..");
				}
			} //ends continueShopping loop
			
			
			}
		}
	
	
	//Updating the stock
	public void updateStock(int id , int add) {
		getProd(id).setStock(getProd(id).getStock() + add);
	}

	
}
