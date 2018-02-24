package chapterone;

/* 1.1) 
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you can not use additional data structures?
 */

/* 1.2)
 * Write code to reverse a C-Style String. (C-String means that “abcd” is 
 * represented as five characters, including the null character.)
 */

//1.3) Remove duplicate chars, no additional buffer

//1.6) Image represented by a NxN matrix, rotate each image by 90 degrees

public class Strings {
	
	public static void rotateImage(int[][] arr, int n) {
		for(int edge = 0; edge < n/2; edge++) {
			int first = edge;
			int last = n - 1 - first;
			for(int i = first; i < last; i++) {
				int offset = i - first;
				//save top row
				int top = arr[first][i];
				
				//left to top
				arr[first][i] = arr[last][first];
				
				//bottom to left
				arr[last - offset][first] = arr[last][last - offset];
				
				//right to bottom
				arr[last][last - offset] = arr[i][last];
				
				//top to right
				arr[i][last] = top;
			}
		}
	}

	//Remove duplicates
	public static void removeDuplicates(char[] s) {
		//edge cases
		int length = s.length;
		int tail = 1;
		if (s == null) return;
		if(length < 2) return;
		//start i at index 1, j at 0
		for(int i = 1; i < length; i++) {
			int j;
			for(j = 0; j < i; j++) {
				//duplicate found
				if(s[i] == s[j]) break;
			}
			if (j == tail) {
				//move duplicate char to tail
				s[tail] = s[i];
				tail++;
			}
		}
	}
	
	//C-style string is an array of chars
	public static String reverse(String s) {
		char[] string = s.toCharArray();
		int last = s.length() - 2;
		String reversed = "";
		for(int i = last; i >= 0; i--) {
			reversed = reversed + string[i];
		}
		return reversed;
	}
	
	
	public static boolean uniqueChars(String s){
		for(int i=0; i < s.length(); i++) {
			for(int j=i+1; j < s.length(); j++) {
				if(s.charAt(i) == s.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean uniqueCharsEfficient(String s) {
		boolean[] chars = new boolean[s.length()];
		for(int i = 0; i < s.length(); i++) {
			int val = s.charAt(i);
			if(chars[val]) {
				return false;
			}
			chars[val] = true;
		}
		return true;
	}

}
