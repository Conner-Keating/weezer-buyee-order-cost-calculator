package buyeeCalc;

/**
 * Rates, prices, and conversions were calculated November 7, 2023
 * Assume international shipping done via Airmail 
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	static final double YEN_TO_USD_RATE = 0.0070125;
	static final double BUYEE_FEE_YEN = 300.0;
	public static double gramToYenAirmail(double grams) {
		return grams*(2.18 + (6829628/(1+(grams/0.00018)))); 
	}
	/**
	 * Returns an empty string of length 'size'
	 * Used when printing table
	 */
	public static String padding(int size) {
		String paddingString = "";
		for (int i = 0; i < size; i++) {
			paddingString += " ";
		}
		return paddingString;
	}
	public static void printTable(ArrayList<Item> list) {
		System.out.println("#   ITEM NAME     TYPE     COST     SHIPPING     TOTAL (YEN)   TOTAL (USD)");
		double totalItemCostYen = 0;
		double totalWeightGrams = 0;
		int count = 1;
		for (Item currentItem : list) {
			System.out.print((count+padding(3)).substring(0,4));
			System.out.print((currentItem.getName()+padding(14)).substring(0,14));
			System.out.print((currentItem.getType()+padding(8)).substring(0,9));
			System.out.print((currentItem.getItemCostYen()+padding(8)).substring(0,9));
			System.out.print((currentItem.getShippingCostYen()+padding(12)).substring(0,13));
			System.out.print(((currentItem.getItemCostYen()+currentItem.getShippingCostYen())+padding(13)).substring(0,14));
			System.out.print((((currentItem.getItemCostYen()+currentItem.getShippingCostYen())*YEN_TO_USD_RATE)+padding(13)).substring(0,14));
			System.out.println();
			totalItemCostYen += currentItem.getItemCostYen();
			totalItemCostYen += currentItem.getShippingCostYen();
			totalWeightGrams += currentItem.getWeightGrams();
			count++;
		}
		double totalFeeCostYen = list.size() * BUYEE_FEE_YEN;
		double totalIntlShippingCostYen = gramToYenAirmail(totalWeightGrams);
		double totalOrderCostYen = totalItemCostYen + totalFeeCostYen + totalIntlShippingCostYen; 
		System.out.println("TOTAL # OF ITEMS: "+list.size()+"     TOTAL FEE (YEN): "+totalFeeCostYen+("     TOTAL FEE (USD): "+(totalFeeCostYen*YEN_TO_USD_RATE+padding(8))).substring(0,30));
		System.out.println("TOTAL WEIGHT (GRAMS): "+totalWeightGrams+("   SHIPPING (YEN): "+totalIntlShippingCostYen+padding(8)).substring(0,27)+("   SHIPPING (USD): "+totalIntlShippingCostYen*YEN_TO_USD_RATE+padding(8)).substring(0,27));
		System.out.println(("TOTAL COST (YEN): "+totalOrderCostYen+padding(8)).substring(0,26)+("   TOTAL COST (USD): "+(totalOrderCostYen*YEN_TO_USD_RATE+padding(8))).substring(0,29)+("   AVG COST (USD): "+((totalIntlShippingCostYen*YEN_TO_USD_RATE)/list.size())+padding(8)).substring(0,27));
	}
	public static void main(String[] args) {
		ArrayList<Item> itemNameList = new ArrayList<Item>();
		itemNameList.add(new Item("Take The Time","CD",1000,0));
		itemNameList.add(new Item("SG bootleg","VINYL",7200,0));
		itemNameList.add(new Item("SG pin","MISC",1666,0));
		itemNameList.add(new Item("El Scolcho 1","CASSETTE",2326,0));
		itemNameList.add(new Item("El Scolcho 3","CASSETTE",2326,0));
		itemNameList.add(new Item("El Scolcho 4","CASSETTE",2326,0));
		itemNameList.add(new Item("Homely Girl","CD",666,0));
	//	itemNameList.add(new Item("Blue Deluxe","CD",1800,200));
		itemNameList.add(new Item("Germany boot","VHS",1000,0));
		printTable(itemNameList);
		
	}
}
