package com.jspiders;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import exception.InvalidChoiceException;
import exception.InvalidQuantityException;

/**
 * @author Mohammad Mustafa
 * @since 2023
 * @Email mdmustafashaharad@gmail.com
 * @contact 9900651340
 */
// HotelManagementSystemImpl class is use to provide the logic of function.
// using the map to adding to store some food details
// scanner class is use to take user side input
public class HotelManagementSystemImpl implements HotelManagementSystem {
	
	Scanner scan = new Scanner(System.in);
	static Map<Integer,Food> map = new LinkedHashMap<Integer,Food>();
	static Set<Integer> keys = map.keySet(); // 1,2,3,4,5 keys are stored
	
	int totalcost = 0 ;
	
	@Override
	public void addFood() {
		//5 Entries
		map.put(1 , new Food(1,"chicken biriyani",240,5) );
		map.put(2 , new Food(2,"Mashroom Biriyani",210,7) );
		map.put(3 , new Food(3,"Paneer biriyani",220,3) );
		map.put(4 , new Food(4,"Fish biriyani",230,8) );
		map.put(5 , new Food(5,"Mutton biriyani",250,4) );
		
		System.out.println("Food Menu Created");
	}

	@Override
	public void displayFood() {
		for (int i : keys ) {
			System.out.println("Enter "+ i +" -> "+ map.get(i));
		}
		System.out.println();
	}

	@Override
	public void orderFood() {
		// 1. get the food object based on id / choice -> get()
		// 2. Accept Quantity -> Set new Quantity
		// 3. Calculator cost
		// 4. cost -> Total Bill
		// 5. InvalidQuantityException
		
// 1. get the food object based on id / choice -> get()
		
		System.out.println("Select Food\n");
		int id =scan.nextInt();
		Food food = map.get(id);
		System.out.println("Ordering : "+food.getName()+"\n");
		
// 2. Accept Quantity -> Set new Quantity
		
		System.out.println();
		System.out.println("Select Quantity\n");
		int quantity  =scan.nextInt();
		
		if (quantity <= food.getQuantity() ) {
			
			food.setQuantity(food.getQuantity() - quantity );
			
// 3. Calculator cost
			
			int currentcost = food.getCost() * quantity;
			
// 4. cost -> Total Bill
			
			totalcost = totalcost + currentcost;
			System.out.println("Ordered "+quantity +" "+food.getName()
			+" at the cost of Rs. "+currentcost+"\n");
		} else  {
			
// 5. InvalidQuantityException
			try {
				throw new InvalidQuantityException("Sorry Having less Quantity "+food.getQuantity()+"\n");
			} catch (InvalidQuantityException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void checkOut() {
		if (totalcost !=0  ) {
			System.out.println("Total Bill : Rs. " + totalcost+"\n");
		} else {
			System.out.println("Any Iteams Can not be Added\n");
		}
		
	}
}
