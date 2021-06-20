import javax.naming.BinaryRefAddr;


public class Arrays {

	public Arrays() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	public void run() {
		
		maxSubArray();
		
		/*int[] a = {1, 2, 3, 3, 3, 3, 10};
		int x=3;
		int eqInd = getEqIndex(a);
		System.out.println("Equilibrium index of tha array is " + eqInd);*/
		//maxdiff(a);
		/*
		int result = isMajority(a);
		if(result == 1)
			System.out.println("Majority element is found : " + result);
		else
			System.out.println("Majority element is not found");*/
		/*int ceil = ceilSearch(a,0,a.length,x);
		System.out.println("The ceil of " + x + "is : " + ceil);*/
		
		//findMinDistance();
		//System.out.println(isAnagram("test","TeST",false));
		//int[] a = {1,2,3,4,5,6,7,8,9};
		//printArray(a);
		//int index = binarySearch(a,0,a.length-1,2);
		System.out.println();
		//System.out.println("index : " + index);
		int a[] = {3, 2, 7, 10};
		//System.out.println("Max sum : " + maxSumWithNoTwoAdjElements(a));
//		int[] set = {3, 34, 4, 12, 5, 3};
		System.out.println();
		
	//	System.out.println("Answer : "+isSubsetSum(set,set.length,6));
		
	}
	
	
	// Returns true if there is a subset of set[] with sun equal to given sum
	boolean isSubsetSum(int set[], int n, int sum)
	{
	    // The value of subset[i][j] will be true if there is a subset of set[0..j-1]
	    //  with sum equal to i
	    boolean[][] subset = new boolean[sum+1][n+1];
	 
	    // If sum is 0, then answer is true
	    for (int i = 0; i <= n; i++)
	      subset[0][i] = true;
	 
	    // If sum is not 0 and set is empty, then answer is false
	    for (int i = 1; i <= sum; i++)
	      subset[i][0] = false;
	 
	     // Fill the subset table in botton up manner
	     for (int i = 1; i <= sum; i++)
	     {
	       for (int j = 1; j <= n; j++)
	       {
	         subset[i][j] = subset[i][j-1];
	         if (i >= set[j-1])
	           subset[i][j] = subset[i][j] || subset[i - set[j-1]][j-1];
	       }
	     }
	 
	     // uncomment this code to print table
	     for (int i = 0; i <= sum; i++)
	     {
	       for (int j = 0; j <= n; j++)
	          System.out.print(subset[i][j] + "  ");
	       	System.out.println();
	     } 
	 
	     return subset[sum][n];
	}
	/***
	 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum
	 * Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
	 * 
	 * */
	
	
	
	/***
	 * Maximum sum such that no two elements are adjacent
	 * http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
	 * */
	private int maxSumWithNoTwoAdjElements(int[] a) {
		if(a.length == 1)
			return a[0];
		
		if(a.length == 2)
			return max(a[0],a[1]);
		if(a.length ==3)
			return max(a[0]+a[2],a[1]);
		int sum1 = a[0];
		int sum2 = a[1];
		int i = 2;
		boolean flip = true;
		
		while(i < a.length) {
			if(flip) {
				sum1 += a[i];
			}else{
				sum2 += a[i];
			}
			flip = !flip;
			i++;
		}
		return max(sum1,sum2);
	}
	private int max(int sum1, int sum2) {

		return sum1 > sum2 ? sum1 : sum2;
	}
	

	private void printArray(int[] a) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i< a.length; ++i)
			System.out.print(a[i] + " ");
	}
	
	int binarySearch(int[] a,int first,int last,int key) {
		int index;
		
		if(first > last) {
			return -1;
		}
		int mid = (first+last)/2;
		System.out.println();
		System.out.println("mide : " + mid);
		if(key == a[mid])
			return mid;
		if(key < a[mid])
			index = binarySearch(a, first, mid-1, key);
		else 
			index = binarySearch(a, mid+1, last, key);
		return index;
			
	}
	public int ceilSearch(int a[], int low, int high, int x) {
		if (a.length <= 1) {
			System.out.println("Invalid input array");
			return -1;
		}
		if (high >= low) {
			if (x < a[low])
				return a[low];
			if (x > a[high])
				return -1;

			int mid = (low + high) / 2;
			if (a[mid] == x)
				return a[mid + 1];
			else if (a[mid] < x)
				return ceilSearch(a, low, mid - 1, x);
			else
				return ceilSearch(a, mid + 1, a.length, x);
		}
		return -1;
	}
	public int isMajority(int a[]) {
		
		int x =2;
		int len = a.length;
		System.out.println( "Array length : " + len);
		if(len <= 1)
			return -1;
		int i = _binarySearch(a,0,len,x);
		System.out.println("Value of i is : " + i);
		if(i < (len ) && a[(i+len)/2] == x)
			return 1;
		else 
			return 0;
	}
	public int _binarySearch(int a[],int low,int high,int x) {
		if(high >= low) {
			int mid = (low+high)/2;
			if(mid == 0 || a[mid -1] < x && (a[mid] == x))
				return mid;
			if(x > a[mid])
				return _binarySearch(a, mid+1, high, x);
			else
				return _binarySearch(a, low, mid -1, x);
		}
		
		return -1;
	}
	public void maxdiff(int a[]) {
		int curmin_ele = a[0];
		int max_diff=0;
		int cur_diff;
		for(int i=1;i<a.length;i++) {
			cur_diff = a[i] - curmin_ele;
			if(cur_diff > max_diff)
				max_diff = cur_diff;
			if(a[i] < curmin_ele)
				curmin_ele = a[i];
		}
		System.out.println("The max diff is : " + max_diff);
	}
	public int getEqIndex(int a[]) {
		if(a.length < 1)
			return -1;
		int sum=0,leftsum=0;
		for(int i=0;i<a.length;i++)
			sum+=a[i];
		for(int i=0;i<a.length;i++) {
			sum-=a[i];
		if(leftsum==sum)
			return i;
			
			leftsum+=a[i];
		}		
		return -1;
	}
public void sort0and1s(int a[]) {
	if(a.length < 1)
		return;
	 int left = 0,right = a.length -1,temp;
	 while(left < right) {
		 	 
	 while(a[left] == 0 &&  left < right)
		 left++;
	 
	 while(a[right] == 1 &&  left < right)
		 right--;
	 
	 	if(left < right) {
	 		temp = a[left];
	 		a[left] = a[right];
	 		a[right] = temp;
	 	}	 
	}
}
	 /****
	  * Maximum sub Array
	  * */

	public void maxSubArray() {
		//int[] a = {-5,-6,-8,-3,-9,-7};
//		int[] a = {12,-10,17,-20,15};
//		int curSum = a[0];
//		int maxSum = a[0];
//		int maxCurIndex = Integer.MIN_VALUE;
//		int maxEndIndex = Integer.MIN_VALUE;
//		int curMaxIndex = Integer.MIN_VALUE;
//		
//		for(int i = 1; i < a.length;++i) {
//			if(curSum < 0) {
//				curSum = 0;
//				curMaxIndex = i;
//			}
//			curSum = curSum + a[i];
//			if(curSum > maxSum) {
//				maxSum = curSum;
//				maxCurIndex = curMaxIndex;
//				maxEndIndex = i;
//			}
//		}
//		System.out.println(maxSum);
		int n = 6;
        StringBuilder str = new StringBuilder();
		for(int i=1;i<n;++i) {
            str.append(" ");
           /** int j = n-i;
            while(j>=0) {
                System.out.print(" ");
                j--;
            }
           System.out.print("#");
           System.out.println("");
           */
        }
        str.append("#");
        for(int j=n-1;j>=0;--j) {
        	str.setCharAt(j, '#');
            System.out.println(str);
        }
		//System.out.println("Max sub array indices are : " + maxCurIndex + " => " + maxEndIndex);
	}

	
	public void findMinDistance() {
		/*int pos1 = 0,pos2 = 0;
		int[] a = {4, 1, 5, 3, 5, 5, 0, 2, 2, 4};
		int minDist = a.length; 
		int curDist = 0;
		int num1 = 4;int num2 = 5;
		
		for(int i = 0; i < a.length;++i) {
			if(a[i] == num1 || a[i] == num2) {
				if(a[i] == num1) {
					pos1 = i;
				}else if(a[i] == num2) {
					pos2 = i;
				}
				curDist = Math.abs(pos1-pos2);
				System.out.println(" pos1 : " +  pos1  + " pos2 => " + pos2 + " curDist => " + curDist);
				if(curDist < minDist) {					
					minDist = curDist;
					System.out.println(" min Dist => " + minDist);
				}
			}
		}*/		
		int[] inputArray = {4, 4, 4, 3, 1, 5, 5, 7, 2, 5};
		int num1 = 4;int num2 = 5;
		 int pos1;
		 int pos2;
		 int distance;
		 int newDistance;
		    pos1 = pos2 = distance = inputArray.length;
		 
		   for (int i = 0; i < inputArray.length; i++)
		   {
		      if (inputArray[i] == num1)
		         pos1 = i;
		      else if (inputArray[i] == num2)
		         pos2 = i;
		 
		      if (pos1 < inputArray.length && pos2 < inputArray.length)
		      {
		       newDistance = Math.abs(pos1 - pos2);
		         if (distance > newDistance)
		            distance = newDistance;
		      }
		   }	
		   System.out.println("Min distance between " + num1 + " and " + num2 + " is " + distance);
	}
	
		int getHash(String str){	
			  char[] chars=str.toCharArray();
			  int sum=0;			  
			  for(int val:chars){
				  System.out.println("val => " + val);
			    sum+=val;
			  }
			  return sum;
		}
		public boolean isAnagram(String str1,String str2,boolean isCaseSensitive){
			  str1=(isCaseSensitive)?str1:str1.toUpperCase();
			  str2=(isCaseSensitive)?str2:str2.toUpperCase();
			  System.out.println("str1 => " + str1);
			  System.out.println("str2 => " + str2);
			  return (getHash(str1)==getHash(str2));
		}
		void printArray(char[] a) {
			for(int i = 0; i< a.length; ++i)
				System.out.print(a[i] + " ");
		}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("shams");
			new Arrays();
	}

}
