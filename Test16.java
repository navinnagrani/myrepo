package com.interview;

import java.util.Arrays;

/*
 * Objective: Given an array of integers, write an algorithm to find the element which appears maximum number of times in the array.
 * Example:
 * int [] arrA = {4, 1, 5, 2, 1, 5, 9, 8, 6, 5, 3, 2, 4, 7};
 * Output: Element repeating maximum no of times: 5, maximum count: 3
 */


public class Test16 {
	
	static int mostFreq(int arr[]) {
		//Sorting of elements is performed.
		Arrays.sort(arr);
		
		//Taking initial max_count to 1 for the element whose count needs to find.
		int max_count = 1;
		
		//Taking initial result as first element from the Array
		int res = arr[0];
		
		//Setting current count of element which is maximum to be 1
		int curr_count = 1;
		
		//Finding the max frequency using linear traversal
		for(int i=1;i<arr.length;i++) {
			//Checking if element is equal to previous element and increasing current count
			if(arr[i] == arr[i-1]) {
				curr_count++;
			} else {
				// Checking if current count is maximum greater than maximum count. If it is then assign the element as result
				if(curr_count > max_count) {
					max_count = curr_count;
					res = arr[i-1];
				}
				curr_count = 1;
			}
		}
		
		// If last element is most frequent then assigning it to the result
		if(curr_count > max_count) {
			max_count = curr_count;
			res = arr[arr.length-1];
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		//Test-Case-1
		int [] arrA = {4, 1, 5, 2, 1, 5, 9, 8, 6, 5, 3, 2, 4, 7};
		System.out.println("Most Frequent element in Array A: "+mostFreq(arrA));
		
		//Test-Case-2
		int [] arrB = {1,2,3,4,5,2,6,7,8,1,2};
		System.out.println("Most Frequent element in Array B: "+mostFreq(arrB));
		
		//Test-Case-3
		int [] arrC = {1,2,3,4,5,6,6};
		System.out.println("Most Frequent element in Array C: "+mostFreq(arrC));
		
		//Test-Case-4
		int [] arrD = {10,9,8,7,6,5,4,3,2,1,1};
		System.out.println("Most Frequent element in Array D: "+mostFreq(arrD));
		
	}

}
