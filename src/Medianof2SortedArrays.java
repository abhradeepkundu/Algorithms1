
public class Medianof2SortedArrays {

	public Medianof2SortedArrays() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	private void run() {
		// TODO Auto-generated method stub
		int ar1[] = {1, 12, 15, 26, 38};
		   int ar2[] = {2, 13, 17, 30, 45};
		int result = getMedian(ar1,ar2,0,ar1.length-1);
		//int result = getMedian1(ar1,ar2);
		System.out.println("The Median of 2 sorted arrays are : " + result);
	}
	
/***
 * function to get the Median of 2 sorted arrays in O(logn) time
 * */
	/**	 
	 *  (By doing binary search for the median):
The basic idea is that if you are given two arrays ar1[] and ar2[] and know the length of each, you can check whether 
an element ar1[i] is the median in constant time. Suppose that the median is ar1[i]. Since the array is sorted,
 it is greater than exactly i values in array ar1[]. Then if it is the median, it is also greater than exactly j = n Ð i Ð 1 elements in ar2[].
It requires constant time to check if ar2[j] <= ar1[i] <= ar2[j + 1]. If ar1[i] is not the median, then depending 
on whether ar1[i] is greater or less than ar2[j] and ar2[j + 1], you know that ar1[i] is either greater than or less than the median.
 Thus you can binary search for median in O(lg n) worst-case time.

For two arrays ar1 and ar2, first do binary search in ar1[]. If you reach at the end (left or right) of 
the first array and don't find median, start searching in the second array ar2[].

1) Get the middle element of ar1[] using array indexes left and right.  
   Let index of the middle element be i.
2) Calculate the corresponding index j of ar2[]
     j = n Ð i Ð 1 
3) If ar1[i] >= ar2[j] and ar1[i] <= ar2[j+1] then ar1[i] and ar2[j]
   are the middle elements.
     return average of ar2[j] and ar1[i]
4) If ar1[i] is greater than both ar2[j] and ar2[j+1] then 
     do binary search in left half  (i.e., arr[left ... i-1])
5) If ar1[i] is smaller than both ar2[j] and ar2[j+1] then
     do binary search in right half (i.e., arr[i+1....right])
6) If you reach at any corner of ar1[] then do binary search in ar2[]
Example:

   ar1[] = {1, 5, 7, 10, 13}
   ar2[] = {11, 15, 23, 30, 45}
Middle element of ar1[] is 7. Let us compare 7 with 23 and 30, since 7 smaller than both 23 and 30, move to right in ar1[].
 Do binary search in {10, 13}, this step will pick 10. Now compare 10 with 15 and 23. Since 10 is smaller than both 15 and 23, again move to right.
  Only 13 is there in right side now. Since 13 is greater than 11 and smaller than 15, terminate here. We have got the median as 12 (average of 11 and 13)
	 * */
	public int getMedian(int[] a,int[] b,int left,int right) {		
		int i,j;
		i = (left + right)/2;
		j = a.length - i - 1;
		if(left > right)
			return getMedian(b, a, 0, a.length-1);
		if(a[i] > b[j] && ( j == a.length-1 || a[i] < b[j+1] ) ) {
			if(b[j] > a[i-1] || i == 0) {
				return (a[i] + b[j])/2;
			}else {
				return (a[i] + a[i-1])/2;
			}
		}
		else if(a[i] > b[j+1] && j < a.length && a[i] > b[j])
			return getMedian(a, b, left, i-1);
			
		else 
			return getMedian(a, b, i+1, right);				
	}
	/***
	 * function to get the Median of 2 sorted arrays in O(n) time
	 * */
	public int getMedian1(int[] a,int[] b) {
		int count;int i = 0;int j = 0;
		int m1 = -1; int m2 = -1;
		for(count = 0; count <= b.length; ++count) { 
			if(i == a.length) {
				m1 = m2;
				m2 = b[0];
				break;
			}else if (j == b.length) {
				m1 = m2;
				m2 = a[0];
				break;
			}
			if(a[i] < b[j]) {
				m1 = m2;
				m2 = a[i++];				
			}else {
				m1 = m2;
				m2 = b[j++];
			}			
		}
			System.out.println(m1 + ":" + m2);
		return (m1 + m2)/2;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Medianof2SortedArrays();
	}

}
