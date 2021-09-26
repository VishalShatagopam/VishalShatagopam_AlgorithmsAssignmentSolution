package com.Stockers.Stockmanagement;
import java.util.Scanner;
public class Driver {
	static int count =0;
	static Scanner sc =new Scanner(System.in);	
	public static void insertPricesInStocksArray(double[] todaysPrices, double[] yesterdaysPrices, int N ){
		boolean flag;	
		for(int j=0; j<N; j++) {
			System.out.println("Enter current stock price of the company "+(j+1));
			todaysPrices[j]=sc.nextDouble();
			System.out.println("Whether company "+(j+1)+"'s stock price rose today compare to yesterday? ");
			flag= sc.nextBoolean();
			if (flag == true)
				count++;				
		}

	}
	public static void displayStocksArray(double[] todaysPrices) {
		for(int i=0;i<todaysPrices.length;i++) 
			System.out.print(todaysPrices[i]+", ");	
		System.out.println();
	}


	public static void main(String[] args) {
		int choice, N;
		System.out.println("enter the no of companies : ");
		N = sc.nextInt();
		double[] todaysPrices=new double[N];
		double[] yesterdaysPrices=new double[N];
		insertPricesInStocksArray(todaysPrices,yesterdaysPrices, N);		
		while(N>0)
		{	
			System.out.println("Enter your choice from the below List\n"+"1. Display the companies stock prices in ascending order\n"+"2. Display the companies stock prices in descending order\n"+
					"3. Display the total no of companies for which stock prices rose today\n"+
					"4. Display the total no of companies for which stock prices declined today\n"+
					"5. Search a specific stock price" );
			choice = sc.nextInt();
			SortStocksAscending asc = new SortStocksAscending();
			SortStocksDescending dsc = new SortStocksDescending();
			SpecificCompanyStock findPrice=new SpecificCompanyStock();
			switch(choice) {
			case 1: 
				asc.stocksAscending(todaysPrices,0,todaysPrices.length-1); 
				System.out.println("Stock prices in ascending order are :");
				displayStocksArray(todaysPrices);
				break;
			case 2: 
				dsc.stocksDescending(todaysPrices,0,todaysPrices.length-1);
				System.out.println("Stock prices in descending order are:");
				displayStocksArray(todaysPrices);
				break;
			case 3: System.out.println("Total no of companies whose stock price rose today: "+count); break;
			case 4: System.out.println("Total no of companies whose stock price declined today: "+(N-count)); break;
			case 5: asc.stocksAscending(todaysPrices,0,todaysPrices.length-1);
			findPrice.specificStock(todaysPrices); break;
			default: System.out.println("Invalid input"); 
			}

		}
		sc.close();
	}

}


