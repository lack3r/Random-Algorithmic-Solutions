//TapeEquilibrium
import java.io.*;
import java.math.*;
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 7
        Integer minValueUntilNow = new Integer(Integer.MAX_VALUE);
        int P=0;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0;i<A.length;i++){
            rightSum+=A[i];
        }
        if (A.length==0) return 0;
		int difference = 0;
        for (int i=0;i<A.length-1;i++){
            leftSum+=A[i];
            rightSum-=A[i];
            difference = Math.abs(leftSum-rightSum);
            if (difference<minValueUntilNow){
                minValueUntilNow = difference;
                P = i;
            }
        }
        return minValueUntilNow;
    }
}
