# 1020. Number of Enclaves

[Number of Enclaves](https://leetcode.com/problems/number-of-enclaves/)

## 박준범 - 2023.04.07

- 테두리에 위치한 섬에 대해 dfs로 먼저 제거한다.
- 내부에 남아있는 땅의 면적을 구한다

```java
class Solution {
    public int numEnclaves(int[][] grid) {
        int res = 0;
        for(int y=0; y<grid.length; ++y) {
            removeBoundary(grid, y, 0);
            removeBoundary(grid, y, grid[0].length - 1);
        }
        for(int x=0; x<grid[0].length; ++x) {
            removeBoundary(grid, 0, x);
            removeBoundary(grid, grid.length - 1, x);
        }
        for(int y=1; y<grid.length-1; ++y) {
            for(int x=1; x<grid[0].length-1; ++x) {
                res += grid[y][x];
            }
        }
        return res;
    }
    
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void removeBoundary(int[][] grid, int y, int x) {
        if(y < 0 || y >= grid.length || x < 0 || x >= grid[0].length || grid[y][x] == 0) return;
        
        grid[y][x] = 0;
        for(int[] direction : directions) removeBoundary(grid, y + direction[0], x + direction[1]);
    }
}
```

---
