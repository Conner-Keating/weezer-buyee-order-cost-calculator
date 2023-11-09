package buyeeCalc;

public class Item {
	private String name;
	private String type;
	private int weightGrams;
	private double itemCostYen;
	private double shippingCostYen;
	private int want; // subjective value 1-10 (10 is a very desireable item)
	public Item(String name, String type, double itemCostYen, double shippingCostYen) {
		this.name = name;
		this.type = type;
		this.weightGrams = switch (this.type) {
			case "CD" -> 100;
			case "VINYL" -> 250;
			case "CASSETTE" -> 100;
			case "VHS" -> 230;
			case "BOOK" -> 280;
			case "MISC" -> 200;
			default -> 0;
		};
		this.itemCostYen = itemCostYen;
		this.shippingCostYen = shippingCostYen;
		want = 0;
	}
	public Item(String name, String type, double itemCostYen, double shippingCostYen, int want) {
		this.name = name;
		this.type = type;
		this.weightGrams = switch (this.type) {
			case "CD" -> 100;
			case "VINYL" -> 250;
			case "CASSETTE" -> 100;
			case "VHS" -> 230;
			case "BOOK" -> 280;
			case "MISC" -> 200;
			default -> 0;
		};
		this.itemCostYen = itemCostYen;
		this.shippingCostYen = shippingCostYen;
		this.want = want;
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
	public int getWeightGrams() {
		return weightGrams;
	}
	public void setWeightGrams(int weightGrams) {
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
	public int getWant() {
		return want;
	}
	public void setWant(int want) {
		this.want = want;
	}
}