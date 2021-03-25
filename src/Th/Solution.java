package Th;

import java.util.Arrays;

public class Solution {

    static final int parts = 3;
    static int dp[][] = new int[4][100005];

    public static void main(String[] args) {
        System.out.println(solve(8, new int []{-1, -1, -1, -1, -1, -1, -1, -1 }));
    }

    public static int solve(int B, int[] A){

        int n = B;
        int [] totalSum = new int[A.length];

        for(int [] i : dp){
            Arrays.fill(i,0,A.length,-1);
        }

        for(int i=0;i<n;i++){
            if(i==0)
                totalSum[i]=A[i];
            else
                totalSum[i]=A[i]+totalSum[i-1];
        }

        if(Math.abs(totalSum[n-1]) % parts > 0)
            return 0;
        else
            return solve2(A,0,totalSum[n-1]/parts, 0, totalSum);
    }

    static int solve2(int [] A, int st, int sum, int p, int [] totalSum){
        if(st==A.length)
            return 0;

        if(p == parts-1){
            if(totalSum[A.length-1] - totalSum[st-1] == sum)
                return dp[p][st] = 1;
        }


        if (dp[p][st] != -1)
            return dp[p][st];

        int count=0;
        int cs=0;

        for(int i=st;i<A.length;++i){
            cs += A[i];
            if(cs==sum){
                count += solve2(A, i+1, sum, p+1, totalSum);
            }
        }
        return dp[p][st] = count;
    }
}
