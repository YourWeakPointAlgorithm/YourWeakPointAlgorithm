class Solution_0106 {
    int pi; //index of postoreder
    HashMap<Integer, Integer> map = new HashMap<>(); //inorder base: <value, index>
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pi = postorder.length-1;
        for(int i=0; i<inorder.length; ++i) map.put(inorder[i], i);
        return makeNode(inorder, postorder, 0, pi);
    }

    public TreeNode makeNode(int[] inorder, int[] postorder, int left, int right) {
        if(left > right) return null; //can not create Node

        int target = postorder[pi--];
        if(left == right) return new TreeNode(inorder[left]); //no more divide

        TreeNode result = new TreeNode(target);
        int mid = map.get(target); //index of target at inorder

        result.right = makeNode(inorder, postorder, mid+1, right);
        result.left = makeNode(inorder, postorder, left, mid-1);

        return result;
    }
}