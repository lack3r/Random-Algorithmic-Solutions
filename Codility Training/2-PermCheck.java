// you can also use imports, for example:
// import java.math.*;
class Solution {
    public int solution(int[] A) {
        int n = A.length;
        boolean[] shown = new boolean[n+1];
        for (int i=1;i<n+1;i++){
            shown[i]=false;
        }
        for (int i=0;i<n;i++){
            if (A[i]>n||A[i]<=0){
                return 0;
            }
            if(!shown[A[i]]){
                shown[A[i]]=true;
            }else{
                return 0;
            }
            
            
        }
        return 1;
    }
}
