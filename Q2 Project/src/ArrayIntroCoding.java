
public class ArrayIntroCoding {

	public static void main(String[] args) {
		
		System.out.println("intro to arrays");
		// declare any variable
		int x;
		String str = "hello";
		double y = 3.14;
		// arrays - a collection of similar elements
		// type [] arrayName = new type [size];
		// create array of 10 ints
		
		int [] nums = new int [10];
		// primitives are initialized
		// int are init to 0
		// doubles -> 0.0
		// booleans -> false
		
		System.out.println(nums.length);
		
		// reading from a 1d array
		// call the array by its name
		// specify a location
		
		System.out.println(nums[0]);
		
		System.out.println(nums[nums.length - 1]);
		
		// write 7 to index 0
		nums [0] = 7;
		nums [1] = 8;
		nums [2] = 10;
		
		// two different ways to create arrays
		
		
		double [] myDoubles = {86.5, 99.9};
		double [] myDoubles2 = new double [2];
		myDoubles2[0] = 86.5;
		myDoubles2[1] = 99.9;
		
		// 1d array of 31 integers
		
		int[] numbers = new int [31];
		
		// write a loop that counts from 0 to 30 inclusive
		
		for (int index = 0; index < 31; index ++){
			numbers [index] = (int)(Math.random()*2343);	
		}
		
		// write the loop to print the elements in their onw line
		
		for (int index = 0; index < numbers.length; index ++){
			System.out.println(numbers[index]);	
		}
		
	}

}
