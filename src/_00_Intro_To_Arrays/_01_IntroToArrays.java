package _00_Intro_To_Arrays;

import java.util.Random;

public class _01_IntroToArrays {
    public static void main(String[] args) {
        // 1. declare and Initialize an array 5 Strings
    	String[] buff = new String[5];
    	
    	buff[0] = "sojourn";
    	buff[1] = "doomfist";
    	buff[2] = "reaper";
    	buff[3] = "roadhog";
    	buff[4] = "zarya";
        // 2. print the third element in the array
    	System.out.println(buff[2]);
        // 3. set the third element to a different value
    	buff[2] = "junkrat";
        // 4. print the third element again
    	System.out.println(buff[2]);
        // 5. use a for loop to set all the elements in the array to a string
        //    of your choice
    	for(int i=0;i<5;i++) {
    		buff[i] = "kiriko";
    	}
        // 6. use a for loop to print all the values in the array
        //    BE SURE TO USE THE ARRAY'S length VARIABLE
    	for(int i=0;i<buff.length;i++) {
    		System.out.println(buff[i]);
    	}
        // 7. make an array of 50 integers
    	int[] dmg = new int[50];
        // 8. use a for loop to make every value of the integer array a random
        //    number
    	Random rand = new Random();
    	for(int i=0;i<50;i++) {
    		dmg[i] = rand.nextInt();
    	}
        // 9. without printing the entire array, print only the smallest number
        //    on the array
    	int small = 0;
    	for(int i=0;i<50;i++) {
    		if(dmg[i] < small) {
    			small = dmg[i];
    		}
    	}
    	System.out.println(small);
        // 10 print the entire array to see if step 8 was correct
    	//EEEEE
        // 11. print the largest number in the array.
    	int big = 0;
    	for(int i=0;i<50;i++) {
    		if(dmg[i] > big) {
    			big = dmg[i];
    		}
    	}
    	System.out.println(big);
        // 12. print only the last element in the array
    	System.out.println(dmg[49]);
    }
}
