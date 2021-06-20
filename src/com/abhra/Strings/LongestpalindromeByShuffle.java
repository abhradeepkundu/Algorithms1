package com.abhra.Strings;

public class LongestpalindromeByShuffle {

	/**
	 * @param args
	 * https://www.careercup.com/question?id=5631060781039616
	 * author Shams
	 * date : 30-Jul-2016
	 */
	public static void main(String[] args) {
		String str = "gggaaa";
		System.out.println(getLongestPalindrome(str));
	}

	private static String getLongestPalindrome(String str) {
		if(str == null || str.equalsIgnoreCase(""))
			return "";
		char[] inputArray = str.toCharArray();
		int[] chars = new int[27];
		for(char c : inputArray)  {
			chars[c-'a']++;
		}
		
		StringBuilder buf = new StringBuilder();
		for(int i=0;i<27;i++) {
			if(chars[i]>=2) {
				int count = chars[i]/2;
				chars[i] -= count*2;
				while(count>0) {
					buf.append((char)(i+'a'));
					count--;
				}
			}
		}
		String end = buf.toString();
		buf.reverse();
		for(int i=0; i<27;i++) {
			if(chars[i]>=1) {
				buf.append((char)(i+'a'));
				break;
			}
		}
		
		return buf.toString() + end;
	}
}
