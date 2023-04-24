# 1372. Longest ZigZag Path in a Binary Tree

[Longest ZigZag Path in a Binary Tree](https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/)

## 박준범 - 2023.04.19

- binary tree에서 좌/우를 번갈아 내려가면 count를 한다.
- 같은 방향으로 가면 count를 초기해준다.

```java
class Solution {
    int max = 0;
    public int longestZigZag(TreeNode root) {
        moveZigZag(root, 0, true);
        return max;
    }
    public void moveZigZag(TreeNode root, int count, boolean leftDown) {
        if(root == null) return;
        max = Math.max(max, count);
        moveZigZag(root.left, (leftDown ? 1 : count+1), true);
        moveZigZag(root.right, (leftDown ? count+1 : 1), false);
    }
}
```

---
