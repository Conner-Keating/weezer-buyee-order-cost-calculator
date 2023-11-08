package buyeeCalc;

public class Item {
	private String name;
	private String type;
	private double weightGrams;
	private double itemCostYen;
	private double shippingCostYen;
	public Item(String name, String type, double itemCostYen, double shippingCostYen) {
		this.name = name;
		this.type = type;
		switch (this.type) {
			case "CD":
				this.weightGrams = 100.0;
				break;
			case "VINYL":
				this.weightGrams = 250.0;
				break;
			case "CASSETTE":
				this.weightGrams = 100.0;
				break;
			case "VHS":
				this.weightGrams = 230.0;
				break;
			case "BOOK":
				this.weightGrams = 280.0;
				break;
			case "MISC":
				this.weightGrams = 200.0;
				break;
			default:
				this.weightGrams = 0;
				break;
		}
		this.itemCostYen = itemCostYen;
		this.shippingCostYen = shippingCostYen;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getWeightGrams() {
		return weightGrams;
	}
	public void setWeightGrams(double weightGrams) {
		this.weightGrams = weightGrams;
	}
	public double getItemCostYen() {
		return itemCostYen;
	}
	public void setItemCostYen(double itemCostYen) {
		this.itemCostYen = itemCostYen;
	}
	public double getShippingCostYen() {
		return shippingCostYen;
	}
	public void setShippingCostYen(double shippingCostYen) {
		this.shippingCostYen = shippingCostYen;
	}	
}