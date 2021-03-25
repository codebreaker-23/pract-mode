package G;

import java.util.Arrays;

public class AllocateBooks {

    public static void main(String[] args) {
        int a [] = {15,17,20};
        System.out.println(solve(a, 2));

        Object m = Arrays.asList("a", "b", "c", "d");

    }

    static long solve(int [] p, int m){
        long sum=0L;
        int n=p.length;

        for(int i=0;i<n;++i)
            sum+=p[i];

        long l = 0;
        long r = sum;

        long d = (l+r)/2;

        while(l<r){
            d = (l+r)/2;
            if(check(p, d, m))
                r=d;
            else
                l=d+1;
        }
        return check(p, r, m)?r:-1;
    }

    private static boolean check(int [] p, long d, int m){
        int i=0;
        for(;m>0;m--){
            long si=0L;
            while(i<p.length){
                si+=p[i];
                if(si>d)
                    break;
                i++;
            }
        }
        return i==p.length && m==0;
    }

}
