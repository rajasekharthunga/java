package eCommerce;
import java.util.*;
public class OrderList {
	int id;
	String name;
	int quantity;
	double price;
	public OrderList() {		
	}
	
	public OrderList(int id, String name, int quantity, double price) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	static Map<Integer, OrderList> ordList = new HashMap<>();
	
	public boolean productInCart(int id) {
		if(ordList.containsKey(id)) {
			return true;
		}
		return false;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	OrderList getOrder(int id) {
		return ordList.get(id);
	}

}
