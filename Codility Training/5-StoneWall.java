import java.util.Stack;

class Solution {
    public static int SHIT = -1;
    public int solution(int[] H) {
        Stack<Integer> s = new Stack<Integer>();
        int sum=0;
        int n=H.length;
        if (n==0) return 0;
        s.push(H[0]);
        sum++;
        //I should also check if it is equal
        for (int i=0;i<n;i++){
            while(!s.isEmpty()&&s.peek()>H[i]){
                s.pop();
                
            }
            if (s.empty()||s.peek()!=H[i]){
                s.push(H[i]);
                sum++;
            }
        }
        
        return sum;
    }
}
