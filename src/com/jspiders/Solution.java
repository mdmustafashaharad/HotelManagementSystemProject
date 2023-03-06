package com.jspiders;
import java.util.Scanner;

import exception.InvalidChoiceException;

/**
 * @author Mohammad Mustafa
 * @since 2023
 * @Email mdmustafashaharad@gmail.com
 * @contact 9900651340
 */

// Solution class is provide main method. it is main usable class
// creating object of HotelManagementSystemImpl class to take some logics to user 
// creating scanner class take input from user side 

public class Solution {

	public static void main(String[] args) {
		
		System.out.println(" Welcome To Taz hotel");
		System.out.println("----------------------");
		
		int input = 1;
		
		Scanner scan = new Scanner(System.in);
		HotelManagementSystem hotel = new HotelManagementSystemImpl();   // upcasting
		
		hotel.addFood();   // Adding The All menu
		
		while (input == 1) {
			System.out.println("    1. Add Food\n    2. Check Out\n     Enter Choice");
			int choice = scan.nextInt();
			switch(choice) {
			case 1 : {
				hotel.displayFood();
				hotel.orderFood();
				break;
			}
			case 2 : {
				hotel.checkOut(); break;
				
			}
			default : {
				try {
					throw new InvalidChoiceException("INVALID CHOICE ! , Enter Currect Choice\n");
				} catch (InvalidChoiceException e) {
					System.out.println(e.getMessage());
				}
			}
			} // End Switch
			System.out.println("Enter 1 to Continue, Any Other Number To Exit");
			input = scan.nextInt();
			System.out.println("------------");
		}// End While
		hotel.checkOut();
		System.out.println("Thank You...!");
		System.exit(0);


	}
}
