package eCommerce;
import java.util.*;

public class products {
		
	private String name;
	private int id;
	private double price;
	private int stock;
	

	public products() {
		super();
	}

	public products(String name, int id, double price,int stock) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
		this.stock = stock;
	}
	
	public void PrintProducts() {
		System.out.println("\nProduct List");
		System.out.println("------------------------------");
		System.out.println("Id"+"\t"+"Name"+"\t\t"+"Price");
		System.out.println("------------------------------");
	
		admin.prodMap.forEach((j,i) -> System.out.println(i.getId()+"\t"+i.getName()+"\t"+i.getPrice()));
		
	}
	
	public void PrintStock() {
		System.out.println("\nInventory List");
		System.out.println("----------------");
		System.out.println("Id"+"\t"+"Stock");
		System.out.println("----------------");

		admin.prodMap.forEach((i,j) -> System.out.println(i +"\t"+ j.getStock()));
	}
	
	public void printRemaining() {
		System.out.println("\nProduct With Stock List");
		System.out.println("---------------------------------------");
		System.out.println("Id"+"\t"+"Name"+"\t\t"+"Price"+"\t"+"Stock");
		System.out.println("---------------------------------------");
	
		admin.prodMap.forEach((j,i) -> System.out.println(i.getId()+"\t"+i.getName()+"\t"+i.getPrice()+"\t"+i.getStock()));
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
