# 897. Increasing Order Search Tree

[Increasing Order Search Tree](https://leetcode.com/problems/increasing-order-search-tree/)

## 장세현 - 2023.03.22

1. DFS 탐색을 하며 queue에 순서대로 값을 입력합니다.
2. queue의 값을 바탕으로 새로운 TreeNode를 만듭니다.
    여기서 dummy(TreeNode top)을 사용하였습니다.

```java
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        Queue<Integer> queue = new LinkedList<>();
        dfs(root, queue);
        return buildBST(queue);
    }

    private void dfs(TreeNode root, Queue<Integer> queue){
        if (root==null) return;        
        
        dfs(root.left, queue);
        queue.add(root.val);
        dfs(root.right, queue);
    }

    private TreeNode buildBST(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        
        TreeNode top = new TreeNode(queue.poll());
        TreeNode now = top;
        while (!queue.isEmpty()) {
            now.right = new TreeNode(queue.poll());
            now = now.right;
        }

        return top;
    }
}
```

---
