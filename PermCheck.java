class Solution {
    public int solution(int[] A) {
        for (int i=0;i<A.length;i++){
            boolean[] found = new boolean[A.length]; 
            if (A[i]<=0||A[i]>A.length||found[A[i]-1]){return 0;}
			found[A[i]-1]=true;
            }
			return 1;
    }
}
