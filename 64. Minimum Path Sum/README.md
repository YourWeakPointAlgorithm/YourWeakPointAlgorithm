# 64. Minimum Path Sum

[Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)

## 김수연 - 2023.03.27

1. dp 사용
2. grid의 위쪽와 왼쪽 중 더 작은 point 가진곳과 현재 위치의 point 더함

```java
class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;

        for(int i = 1; i < row; i++) grid[i][0] += grid[i-1][0];
        for(int j = 1; j < col; j++) grid[0][j] += grid[0][j-1];

        for(int i = 1; i < row; i++)
            for(int j = 1; j < col; j++)
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);

        return grid[row-1][col-1];
    }
}
```

---
