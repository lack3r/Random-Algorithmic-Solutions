class Solution {
    public static int isTriangular(int []A,int P,int Q,int R){
        if (!(((long)A[P]+A[Q])>A[R])){return 0;}
        if (!(((long)A[Q]+A[R])>A[P])){return 0;}
        if (!(((long)A[R]+A[P])>A[Q])){return 0;}
        return 1;
    }
    public int solution(int[] A) {
        int n=A.length;
        java.util.Arrays.sort(A); 
        for (int i=0;i<n-2;i++){
            if (isTriangular(A,i,i+1,i+2)==1){
                return 1;
            }
        }
        return 0;
    }
}
