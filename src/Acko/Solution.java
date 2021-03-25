package Acko;

import java.util.*;

public class Solution {
    private int vis[][] = new int[101][101];

    public String solve(int A, int B, int n, int r, int[] E, int[] F) {
        clear();
        return dfs(0, 0, A, B, n, r, E, F) ? "YES" : "NO";
    }

    boolean dfs(int i, int j, int A, int B, int n, int r, int[] E, int[] F) {

        if (i == A && j == B)
            return true;

        vis[i][j] = 1;
        boolean ans = false;

        int x[] = {0, -1, -1, -1, 0, 1, 1, 1};
        int y[] = {-1, -1, 0, 1, 1, 1, 0, -1};

        for (int k = 0; k < 8; k++) {
            int c1 = i + x[k];
            int c2 = j + y[k];
            if (valid(c1, c2, A, B, E, F, r, n) && vis[c1][c2] < 1) {
                ans = ans | dfs(c1, c2, A, B, n, r, E, F);
            }
        }
        return ans;
    }

    void clear() {
        for (int i = 0; i < 100; i++)
            Arrays.fill(vis[i], 0);
    }

    boolean valid(int x, int y, int a, int b, int[] X, int[] Y, int r, int n) {
        if (x < 0 || x > a || y > b || y < 0)
            return false;
        for (int i = 0; i < n; ++i) {
            int d = (X[i] - x) * (X[i] - x) + (Y[i] - y) * (Y[i] - y);
            d = (int) Math.ceil(Math.sqrt(d));

            if (d <= r)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        A a1 = new A("a", "1", new B("b1", "1", 1500));
        A a2 = new A("b", "1", new B("b2", "1", 150));

        Queue<A> pq = new PriorityQueue<A>(new Acomp());

        pq.add(a1);
        pq.add(a2);

        System.out.println(pq.poll().a);
    }
}

    class Acomp implements Comparator<A>{

        @Override
        public int compare(A a1, A a2) {
            int p1 = a1.b.prices.get(a1.aType); //new
            int p2 = a2.b.prices.get(a2.aType); //old

            return p1 - p2;
        }
    }

    class A {
        String a;
        String aType;
        B b;

        public A(String a, String at, B b){
            this.a = a;
            this.aType = at;
            this.b = b;
        }
    }

    class B{
        String n;
        public final Map<String, Integer> prices;

        public B(String name, String s1, int p){
            n=name;
            prices = new HashMap<>();
            prices.put(s1, p);
        }
    }