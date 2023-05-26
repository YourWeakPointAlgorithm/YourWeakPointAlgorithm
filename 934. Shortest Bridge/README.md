# 934. Shortest Bridge

[Shortest Bridge](https://leetcode.com/problems/shortest-bridge/)

## 이성종 - 2023.05.21

- dfs를 돌며 섬 한개의 좌표들을 큐에 저장한다.
- 저장된 큐를 바탕으로 bfs를 돌며 새로운 섬을 발견할때의 최소값을 return 한다.

```cpp
class Solution {
public:
    int visited[101][101], visited2[101][101], dy[4] = {-1, 0, 1, 0}, dx[4] = {0, 1, 0, -1};
    queue<pair<int, int>> q;

    void dfs(int y, int x, vector<vector<int>>& grid) {
        visited[y][x] = 1;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= grid.size() || nx >= grid.size() || ny < 0 || nx < 0 || visited[ny][nx]) continue;
            if(grid[ny][nx] == 0) continue;
            q.push({ny, nx});
            dfs(ny, nx, grid);
        }

        return;
    }

    int shortestBridge(vector<vector<int>>& grid) {
        int y = 0, x = 0, ret = 2000, size = grid.size();  

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(grid[i][j] && !visited[i][j] && !q.size()) {
                    q.push({i, j});
                    dfs(i, j, grid);
                }
            }
        }

        while(q.size()) {
            tie(y, x) = q.front(); q.pop();
            
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny >= size || nx >= size || ny < 0 || nx < 0 || visited[ny][nx] || visited2[ny][nx]) continue;
                visited2[ny][nx] = visited2[y][x] + 1;
               
                if(grid[ny][nx]) ret = min(ret, visited2[ny][nx] - 1);

                q.push({ny, nx});  
            }    
        }
        
        return ret;
    }
};
```

---