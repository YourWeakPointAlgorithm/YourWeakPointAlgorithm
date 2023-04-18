# 133. Clone Graph

[Clone Graph](https://leetcode.com/problems/clone-graph/)

## 박지인 - 2023.04.08

- BFS와 HashMap을 사용해서 복제하는 방식

```java
class Solution {
    HashMap<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(map.containsKey(node.val)) return map.get(node.val);
        
        var clone = new Node(node.val);
        map.put(node.val, clone);
        for(var neighbor: node.neighbors) {
            var clonedNeigbor = cloneGraph(neighbor);
            clone.neighbors.add(clonedNeigbor);
        }
        
        return clone;
    }
}
```

---

