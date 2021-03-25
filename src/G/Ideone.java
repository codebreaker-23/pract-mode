/* package whatever; // don't place package name! */
package G;

import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
/*class Ideone
{
	static int [][] mat = {{1, 1, 0, 0, 0},
                   {1, 0, 0, 0, 1},
                   {0, 0, 1, 0, 0},
                   {1, 0, 0, 0, 1},
                   {0, 0, 1, 0, 0},
                   {1, 0, 1, 0, 1}};
	static int [][] vis;
	static int r,c;
	public static void main (String[] args) throws java.lang.Exception{
		r = mat.length;
		c = mat[0].length;
		
		vis = new int [r][c];
		int t=0;
		while(t<r) {
            Arrays.fill(vis[t], 0);
            t++;
        }
			
		int ans=0;
		for(int i=0;i<r;++i)
			for(int j=0;j<c;++j)
				if(mat[i][j]==1 && vis[i][j]==0){
					ans+=1;
					dfs(i,j);
				}
		System.out.println(ans);
	}
	
	static void dfs(int i, int j){
		vis[i][j]=1;
		int [] x = {-1,-1,-1,0,1,1,1,0};
		int [] y = {-1,0,1,1,1,0,-1,-1};
		
		for(int d=0;d<8;++d){
			int X = i+x[d];
			int Y = j+y[d];
			if(X<r && X>=0 && Y<c && Y>=0 && vis[X][Y]==0 && mat[i][j]==1) //valid & non-visited
				dfs(X,Y);
		}
	}
}*/

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1(int x) {
        val = x;
        left = null;
        right = null;
    }
}
public class Ideone {
    static Queue<TreeNode1> st = new LinkedList<>();
    static int [] vis = new int [100005];

    private static void util(TreeNode1 r, int v, boolean ch){
        TreeNode1 t = new TreeNode1(v);
        if(ch){
            r.left = t;
        }
        else
            r.right = t;
    }

    public static void main(String[] args) {
        TreeNode1 r = new TreeNode1(1);
        util(r, 2, true);
        util(r, 4, false);
        util(r.left, 5, true);
        util(r.left, 3, false);

        util(r.left.left, 7, true);
        util(r.left.left, 6, false);
        util(r.left.left.left, 9, true);
        util(r.left.left.left, 8, false);

        System.out.println(new Ideone().solve(r, 8));
    }

    public int solve(TreeNode1 a, int b) {

        Arrays.fill(vis, 0);
        st.clear();

        int mAns = 0;

        vis[b]=1;
        int t = 1;
        if(find(a,b)){
            while(!st.isEmpty()){
                TreeNode1 p = st.poll();
                vis[p.val]=1;
                int ans=t++;

                ans += Math.max(dfs(p.left) , dfs(p.right));
                mAns = Math.max(ans, mAns);
            }
        }
        return mAns;
    }

    int dfs(TreeNode1 r){
        if(r==null || vis[r.val] == 1)
            return 0;
        vis[r.val] = 1;
        return 1 + Math.max(dfs(r.left), dfs(r.right));
    }

    boolean find(TreeNode1 a, int b){
        if(a==null)
            return false;
        if(a.val == b)
            return true;

        boolean ans = find(a.left,b);

        if(!ans)
            ans = ans||find(a.right,b);

        if(ans)
            st.add(a);
        return ans;
    }
}

