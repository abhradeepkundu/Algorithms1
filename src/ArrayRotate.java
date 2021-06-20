import java.util.HashMap;
import java.util.Map;


public class ArrayRotate {

	public ArrayRotate() {
		this.run();
	}

	private void run() {
		// TODO Auto-generated method stub
		//int[] a = {1,2,3,4,5,6} ;//{4,1,6,9,2,5,8,3,7}; // 
		//rotateKTimes(a,4);
		//int[] a = {4,5,6};
		int[] a = {1,2,3,4};
		//int[] b = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		//int[] b = { 15, 16, 19, 20, 25, 26, 27, 1, 2, 3, 4, 5, 7, 8, 9, 10, 14};
		
		//System.out.println(search(b,0,b.length-1,25));
		//System.out.println(pivotedBinarySearch(b,b.length-1,14));
		//findMAXORs(a);
		char[] str = new char[100];
		_printParenthesis(str,0,4,0,0);
	}
	

	
	
	 
	void _printParenthesis(char[] str,int pos, int n, int open, int close) {
	  if(close == n) {
	    System.out.println(str);
	    return;
	  }
	  else {
	    if(open > close) {
	        str[pos] = ')';
	        _printParenthesis(str,pos+1, n, open, close+1);
	    }
	    if(open < n) {
	       str[pos] = '(';
	       _printParenthesis(str,pos+1, n, open+1, close);
	    }
	  }
	}
	
	
	private void findMAXORs(int[] a) {
		int numOfSubSets = 1 << a.length;
		int bitMask;int pos; 
		Map<Integer,String> map = new HashMap<Integer, String>();
		for(int i = 0; i < numOfSubSets;++i) {
			bitMask = i;
			pos = a.length-1;
			System.out.print("{");
			int[] arr = new int[a.length];
			int j = 0;
			while(bitMask > 0) { 
				if( (bitMask & 1) == 1) {
					System.out.print(a[pos] + ",");
					arr[j++] = a[pos];
				}
				bitMask >>= 1;
				pos--;
			}
			System.out.print("}");
//			if(pos == 2) {
//				map.put(arr[0], Integer.toString(arr[0]));
//			}else {
//				
//			}
//			printArray(arr);
		}
	}
	
/**	
	Given a sorted array of n integers that has been rotated an unknown number of times,
	give an O(logn) algorithm that finds an element in the array You may assume that the
	array was originally sorted in increasing order
	
	EXAMPLE:
	Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14) Output: 8 (the index of 5 in the array)
		ex : 15 16 19 20 25 26 27 1 2 3 4 5 7 8 9 10 14
	**/
	public static int search(int a[], int l, int u, int x) {
		while (l <= u) {
		int m = (l + u) / 2;
		if(x==a[m]){
			return m;
		} 
		else if (a[l] <= a[m]) {
			/**
			 * This condition is true if the array is sorted from 0 to mid array is sorted
			 * */
				if (x > a[m]) {
					l = m+1;
				}
				else if (x >=a [l]) {
					u = m-1;
				}
				else {
					l = m+1;
				}
		}
		else if(x<a[m]) {
			/*** This condition is true if the array is not sorted from 0 till mid
			 * and second half from mid till end is sorted	
			 * */
			u=m-1;
		}
		else if(x<=a[u]) {
			/** if the element is smaller than the last element in the array, then at this point element will
			 * be present between mid and last index of the array*/
			l=m+1;
		}
		else {
			/** here, the element will be present between first and mid of the array*/
			u = m - 1;
			}
		}
		return -1; 
	}

	
	/** Recursive approach
	 * @param a
	 * @param k
	 */
	
	
	int pivotedBinarySearch(int arr[], int arr_size, int no)
	{
	   int pivot = findPivot(arr, 0, arr_size-1);
	 
	   // If we didn't find a pivot, then array is not rotated at all
	   if (pivot == -1)
	     return binarySearch(arr, 0, arr_size-1, no);
	 
	   // If we found a pivot, then first compare with pivot and then
	   // search in two subarrays around pivot
	   if (arr[pivot] == no)
	     return pivot;
	   if (arr[0] <= no)
	     return binarySearch(arr, 0, pivot-1, no);
	   else
	     return binarySearch(arr, pivot+1, arr_size-1, no);
	}
	 
	/* Function to get pivot. For array 3, 4, 5, 6, 1, 2 it will
	   return 3. If array is not rotated at all, then it returns -1 */
	int findPivot(int arr[], int low, int high)
	{
	   // base cases
	   if (high < low)  return -1;
	   if (high == low) return low;
	 
	   int mid = (low + high)/2;   /*low + (high - low)/2;*/
	   if (mid < high && arr[mid] > arr[mid + 1])
	     return mid;
	   if (mid > low && arr[mid] < arr[mid - 1])
	     return (mid-1);
	   if (arr[low] >= arr[mid])
	     return findPivot(arr, low, mid-1);
	   else
	     return findPivot(arr, mid + 1, high);
	}
	
	int binarySearch(int arr[], int low, int high, int no)
	{
	   if (high < low)
	       return -1;
	   int mid = (low + high)/2;  /*low + (high - low)/2;*/
	   if (no == arr[mid])
		   
	     return mid;
	   if (no > arr[mid])
	     return binarySearch(arr, (mid + 1), high, no);
	   else
	     return binarySearch(arr, low, (mid -1), no);
	}
	
	
	private void rotateKTimes(int[] a, int k) {
		// TODO Auto-generated method stub
		printArray(a);
		reverse(a,0,a.length-1);
		//printArray(a);
		reverse(a,0,k-1);
		//printArray(a);
		reverse(a,k,a.length-1);
		printArray(a);
	}

	private void reverse(int[] a,int start, int end) {
		// TODO Auto-generated method stub
		int temp;
		int i = start;
		int j = end;
		while(i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			++i;--j;
		}
	}
	public void printArray(int[] a) {
		for( int i=0;i<a.length;++i)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ArrayRotate();
	}

}
