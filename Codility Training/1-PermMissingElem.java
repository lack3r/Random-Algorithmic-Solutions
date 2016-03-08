class Solution {
    public int solution(int[] A) {
        long sum=0;
        //I am using this to get the same result in O(1) 
         sum = ((long) A.length+1)*((long) A.length+2)/2;

        for(int i=0;i<A.length;i++){
            sum-=A[i];
        }
        return (int) sum;
    }
}
