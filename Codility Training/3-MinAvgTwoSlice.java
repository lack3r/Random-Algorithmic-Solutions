//Based on a wonderfull solution written at http://codesays.com/2014/solution-to-min-avg-two-slice-by-codility/

class Solution {
    public int solution(int[] A) {
        int n = A.length;
        double currentAverage;
        double minAverage = (A[0] + A[1])/2;
        int minPosition = 0;
        
        for(int i=0; i<n-2 ;i++){
            
            currentAverage = ((double)(A[i] + A[i+1]))/2;
            if(currentAverage < minAverage){
                minAverage = currentAverage;
                minPosition = i;
            }
            
            currentAverage = ((double)(A[i] + A[i+1] + A[i+2]))/3;
            
            if(currentAverage < minAverage){
                minAverage = currentAverage;
                minPosition = i;
            } 
        }
        
        currentAverage = ((double)(A[n-2] + A[n - 1]))/2;
            if(currentAverage < minAverage){
                minAverage = currentAverage;
                minPosition = n-2;
            } 
            return minPosition;
    }
}
