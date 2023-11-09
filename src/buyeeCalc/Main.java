package buyeeCalc;
/**
 * Rates, prices, and conversions were calculated November 7, 2023
 * Assume international shipping done with cheapest non-surface shipping available
 */
import java.util.ArrayList;

public class Main {
	static final double YEN_TO_USD_RATE = 0.0070125;
	static final double BUYEE_FEE_YEN = 300.0;
	public static double gramToYenAirmail(int grams) {
		if (grams < 1000) return grams*(2.18 + (6829628/(1+(grams/0.00018)))); // AIR Small Package
		else if (grams < 1500) return 3490.0; // Buyee Air Delivery
		else if (grams < 1500) return 3490.0; // Buyee Air Delivery
		else if (grams < 2000) return 4094.0;
		else if (grams < 2500) return 4579.0;
		else if (grams < 3000) return 4909.0; // ECMS
		else if (grams < 3500) return 5266.0; // Buyee Air Delivery
		else if (grams < 4000) return 5890.0; // ECMS
		else return -1.0; // Make a smaller order	
	}
	/**
	 * Pads or truncates a string to a given length
	 * Used when printing table
	 */
	public static String limitLength(String text, int maxLength) {
		String limitedString = text;
		// Ensures string is at least 'maxLength' long before performing substring
		while(limitedString.length()-maxLength < 0) {
			limitedString += " ";
		}
		return limitedString.substring(0,maxLength);
	}
	/**
	 * Used to sort a list with Items that have a defined 'want' parameter
	 * Higher want values at front of list
	 * Selection sort used since efficiency is low priority
	 */
	public static ArrayList<Item> sortListByWant(ArrayList<Item> list) {
		for (int i = 0; i < list.size()-1; i++) {
			int highWantIndex = i;
			for (int j = i; j < list.size(); j++) {
				if (list.get(j).getWant() > list.get(highWantIndex).getWant()) highWantIndex = j;
			}
			Item temp = list.get(i);
			list.set(i,list.get(highWantIndex));
			list.set(highWantIndex,temp);
		}
		return list;
	}
	/**
	 * Prints a custom table of the Item values in list
	 */
	public static void printTable(ArrayList<Item> list) {
		System.out.println("#   ITEM NAME     TYPE     COST     SHIPPING     TOTAL (YEN)   TOTAL (USD)");
		double totalItemCostYen = 0;
		int totalWeightGrams = 0;
		int count = 1;
		for (Item currentItem : list) {
			System.out.println(limitLength(count+"",3)   // #
					+limitLength(currentItem.getName(),15)   // Item name
					+limitLength(currentItem.getType(),9)   // Type
					+limitLength(currentItem.getItemCostYen()+"",9)   // Cost
					+limitLength(currentItem.getShippingCostYen()+"",13)   // Shipping
					+limitLength((currentItem.getItemCostYen()+currentItem.getShippingCostYen())+"",14)   // Total (yen)
					+limitLength(((currentItem.getItemCostYen()+currentItem.getShippingCostYen())*YEN_TO_USD_RATE+""),14));   // Total (USD)
			totalItemCostYen += currentItem.getItemCostYen();
			totalItemCostYen += currentItem.getShippingCostYen();
			totalWeightGrams += currentItem.getWeightGrams();
			count++;
		}
		double totalFeeCostYen = list.size() * BUYEE_FEE_YEN;
		double totalIntlShippingCostYen = gramToYenAirmail(totalWeightGrams);
		double totalOrderCostYen = totalItemCostYen + totalFeeCostYen + totalIntlShippingCostYen; 
		System.out.println(limitLength("TOTAL # OF ITEMS: "+list.size(),21)
				+limitLength("     TOTAL FEE (YEN): "+totalFeeCostYen,30)
				+limitLength("     TOTAL FEE (USD): "+(totalFeeCostYen*YEN_TO_USD_RATE),30));
		System.out.println(limitLength("TOTAL WEIGHT (GRAMS): "+totalWeightGrams,30)
				+limitLength("   SHIPPING (YEN): "+totalIntlShippingCostYen,27)
				+limitLength("   SHIPPING (USD): "+totalIntlShippingCostYen*YEN_TO_USD_RATE,27));
		System.out.println(limitLength("TOTAL COST (YEN): "+totalOrderCostYen,26)
				+limitLength("   TOTAL COST (USD): "+(totalOrderCostYen*YEN_TO_USD_RATE),29)
				+limitLength("   AVG COST (USD): "+((totalOrderCostYen*YEN_TO_USD_RATE)/list.size()),27));
	}
	/**
	 * 
	 */
	public static void main(String[] weezer) {
		ArrayList<Item> itemNameList = new ArrayList<Item>();
	//	itemNameList.add(new Item("Take The Time","CD",1000,0,9));
		itemNameList.add(new Item("SG bootleg","VINYL",7200,0,10));
		itemNameList.add(new Item("SG pin","MISC",1666,0,8));
		itemNameList.add(new Item("(a)El Scol 1","CASSETTE",2326,0,9));
		itemNameList.add(new Item("(a)El Scol 3","CASSETTE",2326,0,9));
		itemNameList.add(new Item("(a)El Scol 4","CASSETTE",2326,0,9));
		itemNameList.add(new Item("Homely Girl","CD",666,0,6));
		itemNameList.add(new Item("Blue Deluxe","CD",1800,200,6));
		itemNameList.add(new Item("Germany boot","VHS",1000,0,7));
	//	itemNameList.add(new Item("Brixton DVD","DVD",1000,0,6));
	//	itemNameList.add(new Item("MB CD w/ obi","CD",500,0,1));
	//	itemNameList.add(new Item("More Rare SC","VINYL",2200,0,5));
	//	itemNameList.add(new Item("Unrel. Demos","VINYL",2400,0,5));
	//	itemNameList.add(new Item("GP and Rare","VINYL",2690,0,6));
		itemNameList.add(new Item("(b)Blu w obi","CD",1000,0,4));
		itemNameList.add(new Item("(b)Pin w obi","CD",1000,0,4));
	//	itemNameList.add(new Item("(c)Pin w obi","CD",1000,0,4));
	//	itemNameList.add(new Item("(c)Gre w obi","CD",1000,0,4));
	//	itemNameList.add(new Item("(d)More Rare","VINYL",1333,0,6));
	//	itemNameList.add(new Item("(d)Unrel Dem","VINYL",1333,0,6));
	//	itemNameList.add(new Item("(d)HashPipe1","VINYL",1333,0,6));
	//	itemNameList.add(new Item("BoxClub Tabs","BOOK",950,0,4));
		itemNameList.add(new Item("(e)Fin Mal D","VINYL",1560,0,6));
		itemNameList.add(new Item("(e)Glenn Sou","VINYL",1560,0,6));
		itemNameList.add(new Item("(e)White Vin","VINYL",1560,0,6));
		itemNameList.add(new Item("(e)GP and Ra","VINYL",1560,0,6));
		itemNameList.add(new Item("(e)HashPipe2","VINYL",1560,0,6));
		itemNameList.add(new Item("Punpun plush","MISC",3520,0,0));
		printTable(sortListByWant(itemNameList));
		
	}
}
