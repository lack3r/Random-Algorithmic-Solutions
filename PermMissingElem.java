//codility PermMissingElem problem
class Solution {

    public long sum(int[] A){long sum=0;for (int i=0;i<A.length;i++){sum+=A[i];} return sum;}
    public int solution(int[] A) {
        long sum = ((long)A.length+1)*((long)A.length+2)/2;
        return (int) (sum-sum(A));
    }
}
