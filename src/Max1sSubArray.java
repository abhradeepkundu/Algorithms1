
public class Max1sSubArray {

	public Max1sSubArray() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	  public static final int R = 6;
	  public static final int C = 5;
	public void run() {
		int M[][] = 
			    {
				{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
                };
		maxSubArray(M);
	}
	public void maxSubArray(int m[][]) {
		int[][] s = new int[R][C];
		/* Set first column of S[][]*/
		  for(int i = 0; i < R; i++)
		     s[i][0] = m[i][0];
		 
		  /* Set first row of S[][]*/
		  for(int j = 0; j < C; j++)
		     s[0][j] = m[0][j];
		  
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (m[i][j] == 1)
					s[i][j] = min(s[i - 1][j - 1], s[i - 1][j], s[i][j - 1]) + 1;
				else
					s[i][j] = 0;
			}
		}
		int max_of_s = s[0][0], max_of_i = 0, max_of_j = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (max_of_s < s[i][j]) {
					max_of_s = s[i][j];
					max_of_i = i;
					max_of_j = j;
				}//System.out.print(s[i][j] + " ");
			}//System.out.println();
		}
		//System.out.println(max_of_s + " "  + max_of_i + " " + max_of_j);
		for(int i = max_of_i; i > (max_of_i - max_of_s); i--) {
			for(int j = max_of_j; j > (max_of_j - max_of_s) ; j--) {
				System.out.print(m[i][j]);
			}
			System.out.println();	
		}				
	}
	public int min(int a,int b,int c) {
		int min = a;
		if(min > b)
			min = b;
		if(min > c)
			min = c;	
		return min; 
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Max1sSubArray();
	}

}
