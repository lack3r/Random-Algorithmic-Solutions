//Given an array, find its subarray with the maximum sum

//Solution
//-------------
//Go through the table, and create all possible subarrays. 
//For each possible subarray length
//And for each starting point
//Calculate the sum for the array from that point having that length. O(1)

//My implementation is O(n^2)
public class MaxSubArray { 
public static int findMaxSum(int[][] A){
    int max = -Integer.MAX_VALUE;
    for (int i = 0; i<A.length; i++){
        for (int j = 0; j<A.length-i; j++){
            if(max<A[i][j]){max = A[i][j];}
        }
    }
    return max;
}

public static void copyArray(int[] from, int[] to){
    if (from.length!= to.length) {throw new IllegalArgumentException();}
    for (int i = 0; i<from.length; i++){
        to[i] = from[i];
    }
    return ;
}

public static void printLine(int[] a){
    for (int i=0;i<a.length;i++){
        System.out.print(a[i] + ", ");
    }
    System.out.println();
    
}
int[] A = {-4,3,2,-8,100,-90,91,8,-1};
int [][] sums = new int[A.length][A.length];
//fill the table
try{
MyClass.copyArray(A,sums[0]);
}catch (IllegalArgumentException e){
    e.printStackTrace();
    return;
}
        MyClass.printLine(sums[0]);
    for (int length = 1; length<A.length; length++){

        for (int start = 0; start<A.length-length; start++){
            sums[length][start] = sums[length-1][start] + A[start+length];
        }
        MyClass.printLine(sums[length]);
    }
    
    System.out.println(MyClass.findMaxSum(sums));
}

}
