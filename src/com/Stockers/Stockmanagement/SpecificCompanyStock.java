package com.Stockers.Stockmanagement;

import java.util.Scanner;

public class SpecificCompanyStock {

	int l, r, mid;
	double price;
	Scanner sc = new Scanner(System.in);
	public void specificStock(double[] todaysPrices) {	
		System.out.println("enter the key value: ");
		price = sc.nextDouble();
		searchValue(todaysPrices);
	}
	public void searchValue(double[] todaysPrices) {
		l = 0;
		r = todaysPrices.length - 1;
		mid = l + (r - l) / 2;
		while (l <= r) {
			if (price < todaysPrices[mid]) {// range is l to mid-1 
				r = mid - 1;
			}
			else if (price > todaysPrices[mid]) {// range is mid+1 to r
				l = mid + 1;

			} 
			else {
				System.out.println("Stock of value " + price + " is present");
				break;
			}
			mid = l + (r - l) / 2;
		}
		if (l > r) {
			System.out.println("Value not found");
		}
	}		

}		
