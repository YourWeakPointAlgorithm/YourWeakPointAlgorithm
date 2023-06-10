# 1376. Time Needed to Inform All Employees

[Time Needed to Inform All Employees](https://leetcode.com/problems/time-needed-to-inform-all-employees/)

## 박준범 - 2023.06.03

- Node 에는 본인의 informTime 과 next node가 저장되어 있다.
- 먼저 자신의 직속 상관에게 본인을 연결함.
- dfs를 통해 말단에게 전달되는 시간 중 가장 오래 걸리는 시간을 return 한다.

```java
class Solution {
    class Node {
        int time = 0;
        List<Integer> next;
        Node(int t) { 
            time = t; 
            next = new ArrayList<>();
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Node[] node = new Node[n];
        for(int i = 0; i < n; ++i) {
            if(i == headID) continue;
            
            int pre = manager[i];
            if(node[pre] == null) node[pre] = new Node(informTime[pre]);
            node[pre].next.add(i);
        }

        return dfs(headID, node);
    }
    
    
    public int dfs(int curr, Node[] node) {
        if(node[curr] == null || node[curr].next == null) return 0;
        
        int max = 0;
        for(int next : node[curr].next) {
            max = Math.max(max, dfs(next, node));
        }
        return node[curr].time + max;
    }
}

```

---

## 박지인 - 2023.06.03

- manager를 key, employee를 value로 map을 만들어서 tree를 구현
- 이 후 dfs로 최대 시간을 구함

```java
class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int[] times;
    int result = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n == 1) return 0;
        
        times = informTime;
        
        for(int i = 0; i < manager.length; i++) {
            int m = manager[i];
            if(m == -1) continue;
            
            if(!map.containsKey(m)) map.put(m, new ArrayList<>());
            map.get(m).add(i);
        }
        
        dfs(headID, times[headID]);
        
        return result;
    }
    
    private void dfs(int node, int time) {
        if(!map.containsKey(node)) {
            result = Math.max(result, time);
            return;
        }
        
        for(var emp: map.get(node)) dfs(emp, time + times[emp]);
    }
}
```

---
