public class GenerateSpiralMatrix {

	public GenerateSpiralMatrix() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	public void run() {
		int a[][] = new int[5][5];
		GenSpiralMatr(a,5);
	}
	public void GenSpiralMatr(int[][] a,int order) {
		int p=0,n=0;
		char mov[] = {'u','r','d','l'};
		int i = (order + 1)/2 -1 ;
		int j = (order + 1)/2 -1 ;
		int mat[][] = new int[5][5];
		mat[i][j] = ++n;
		while(n < (order * order)) {
			switch(mov[p]) {
			case 'u' : i--;
			break;
			case 'r' : j++;
			break;
			case 'd' : i++;
			break;
			case 'l' : j--;
			break;
			}
			mat[i][j] = ++n;
			System.out.print(mat[i][j] + " ");
			
			p = (p+1)%4;
			int c=i;
			int d=j;
			switch(mov[p]) {
			case 'u' : c--;
			break;
			case 'r' : d++;
			break;
			case 'd' : c++;
			break;
			case 'l' : d--;
			break;
			}
			if(mat[c][d] != 0)
				p = (p+3)%4;
		
		}					
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GenerateSpiralMatrix();
	}

}
