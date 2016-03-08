// you can also use imports, for example:
// import java.math.*;
class Solution {
    public int solution(int X, int[] A) {
        // write your code in Java SE 7
        int leavesPositions=0; //At how many *different* places leaves have appeared.
        boolean[] leaves = new boolean[X+1];
        for (int i=0;i<X+1;i++){
            leaves[i]=false;
        }
        for (int i=0;i<A.length;i++){
            if (leaves[A[i]]==false){
                leaves[A[i]]=true;
                leavesPositions++;
                if (leavesPositions==X){
                    return i;
                    
                }
            }
        }
        return -1;
    }
}
