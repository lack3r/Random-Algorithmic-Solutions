
//FrogJmp from codility
class Solution {
    public int solution(int X, int Y, int D) {
        if (Y<X) return 0;
        long difference = (long)Y- (long) X;
        int result; 
        result = difference % D==0? (int)(difference/D):(int) (difference/D)+1;
        return result;
    }
}

