    public static int insertions(int N, int M, int i, int j){
        int result;
        printInBin(N);
        printInBin(M);
        M<<=i;
        int mask = (-1<<j)|((1<<i+1)-1);
        result = (N&mask)|M;
        printInBin(result);
        return result;
        
    }
