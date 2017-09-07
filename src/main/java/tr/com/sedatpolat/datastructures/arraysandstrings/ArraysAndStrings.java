package tr.com.sedatpolat.datastructures.arraysandstrings;

/**
 * 
 * @author sedpol
 *
 */
public class ArraysAndStrings {

	public static boolean hasUniqueChar(String str) {
		boolean [] bolleanArr = new boolean [256]; // ascii
		
		if (str == null || str.length() < 2) 
			return true;
		
		int length = str.length();
		for (int i = 0; i < length; i++) {
			
			char val = str.charAt(i);
			
			if (bolleanArr [val]) 
				return false;
			
			bolleanArr [val] = true;
		}
		
		return true;
	}
	
	public static String reverse(String str) {
		
		if (str == null || str.length() < 2) 
			return str;
		
		int length = str.length();
		char [] charArr = str.toCharArray();
		for(int i = 0; i < length/2; i++) {
			char temp = charArr[i];
			charArr[i] = charArr[length - i - 1];
			charArr[length - i - 1] = temp;
		}
		return new String(charArr);
	}
}
