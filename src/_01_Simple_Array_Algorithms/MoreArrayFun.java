package _01_Simple_Array_Algorithms;

import java.util.Random;

public class MoreArrayFun {
    //1. Create a main method to test the other methods you write.
	public static void main(String[] args) {
	


    //2. Write a method that takes an array of Strings and prints all the Strings in the array.
		void(String[] arr) {
			for(int i=0;i<arr.length;i++) {
				System.out.println(arr[i]);
			}
			
		}

    //3. Write a method that takes an array of Strings and prints all the Strings in the array
    //   in reverse order.
		void(String[] arrr){
			for(int i=0;i<arrr.length;i++) {
				int bac = arrr.length;
				System.out.println(bac-i);
			}
		}


    //4. Write a method that takes an array of Strings and prints every other String in the array.
		void(String[] ar){
			for(int i=0;i<ar.length;i++) {
				if(i%2 == 0) {
				System.out.println(ar[i]);
				}
			}
		}

    //5. Write a method that takes an array of Strings and prints all the Strings in the array
    //   in a completely random order. Almost every run of the program should result in a different order.
		void(String[] ra){
			for(int i=0;i<ra.length;i++) {
				
			}
		}

	}
}
