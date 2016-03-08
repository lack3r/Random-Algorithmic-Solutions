// you can also use imports, for example:
// import java.math.*;
class Solution {
		    public static void mergeSort(int[] A, int B[],int l, int r){
		        if (r==l||r<l) {return;}
		        if (r==l+1){
		            if (A[l]>A[r]){
		                int temp = A[r];
		                A[r] = A[l];
		                A[l] = temp;
		            }
		            return;
		        }
		        int k = (l+r)/2;
		        mergeSort(A,B,l, k);
		        mergeSort(A,B,k+1,r);
		        int i=l;
		        int j=k+1;
		        int index=l;
		        while(i<=k && j<=r){
		        	if (A[i]<=A[j]){
		        		B[index]=A[i];
		        		i++;
		        	}
		        	else{
		        		B[index]=A[j];
		        		j++;
		        	}
		        	index++;
		        }
		        int from;
		        if (i>k){
		        	from=j;
		        }else{
		        	from=i;
		        }
		        if (i<=k || j<=r){
		        for (;index<=r;index++){
		        	B[index]=A[from];
		        	from++;
		        }
		        }
		        //B[r]=Math.max(A[i], A[j]);
		        
		        for (i=l;i<=r;i++){
		        	A[i]=B[i];
		        }
		    }
		    public int solution(int[] A) {
		    	int[] B = new int[A.length];
		        mergeSort(A,B,0,A.length-1);
		        int counter=0;
		        if (A.length==1){
		            return 1;
		        }
		            if (A.length>0){
		            	counter++;
		            }
		        for (int i=1;i<A.length;i++){
		            if (A[i]!=A[i-1]){
		                counter++;
		            }
		        }
		        return counter;
		    }
}
