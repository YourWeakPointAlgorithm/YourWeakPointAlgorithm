# 2360. Longest Cycle in a Graph

[Longest Cycle in a Graph](https://leetcode.com/problems/longest-cycle-in-a-graph/)

## 박지인 - 2023.03.26

- dfs를 활용하여 cycle 시작 노드를 찾고 cycle 길이 구하기
- 이미 순회했던 노드는 다시 순회할 필요가 없으므로 boolean 배열 활용

```java
class Solution {
    boolean[] visit;
    
    public int longestCycle(int[] edges) {
        visit = new boolean[edges.length];
        int result = -1;
        
        for(var edge : edges) {
            var node = findCycle(edges, new HashSet<>(), edge);
            
            if(node < 0) continue;
            
            int temp = edges[node], length = 1;
            
            for(; node != temp; length++) temp = edges[temp];
            
            result = Math.max(result, length);
        }
        
        return result;
    }
    
    public int findCycle(int[] edges, HashSet<Integer> set, int root) {
        if(root < 0) return -1;
        if(!set.add(root)) return root;
        if(visit[root]) return -1;
        
        visit[root] = true;
        
        return findCycle(edges, set, edges[root]);
    }
}
```

---
