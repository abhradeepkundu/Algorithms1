
public class SpiralMatrix {

	public SpiralMatrix() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	public void run(){
		int[][] a = { 
				{1,  2,  3,  4,  5,  6},
		        {7,  8,  9,  10, 11, 12},
		        {13, 14, 15, 16, 17, 18}
		    };
		//printSprialOrder(a,3,6);
		printSpiralInOppOrder(a,3,6);
	}
	
	/**
	 * function prints the Matrix in the form
	 *   first row
	 *   last column
	 *   last row
	 *   first column
	 * */
	public void printSprialOrder(int[][] a,int r,int c) {
		int k=0,l=0;
		while(k < r && l < c) {
			
			for(int i=k; i<c; i++)
				System.out.print(a[k][i]+ " ");
			k++;
			//System.out.print(" k = " + k);
			for(int i = k;i < r; i++)
				System.out.print(a[i][c-1]+ " ");
			c--;
			//System.out.print(" c = " + c);
			if ( k < r){
			for(int i=c-1;i>=l;i--)
				System.out.print(a[r-1][i]+ " ");
			r--;
			//System.out.print(" r = " + r);
			}
			for(int i=r-1; i>=k; i--)
				System.out.print(a[i][l] + " ");
			l++;			
			//System.out.print(" l = " + l);
		}
	}
	
	public void printSpiralInOppOrder(int[][] a,int r,int c) {
		int k=0,l=0;
		while(k < r && l < c) {
			for(int i= l; i< r;i++)
				System.out.print(a[i][l] + " " );
			l++;
			//System.out.print(" apple = " + l);

			for(int i=l;i<c;i++)
				System.out.print(a[r-1][i]+ " " );
			r--;

			//System.out.print(" mango = " + r);
			
			for(int i=r-1;i>=k;i--)
				System.out.print(a[i][c-1]+ " " );
			c--;
			//System.out.print(" grape = " + c);
			
			
			for(int i=c-1;i>=l;i--)
				System.out.print(a[k][i]+ " ");
				k++;
				//System.out.print(" shams = " + k);

		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SpiralMatrix();
	}

}
