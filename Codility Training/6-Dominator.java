import java.util.Stack;
class Solution {
    public int solution(int[] A) {
        //Stack<Integer> s = new Stack<Integer>();
        int size=0;
        int n=A.length;
        int candidate = 0;
        int candidateCounter=0;
        int candidatePosition=0;
        int value=0;
        for (int i=0;i<n;i++){
            if(size==0){
                size=1;
                value=A[i];
            }else{
                if (value!=A[i]){
                    size--;
                }else{
                    size++;
                }
            }
        }
        candidate=value;
        for (int i=0;i<n;i++){
            if (A[i]==candidate){
                candidateCounter++;
                candidatePosition=i;
            }
        }
        if (candidateCounter>(n/2)){
            return candidatePosition;
        }
        return -1;
    }
}
