package com.abhra.Matrix;

public class StringSearchInMatrix {

	/**
	 * @param args
	 * source :https://www.careercup.com/question?id=5716759337238528
	 * date : 22-July-2016
	 * author Shams
	 */
	public static void main(String[] args) {
		
		char[][] a = { 
					{'B', 'B', 'A', 'B', 'B', 'N'}, 
					{'B', 'B', 'M', 'B', 'B', 'O'},
					{'B', 'B', 'A', 'B', 'B', 'Z'},
					{'N', 'O', 'Z', 'B', 'B', 'A'},
					{'B', 'B', 'B', 'B', 'B', 'M'},
					{'B', 'B', 'B', 'B', 'B', 'A'}
				};
		String str = "AMAZON";
		System.out.println(getStringCount(a,str,6,6));

	}
	
	public static class Neighbour {
		char c;
		int i;
		int j;
		Neighbour(char ch,int m,int n) {
			c = ch;
			i = m;
			j = n;
		}
	}
	public static final int MATRIX_ELEMENTS = 36;
	private static int getStringCount(char[][] a, String str,int R,int C) {
		int count = 0;
		int k=0;
		int neighI;
		int neighJ;
		char u = 0;
		char[] input = str.toCharArray();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				 if(k < input.length && a[i][j] == input[k]) {
					 u = a[i][j];
					 k++;
					 neighI = i;
					 neighJ = j;
					 while(u != 0) {
						 Neighbour neighbour = getMatchingNeighbour(a,input,u,neighI,neighJ,k,R,C);
						 if(neighbour == null)
							 break;
						 k++;
						 u = neighbour.c;
						 neighI = neighbour.i;
						 neighJ = neighbour.j;
						 if(k == str.length()) {
							 count++;
							 k=0;
							 break;
						 }
					 }
					 
				 }
			}
		}
		return count;
	}
	private static Neighbour getMatchingNeighbour(char[][] a,char[] input,char u, int i, int j,int k,int R,int C) {
		int iPlusOne = i+1;
		int iMinusOne = i-1;
		int jPlusOne = j+1;
		int jMinusOne = j-1;
		boolean inpuutIndex = k < input.length ? true : false;
		if(iPlusOne < R && inpuutIndex && (a[iPlusOne][j] == input[k]))
			return new Neighbour(input[k],iPlusOne,j);
		if(iMinusOne >= 0 && inpuutIndex && (a[iMinusOne][j] == input[k]))
			return new Neighbour(input[k],iMinusOne,j);
		if(jPlusOne < C && inpuutIndex && (a[i][jPlusOne] == input[k]))
			return new Neighbour(input[k],i,jPlusOne);
		if(jMinusOne >= 0 && inpuutIndex && (a[i][jMinusOne] == input[k]))
			return new Neighbour(input[k],i,jMinusOne);
		
		return null;
	}

}
