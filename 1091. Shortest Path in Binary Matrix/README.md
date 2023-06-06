# 1091. Shortest Path in Binary Matrix

[Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/)

## 박준범 - 2023.06.01

- bfs: Queue에 주변 인덱스를 저장, 현재(temp)의 값이 탐색 불가이면 continue, 현재를 1로 전환하여 visited 효과
- bfs를 통해 실시간으로 늘어나는 거리에 대해 최소 거리를 구할 수 있다.

```java
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> q= new LinkedList<>();
        int result = 0, n = grid.length;
        
        q.add(new int[]{0,0});

        while(!q.isEmpty()) {
            int qSize = q.size();
            result++;
            
			int[][] dirs = new int[][]{{-1,-1}, {-1, 0}, {-1, 1}, { 0,-1}, { 0, 1}, { 1,-1}, { 1, 0}, { 1, 1}};
     		for(int i=0; i<qSize; ++i) {
                int[] temp = q.poll();
                if(temp[0] < 0 || temp[0] >= n || temp[1] < 0 || temp[1] >= n || grid[temp[0]][temp[1]] == 1) continue;
                
                grid[temp[0]][temp[1]] = 1;
                
                if(temp[0] == n - 1 && temp[1] == n - 1) return result;
                for(int[] dir : dirs) q.add(new int[]{temp[0]+dir[0], temp[1]+dir[1]});
            }
        }
        return -1;
    }
}
```

---
