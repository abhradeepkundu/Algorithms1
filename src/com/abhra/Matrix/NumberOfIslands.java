package com.abhra.Matrix;

public class NumberOfIslands {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int M[][]=  new int[][] 
				{{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
               };
		System.out.println(countIslands(M));
	}

	private final static int R = 5;
	private final static int C = 5;
	
	private static int countIslands(int[][] a) {
		int count=0;
		boolean[][] visited = new boolean[R][C];
		for(int i=0;i<R;i++)
			for(int j=0;j<C;j++) {
				if(a[i][j] == 1 && !visited[i][j]) {
					DFS(a,i,j,visited);
					count++;
				}Integer.MIN_VALUE
			}
		return count;
	}

	private static void DFS(int[][] a, int i, int j, boolean[][] visited) {
		int[] rNeighbours = {-1,-1,-1,0,0,1,1,1};
		int[] cNeighbours = {-1,0,1,-1,1,-1,0,1};
		
		visited[i][j] = true;
		
		for(int k=0;k<8;k++)
			if(isSafe(a,i+rNeighbours[k],j+cNeighbours[k],visited))
				DFS(a,i+rNeighbours[k],j+cNeighbours[k],visited);
	}

	private static boolean isSafe(int[][] a, int i, int j, boolean[][] visited) {
		return ((i>= 0) && (i<R) && (j>=0)&&(j<C) && (a[i][j] ==1 && !visited[i][j]));
	}

}
