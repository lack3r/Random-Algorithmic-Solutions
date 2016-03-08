import java.util.Stack;
class Solution {
    public int solution(int[] A, int[] B) {
        Stack<Integer> s0 = new Stack<Integer>();
        Stack<Integer> s1 = new Stack<Integer>();
        int n=A.length;

        for (int i=0;i<n;i++){
                            boolean shouldAdd=true;

            if (B[i]==1){//add in stack
/*
                 while(!s1.isEmpty()){
                    if (A[s1.peek()]<A[i]){
                        if (s0.isEmpty()||(s0.peek()<s1.peek())){
                        s1.pop();
                        }
                        else{
                            break;
                        }
                    }else if (A[s1.peek()]>A[i]&&(s0.isEmpty()||s0.peek()<s1.peek())){
                        shouldAdd=false;
                        break;
                    }
                    else {
                        break;

                    }
                }
                */
                if (shouldAdd){
                 s0.push(i);
                }
            }else if (B[i]==0){
                 while(!s0.isEmpty()){
                    if (A[s0.peek()]<A[i]){
                        if (s1.isEmpty()||s1.peek()<s0.peek()){
                        s0.pop();
                        }
                        else{
                            break;
                        }
                    }else if (A[s0.peek()]>A[i]&&(s1.isEmpty()||s1.peek()<s0.peek())){
                        shouldAdd=false;
                        break;
                    }
                    else {
                        break;

                    }
                }
                if (shouldAdd){
                 s1.push(i);
                }
                
            }
        }
        
        return s0.size()+s1.size();
    }
}
