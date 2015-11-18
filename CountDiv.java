//CountDiv Codility

class Solution {
    public int findDivisibles(int n, int K){
        if (n<0) return 0;
        return n/K+1;
        
        }
    public int solution(int A, int B, int K) {
        return findDivisibles(B,K) - findDivisibles(A-1,K);
    }
}

