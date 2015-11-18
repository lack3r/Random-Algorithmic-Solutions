//PassingCars Codility

class Solution {
    public int solution(int[] A) {
        int[] westInRight = new int[A.length];
        int counter = 0;
        if (A.length-1>=0){
            westInRight[A.length-1]=A[A.length-1]; 
        }
        for (int i=A.length-2;i>=0;i--){
            if (A[i]==0){
                westInRight[i] = westInRight[i+1];
            }else{
                westInRight[i] = westInRight[i+1]+1; 
            }
        }
        
        for(int i=0;i<A.length;i++){
            if(A[i]==0){
                counter+= westInRight[i];
                if (counter>1000000000){
                    return -1;    
                }
            }    
        }
        return counter;
    }
}
