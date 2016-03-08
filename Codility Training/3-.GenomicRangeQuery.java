// you can also use imports, for example:
// import java.math.*;
class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        int m = P.length;
        int n = S.length();
        int[][] splittedImpact = new int[n][4];
        int[][] up = new int[n][4];
        int[] results = new int[m];
        
        for (int i=0;i<S.length();i++){
        char x = S.charAt(i);    
            if(x=='A') splittedImpact[i][0]=1;
            else if(x=='C') splittedImpact[i][1]=1;
            else if(x=='G') splittedImpact[i][2]=1;
            else if(x=='T') splittedImpact[i][3]=1;
        }
        for (int i=0;i<4;i++){
            up[0][i] = splittedImpact[0][i];    
        }
        
        for (int i=1;i<n;i++){
            for (int j=0;j<4;j++){
                up[i][j] = up[i-1][j] + splittedImpact[i][j];
            }
        }
        for (int i=0;i<m;i++){
            int l = P[i];
            int r = Q[i];
            char x = S.charAt(l);
            if (x=='A' || (up[r][0] - up[l][0])>0 ){
                results[i] = 1;
            }
            else
                        if (x=='C' || (up[r][1] - up[l][1])>0 ){
                results[i] = 2;
            }
            else
                        if (x=='G' || (up[r][2] - up[l][2])>0 ){
                results[i] = 3;
            }
            else
                        if (x=='T' || (up[r][3] - up[l][3])>0 ){
                results[i] = 4;
            }
        }
        return results;
        
    }
}
