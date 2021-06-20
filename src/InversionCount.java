
public class InversionCount {

	public InversionCount() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	private void run() {
		// TODO Auto-generated method stub
		int[] a = {2,4,7,1,6,3,5};
		int[] temp = new int[a.length];
		//mergeSort(a,temp,0,a.length-1);
		//printArray(a);
		quicksort(a,0,a.length-1);
		System.out.println();
		System.out.println("The Inversion count is : " + this.invCount);
	}
	
//	private int mergeSort(int[] a, int[] temp, int p, int r) {
//		// TODO Auto-generated method stub
//		int invCount = 0;
//		if(p < r) {
//			int q = (p+r)/2;
//			invCount = mergeSort(a, temp, p, q);
//			invCount += mergeSort(a, temp, q+1,r);
//			invCount += merge(a,temp,p,q+1,r);
//		}
//		return invCount;
//	}
//
//	private int merge(int[] a, int[] temp, int left, int mid, int right) {
//		// TODO Auto-generated method stub
//		int i = left;
//		int j = mid;
//		int k = left;
//		 int invCount = 0;
//		while(i <= (mid-1) && j <= right) {
//			if(a[i] <= a[j])
//				temp[k++] = a[i++];
//			else {
//				temp[k++] = a[j++];
//				invCount = invCount + (mid-i);
//			}
//		}
//		while(i <= (mid-1)) 
//			temp[k++] = a[i++];
//		while(j <= right) 
//			temp[k++] = a[j++];
//		for(i = left; i <= right; ++i)
//			a[i] = temp[i];
//		return invCount;
//	}
	
	private void quicksort(int[] a,int p,int r) {
		// TODO Auto-generated method stub
		
		/**
		 * int[] a = {5,2,4,7,10,12,3,8,6}; {5,2,4,3,10,12,7,8,6};
		 * 
		 * 1st iteration : {5,2,4,3,1,7,8,6}
		 * 2nd iteration : {1,2,4,3,5,7,8,6}
		 * 
		 * */
		if( p < r) {
			int q = Partition(a,p,r);
			quicksort(a,p,q-1);
			quicksort(a,q+1,r);
		}
	}

	private int Partition(int[] a, int p, int r) {
		// TODO Auto-generated method stub
		int pivot = a[p];
		int i=p+1;
		int j=r;
		int pivotIndex;
		
		while(true) {
			while(i < j && a[i] < pivot)
				++i;
			while(j > i && a[j] > pivot)
				--j;
			if(i < j)
				swap(a,i,j);
			else
				break;
		}
		if(a[j] > a[j-1])
			pivotIndex = j-1;
		else
			pivotIndex = j;
		swap(a,p,pivotIndex);
		return pivotIndex;
	}
	int invCount = 0;
	private void swap(int[] a, int j, int i) {
		// TODO Auto-generated method stub
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		invCount += 1;
		System.out.println();
		//System.out.println("swapping " + a[i] + " with " + a[j] + "      i = " + j + "  j = " + i);
		//printArray(a);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InversionCount();
	}

}
