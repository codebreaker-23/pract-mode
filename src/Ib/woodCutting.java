package Ib;

import java.util.Arrays;
import java.util.function.Function;

public class woodCutting {

    public static void main(String[] args) {
        int [] a = {73, 79, 79, 115, 109, 82};
        int b = 96;

        final Function<String, Long> hashFunc;
        System.out.println(solve(a,b));
    }

    public static int solve(int[] A, int B) {
        Arrays.sort(A);

        int n = A.length;
        long [] s = new long[n];

        Integer mX = A[0];
        long sum = A[0];
        s[0]=sum;
        for(int i=1;i<A.length;++i) {
            mX = Math.max(A[i], mX);
            sum += A[i];
            s[i]=sum;
        }

        int l=1, r=mX;
        while(l<=r){
            int m = (l+r)/2;
            int i =lowerBound(A, m);

            if(A[i]<m) i++;
            int wood = (int)(sum - (i!=0?s[i-1]:0) - (n-i)*m);

            if(wood == B)
                return m;
            else if(wood > B){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return Math.min(l,r);//Math.min(l,r);
    }

    static int lowerBound(int [] p, int t){
        int l=0, r=p.length-1;
        while(l<r){
            int m = (l+r)/2;
            if(p[m]==t)
                return m+1;
            else if(p[m] > t)
                r=m;
            else
                l=m+1;
        }
        return l;
    }
}
