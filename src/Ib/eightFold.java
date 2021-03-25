/*
package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class eightFold {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m;

        int [] a = new int[n];
        for(int i=0;i<n;++i)
            a[i]=sc.nextInt();

        m = sc.nextInt();
        if(m > n){
            System.out.println(find(a,n,true));
        }else if(m==n){
            int p = find(a,n,true);
            int q = find(a,n,false);
            System.out.println(p-q);
        }else {
            Arrays.sort(a);
            int p = find(a, m, true);
            int q = find(a, m, false);
            System.out.println(p-q);
        }
    }

    static int n, k;
    static int dp[] = new int[n+1];

    static int callerFunc() {
//        setAllValAsMinusOne(dp);
        return fence(n, k);
    }

    static int fence(int i, int k){
        if(dp[i] != -1)
            return dp[i];

        if(i==0)
            return dp[i]=1;
        if(i==1)
            return dp[i]=k;

        return dp[n] = k*(fence(i-1,k-1) + fence(i-2,k-1));
    }

    static int find(int [] a, int n, boolean x){
        int m=a[0];
        if(x){//max
            for(int i=1;i<n;++i){
                if(a[i] > m)
                    m = a[i];
            }
        }else{
            for(int i=1;i<n;++i){
                if(a[i] < m)
                    m = a[i];
            }
        }
        return m;
    }

    static int [][] sol(){
        ArrayList<Integer[]> d = new ArrayList<>();
        solve2(new Integer[] {1,2,3},d,0);

        int [][] p = new int[d.size()][1];
        for(int i=0;i<d.size();++i){
            p[i] = get(d.get(i));
        }

        return p;
    }

    static int [] get(Integer [] i){
        int [] ans = new int[i.length];
        for(int k=0;k<i.length;k++)
            ans[k]=i[k].intValue();

        return ans;
    }


    static void solve2(Integer [] a, ArrayList<Integer []> d, int i){
        if(i == a.length-1) {
            Integer [] b = Arrays.copyOf(a, a.length);
            d.add(b);
            return;
        }
        solve2(a, d, i+1);
        for(int k=i+1;k<=a.length-1;++k) {
            swap(a,i,k);
            solve2(a, d, i+1);
            swap(a, i, k);
        }
    }

    static void swap(Integer [] a, int i, int j){
        int t = a[i];
        a[i]=a[j];
        a[j]=t;
    }

    static int solve(int i, int j){
        if(i==rows-1 || j==cols-1)
	        return   dp[i][j] = a[i][j] == 0 ? 1 : 0;

        int matSize = Math.min(solve(i+1,j), Math.min(solve(i,j+1), solve(i+1,j+1))); //dry ran, got the reason for Math.min. Thanks !!

        return dp[i][j] = a[i][j] == 0 ? matSize+1 : matSize;
    }
}
*/
