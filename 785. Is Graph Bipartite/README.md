# 785. Is Graph Bipartite?

[Is Graph Bipartite?](https://leetcode.com/problems/is-graph-bipartite/)

## 박지인 - 2023.05.19

- BFS를 사용해서 그래프를 탐색하면서 각 노드의 색을 정해주었다.
- 만약 자식 노드의 색이 정해져 있지 않다면 부모 노드의 색과 반대로 정해준다.
- 만약 자식 노드의 색이 부모 노드의 색과 같다면 이분 그래프가 아니므로 false를 반환한다.
- 모든 노드를 탐색했을 때 이분 그래프라면 true를 반환한다.

```java
class Solution {
    public boolean isBipartite(int[][] graph) {
        var arr = new Boolean[graph.length];
        var visit = new boolean[graph.length];
        var q = new LinkedList<Integer>();
        
        for(int i = 0; i < graph.length; i++) {
            if(arr[i] != null) continue;
            
            q.add(i);
            arr[i] = true;
            
            while(!q.isEmpty()) {
                var now = q.poll();

                if(visit[now]) continue;
                visit[now] = true;

                for(var child: graph[now]) {
                    if(arr[child] == null) arr[child] = !arr[now];
                    else if(arr[child] == arr[now]) return false;

                    q.add(child);
                }
            }
        }
        
        return true;
    }
}
```

---
