// you can also use imports, for example:
// import java.math.*;
class Solution {
    public int solution(int[] A) {
        int n=A.length;
        int[] west = new int[n];

        if (A[0]==1){
            west[0] = 1;
        }

        for (int i=1;i<n;i++){
            if (A[i]==1){
                west[i] = west[i-1]+1;
            }
            else{
                west[i]=west[i-1];
            }
        }

        int counter=0;
        for(int i=0;i<A.length;i++){
            if (A[i]==0){
                counter+=west[n-1]-west[i];
            }
            if (counter>1000000000){
            return -1;
        }
        }
        return counter;
    }
}
