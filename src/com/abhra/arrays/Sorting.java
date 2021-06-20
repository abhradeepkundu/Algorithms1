package com.abhra.arrays;
/**
 * 01-Mar-2016
 * */
public class Sorting {
	
	Sorting() {
		run();
	}

	private void run() {
		int[] a = {5,2,4,7,10,12,3,8,6};
		int[] temp = new int[a.length];
		printArray(a);
		mergeSort(a,temp,0,a.length-1);
		printArray(a);
	}

	private void mergeSort(int[] a, int[] temp, int start, int end) {
		if(start < end) {
			int mid = (start+end)/2;
			mergeSort(a,temp,start,mid);
			mergeSort(a,temp,mid+1,end);
			merge(a,temp,start,mid+1,end);
		}
	}

	private void merge(int[] a, int[] temp, int start, int mid, int end) {
		int i = start, j = mid, k=start;
		while(i <= mid-1 && j <= end) {
			if(a[i] <= a[j]) 
				temp[k++] = a[i++];
			else 
				temp[k++] = a[j++];
		}
		while(i<=mid-1) {
			temp[k++] = a[i++];
		}
		while(j<=end) {
			temp[k++] = a[j++];
		}
		for(i=start;i<=end;i++) {
			a[i] = temp[i];
		}
	}
	
	void printArray(int[] a) {
		for(int i=0; i<a.length;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Sorting();
	}

}
