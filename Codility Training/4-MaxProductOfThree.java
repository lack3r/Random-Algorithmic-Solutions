class Solution {
    public int solution(int[] A) {
        int n = A.length;
        if (n<3) return 0;
        java.util.Arrays.sort(A);
        int lowestPossible= A[0]*A[1]*A[n-1];
        int highestPossible = A[n-1]*A[n-2]*A[n-3];
        return Math.max(lowestPossible,highestPossible);
    }
}
