package Ib;

public class bitonic {

    public static void main(String[] args) {
        int [] ar = {1, 7, 67, 133, 178 };
        System.out.println(search(ar, 1));
    }

    public static int search(final int[] ar, int B) {
        int n=ar.length;
        if(n==0 || (n==1 && ar[0]!=B))
            return -1;
        if(n==1 && ar[0]==B)
            return 0;

        int i = findMax(ar,0,n-1);

        if(B > ar[i])
            return -1;
        else if(B == ar[i])
            return i;
        else if(B >= ar[0])
            return find(ar, 0, i, B);
        else
            return find(ar, i,n-1,B);
    }

    static int findMax(int [] ar, int l, int r){
        while(l<r){
            int m = l+(r-l)/2;
            if(ar[m]>ar[m+1] && ar[m]>ar[m-1])
                return m;
            else if(ar[m]>=ar[l])
                l=m+1;
            else
                r=m-1;
        }
        return l;
    }

    static int find(int [] ar, int l, int r, int t){
        while(l<r){
            int m = l+(r-l)/2;
            if(ar[m]==t)
                return m;
            else if(ar[m]<t)
                l=m+1;
            else
                r=m-1;
        }
        return ar[l]==t?l:-1;
    }
}
