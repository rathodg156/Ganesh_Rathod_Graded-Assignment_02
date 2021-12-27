package com.stockers.main;

import java.util.Scanner;

import com.stockers.services.StocksTrack;
public class Driver {
	
	private static Scanner sc= new Scanner(System.in);
	public static void main (String [] args) {
// Get number of companies from user
		System.out.println("Enter the no of Comapanies :");
		int size = sc.nextInt();
		double stockPrice [] = new double[size];
		boolean stockPriceStatus [] = new boolean[size];
// Get the stock price from user
		for(int i=0; i< size; i++) {
			System.out.println("Enter the Stock Price of Company : " + (i+1));
			stockPrice [i]= sc.nextDouble();
			System.out.println("Whether Comapny's Stock price rose today compare to Yesterday ? ");
			stockPriceStatus[i] = sc.nextBoolean();
		}
		 while (true) {
// Get the choice from user to perform the operation.
		System.out.println("-----------------------------");
		System.out.println("Enter the opration you want to Perform :");
		System.out.println("1. Display the companies stock price in ascending order.");
		System.out.println("2. Display the companies stock price in descending order.");
		System.out.println("3. Display the total number of compaines for which Stock price rose today.");
		System.out.println("4. Display the total number of compaines for which Stock price declined today.");
		System.out.println("5. Search a Specific Stock Price.");
		System.out.println("6. Press 0 to exit.");
		
	   	int Choice = sc.nextInt();
	   	
	   	if (Choice == 0) {
            //exit application
            break;
	   	}
		
		
		  StocksTrack stockTrack = new StocksTrack (stockPrice, stockPriceStatus);
          switch (Choice) {
              case 1: 
                      //call display stock price asc
                      stockTrack.showStocks(true);
                      break;
              case 2:
                      //call display stock price desc
                      stockTrack.showStocks(false);
                      break;
              case 3: 
                      //call display count of stock rose today
                      stockTrack.showNoOfCompaniesStockRose();
                      break;
              case 4 :
                      //call display count of stock declined today
                      stockTrack.showNoOfCompaniesStockDeclined();
                      break;
              case 5: {
            	//call Search operation
                  System.out.println("enter the key value");
                  var searchValue = sc.nextDouble();
                  stockTrack.searchStockPrice(searchValue);
                  break;
              }
              
              default: System.out.println("Invalid operation input");
          }
      }
      System.out.println("Exited successfully");
  }
	
}