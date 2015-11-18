//Codility MaxCounters
class Solution {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int last_max_set = 0;
        int max = 0;
        int[] array = new int[N];
        for (int i = 0;i<A.length;i++){
            if (A[i]<=N){
                if (array[A[i]-1]<last_max_set){
                    array[A[i]-1] = last_max_set;
                }
                array[A[i]-1]++;
                if (array[A[i]-1]>max){
                    max = array[A[i]-1];
                    }
            }else if (A[i]==N+1){
                last_max_set = max;
                
                }
        }
        for (int i = 0;i<N;i++){
             if (array[i]<last_max_set){
                    array[i] = last_max_set;
                 }
            }
        return array;
    }
}
