class Solution {

/*
Instead of setting again all values of the counters equal with max everytime max_counter
needs to be called, I just save the max at the point max_counter should be called
and I assign those values while the algorithm is running, or at the end.
*/
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0;
		int lastMax = 0;
        for(int i=0;i<A.length;i++){
            if (A[i]==N+1){
				lastMax=max;
            } else if(A[i]<=N){
    			if(counters[A[i]-1]<lastMax){
    				counters[A[i]-1] = lastMax+1;
    			}
    			else{
    				counters[A[i]-1]++;
    			}
                if (max<counters[A[i]-1]){
    				max=counters[A[i]-1];
    			}   
            }
        }
		
    	for (int i=0;i<counters.length;i++){
    		if(counters[i]<lastMax){
    	    	counters[i]=lastMax;
    		}
    	}
    	
        return counters;
    }
}
