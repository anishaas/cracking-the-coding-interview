package chapterone;

/*Implement an algorithm to determine if a string has all unique characters. 
 * What if you can not use additional data structures?
 */

public class Strings {
	
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
