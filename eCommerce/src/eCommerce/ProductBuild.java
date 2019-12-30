package eCommerce;

public class ProductBuild {
	private String name;
	private int id;
	private double price;
	private int stock;
	
	public ProductBuild setId(int id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public double getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	public ProductBuild setName(String name) {
		this.name = name;
		return this;
	}
	public ProductBuild setPrice(double price) {
		this.price = price;
		return this;
	}
	
	public ProductBuild setStock(int stock) {
		this.stock = stock;
		return this;
	}
	public products getProducts()
	{
		return new products(name, id , price, stock);
	}
	
}
