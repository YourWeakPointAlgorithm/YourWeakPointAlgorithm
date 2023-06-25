# 547. Number of Provinces

[Number of Provinces](https://leetcode.com/problems/number-of-provinces/)

## 박지인 - 2023.06.04

- union find를 이용하여 연결 상태를 저장
- 이 후 set에 저장하고 set의 크기를 반환

```java
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        var arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = i;
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(isConnected[i][j] == 1) {
                    int a = find(arr, i), b = find(arr, j);
                    
                    if(a < b) arr[b] = a;
                    else arr[a] = b;
                }
            }
        }
        
        var set = new HashSet<Integer>();
        for(int i = 0; i < n; i++) set.add(find(arr, i));
        
        return set.size();
    }
    
    private int find(int[] arr, int n) {
        if(arr[n] == n) return n;
        
        return arr[n] = find(arr, arr[n]);
    }
}
```

---
## 이성종 - 2023.06.04

- 인접리스트를 만들어 dfs로 탐색함.
- dfs를 호출한 횟수가 곧 도시 집합의 개수.

```cpp
class Solution {
public:
    void dfs(int here, vector<bool>& visited, vector<int> adj[]) {
        visited[here] = true;

        for(int there : adj[here]) {
            if(visited[there]) continue;
            dfs(there, visited, adj);
        }
    }

    int findCircleNum(vector<vector<int>>& isConnected) {
        int size = isConnected.size(), cnt = 0;
        vector<bool> visited(size, 0);
        vector<int> adj[size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(isConnected[i][j]) adj[i].push_back(j);
            }
        }

        for(int i = 0; i < size; i++) {
            if(!visited[i]) {
                dfs(i, visited, adj);
                cnt++;
            }
        }

        return cnt;
    }
};
```

---
