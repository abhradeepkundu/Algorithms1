package com.abhra.arrays;


public class FindAllSubsetsOfArray {

	public FindAllSubsetsOfArray() {
		this.run();
	}

	private void run() {
		//int[] a = { 4, 5, 6 };
		int[] a = { 1,1,3 };
		findSubsets2(a);
	}
	
	/****
	 * Total possible subsets will be 2 power n where n is the length of array (i.e if array length is 3 then total possible subsets would be 8)
	 * iterate from 0 to  total possible subsets
	 * print the position where the bit is set. for example if in iteration 3, (0011) binary form, print a[2] and a[1]
	 * 
	 * **/
	private void findSubsets(int[] a) {
		int numOfSubSets = 1 << a.length;
		int bitMask;int pos;
		for(int i = 0; i < numOfSubSets;++i) {
			bitMask = i;
			pos = a.length-1;
			System.out.print("{");
			while(bitMask > 0) { 
				if( (bitMask & 1) == 1)
					System.out.print(a[pos] + ",");
				bitMask >>= 1;
				pos--;
			}
			System.out.print("}");
		}
	}
	
	
	private void findSubsets2(int[] a) {
		int numOfSubSets = 1 << a.length;
		int bitMask;int pos;
		int prev=-1;
		for(int i = 0; i < numOfSubSets;++i) {
			bitMask = i;
			pos = a.length-1;
			System.out.print("{");
			int count=0;
			while(bitMask > 0) { 
				if( (bitMask & 1) == 1) {
					++count;
					if(count > 1 && prev == a[pos]) {
						System.out.print(a[pos] + ",");
					}
//					else {
//						System.out.print(a[pos] + ",");
//					}
					prev = a[pos];
				}
				bitMask >>= 1;
				pos--;
			}
			System.out.print( "}");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new FindAllSubsetsOfArray();
	}

}
