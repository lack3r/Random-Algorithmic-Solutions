/**
 * @author Andreas Loizou
 * Quicksort
 **/

import java.util.Random;

public class Main {

	
	private static void swap(int[] A, int index1, int index2) {
		int temp = A[index1];
		A[index1] = A[index2];
		A[index2] = temp;
	}

	private static int partition(int[] A, int l, int r, int pivot) {
		while (l < r) {
			while(A[l]<pivot && l<r){
				l++;
			}
			while(A[r]>=pivot && l<r){
				r--;
			}
			if (l==r){
				break;
			}
			if (A[l] >= pivot) {
				swap(A, l, r);
			} 
		}
		return l;
	}

	/*
	 * Quicksort
	 */
	public static void Quicksort(int[] A, int l, int r) {
		if (A == null || !(A instanceof int[])) {
			throw new IllegalArgumentException();
		}
		if (l>=r) {
			return;
		}
		int pivotIndex = (l+r) / 2;
		int pivot = A[pivotIndex];
		/* transfer pivot to the right */
		swap(A, r, pivotIndex);
		int k = partition(A, l,r-1, pivot);
		if (A[r]<A[k]){
			swap(A, k, r);
		}
		Quicksort(A,l,k-1);
		Quicksort(A,k+1,r);
	}

	public static int[] getRandomArray(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException();
		}
		int[] A = new int[size];
		Random r = new Random();
		for (int i = 0; i < A.length; i++) {
			A[i] = r.nextInt(1000);
		}
		return A;
	}

	public static void print(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + ",");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] A = getRandomArray(20);
		//int[] A = {8,5,9,3,20};
		print(A);
		Quicksort(A,0,A.length-1);
		print(A);
	}

}
