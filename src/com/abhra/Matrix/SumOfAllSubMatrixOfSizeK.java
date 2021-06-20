package com.abhra.Matrix;

public class SumOfAllSubMatrixOfSizeK {

	/**
	 * @param args
	 * http://www.geeksforgeeks.org/given-n-x-n-square-matrix-find-sum-sub-squares-size-k-x-k/
	 */
	public static void main(String[] args) {
		int[][] a = 
			{ 
			{1, 1, 1, 1, 1},
            {2, 2, 2, 2, 2},
            {3, 3, 3, 3, 3},
            {4, 4, 4, 4, 4},
            {5, 5, 5, 5, 5},
         };
		int k=3;
		printSumOfAllSubMatrixOfSizeK(a,k);
	}
	
	private static final int N = 5;
	
	private static void printSumOfAllSubMatrixOfSizeK(int[][] a, int k) {
		if(k > N) {
			System.out.println("Invalid K value");
			return;
		}
		int[][] b = new int[N][N];
		int sum;
		
		for(int j=0;j<N;j++) {
			sum =0;
			for(int i=0;i<k;i++) {
				sum += a[i][j]; 
			}
			b[0][j] = sum;
			for(int i=1;i<N-k+1;i++) {
				sum += (a[i+k-1][j]-a[i-1][j]);
				b[i][j] = sum;
			}
		}
		
		for(int i=0;i<N-k+1;i++) {
			sum = 0;
			for(int j=0;j<k;j++) {
				sum += b[i][j];
			}
			System.out.print(sum + " ");
					
			for(int j=1;j<N-k+1;j++) {
				sum += (b[i][j+k-1] - b[i][j-1]);
				//b[i][j] = sum;
				System.out.print(sum + " ");
				
			}
			System.out.println();
		}
	}

}
