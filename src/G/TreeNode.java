package G;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    private static void util(TreeNode r, int v, boolean ch){
        TreeNode t = new TreeNode(v);
        if(ch){
            r.left = t;
        }
        else
            r.right = t;
    }

//    public static void main(String[] args) {
    public static TreeNode getATree() {
        TreeNode r = new TreeNode(1);
        util(r, 2, true);
        util(r, 4, false);
        util(r.left, 5, true);
        util(r.left, 3, false);

//        util(r.left.left, 7, true);
//        util(r.left.left, 6, false);
//        util(r.left.left.left, 9, true);
//        util(r.left.left.left, 8, false);

        return r;
    }


}


