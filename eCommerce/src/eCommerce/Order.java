package eCommerce;
import java.util.*;

public class Order {
	
	double calPrice;
	
	public void addProductToCart(int id, String name,int quantity,double price) {
		
		calPrice = quantity * price;
		OrderList ol  = new OrderList(id,name,quantity,calPrice);
		OrderList.ordList.put(id,ol);
		//OrderList.ordList.add(new OrderList(id, name, quantity, calPrice));
		System.out.println("\n"+ name +"\t"+"Added to cart");
	}
	
}
