
public class Squareroot {

	public Squareroot() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	private void run() {
		// TODO Auto-generated method stub
		int x = 101;
		squareRoot(x);
	}

//	private double squareRoot(int x) {
//		// TODO Auto-generated method stub
//		int i;
//		double result=-1;
//		for(i = 1;i<(x/2);++i) {
//			if((i*i) <= x)
//				continue;
//			else 
//				break;
//		}System.out.println(--i);
//		if((i)*(i) == x){return i;}
//		result = binarySearch(i,i+1,x);
//		System.out.println("result => " + result);
//		return result;
//	}
//
//	private  double binarySearch(double start, double end,int x) {
//		// TODO Auto-generated method stub
//		double i = start;
//		double j = end;
//		
//		double mid = (i+j)/2;
//		
//		if((j - i ) < 0.000001)
//		{
//			return mid;
//		}
//		
//		if(mid*mid > x)
//		{
//			return binarySearch(i, mid, x);
//			
//		}else if(mid*mid < x)
//		{
//			return binarySearch(mid,j, x);
//			
//		}else
//		{
//			return mid;
//		}
//
//	}
	
	
	

	private double squareRoot(int x) {
		int i;
		for(i=1;i<=(x/2);++i) {
			if(i*i <=x)
				continue;
			else 
				break;
		}
		i--;
		if((i*i) == x) return i;
		double result = binarySearch(i,i+1,x);
		System.out.println("result : " + result);
		return result;
		
	}

	private double binarySearch(double start,double end,int x) {
		double mid = (start+end)/2;
		double midSquare = mid*mid;
		if((end-start) < 0.000001)
			return mid;
		if((midSquare) == x)
			return mid;
		if(midSquare > x)
			return binarySearch(start, mid, x);
		else if(midSquare < x) 
			return binarySearch(mid, end, x);
		else 
			return mid;
	}

	
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Squareroot();
	}

}
