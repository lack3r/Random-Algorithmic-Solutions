//FrogJmp
// you can also use imports, for example:
// import java.math.*;
class Solution {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 7
        int goal = Y-X;
        if (goal ==0){
            return 0;
        }
        if (goal%D==0){
            return goal/D;
        } else{
            return goal/D +1;
        }
    }
}
