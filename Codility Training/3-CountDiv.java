class Solution {
    public int solution(int A, int B, int K) {
        int from = (A%K==0)?A:(A/K)*K + K;
        int to = (B/K)*K;
        return (to-from)/K+1;
    }
}
