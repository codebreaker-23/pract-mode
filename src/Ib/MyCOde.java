package Ib;

import java.util.Arrays;

class helper{
    int a;
    int b;

    public helper(){};
    public helper(int a, int b){
    this.a = a;
    this.b = b;
    }

}

class MyCode {
    static int diff = Integer.MAX_VALUE;
    static int sum = 0;

    public static void main(String[] args) {
        int ar[] = {-100, -99, -98, -10, -4, -5, 1, 2};
        int t = -109;

        System.out.println(driver(ar, t));
    }

    static int driver(int[] ar, int t) {
        Arrays.sort(ar);
        int n = ar.length;

        minDiff(ar,0,  1, n - 1, t - ar[0]);

        if(diff != 0) {
            for (int i = 1; i <= n - 2; ++i) {
                minDiff(ar, i, i + 1, n - 1, t - ar[i]);
                if (diff == 0)
                    break;
            }
        }
        return sum;
    }

    static helper minDiff(int[] ar, int x, int y, int z, int nt) {
        helper ans = new helper();
        while (y < z) {
            int s = ar[y] + ar[z];
            int d = Math.abs(nt - s);
            if (d < diff) {
                diff = d;
                sum = ar[x]+ar[y]+ar[z];
            }
            if (s == nt) {
                break;
            }
            else if (s < nt)
                y++;
            else if (s > nt)
                z--;
        }
        return ans;
    }
}
