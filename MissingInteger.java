//Codility MissingInteger

import java.util.HashSet;

class Solution {
    public int solution(int[] A) {
	HashSet<Integer> set = new HashSet<Integer>();
        for (int i=0;i<A.length;i++){
            set.add(A[i]);
		}
		for (int i=1;;i++){
            if(!set.contains(i))return i;
		}
    }
}

