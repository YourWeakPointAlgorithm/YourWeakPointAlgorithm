# 2101. Detonate the Maximum Bombs

[Detonate the Maximum Bombs](https://leetcode.com/problems/detonate-the-maximum-bombs/)

## 박지인 - 2023.06.02

- 모든 폭탄을 시작점으로 두고 dfs를 진행
- 순회되었던 폭탄은 이전에 순회했던 결과와 똑같을테니 set을 이용해서 시간 단축

```java
class Solution {
    public int maximumDetonation(int[][] bombs) {
        var set = new HashSet<Integer>();
        int result = 0;
        
        for(int i = 0; i < bombs.length; i++) {
            if(set.contains(i)) continue;
            
            var dfsSet = dfs(bombs, new HashSet<>(), i);
            
            result = Math.max(result, dfsSet.size());
            
            for(var num : dfsSet) set.add(num);
        }
        
        return result;
    }
    
    private HashSet<Integer> dfs(int[][] bombs, HashSet<Integer> set, int now) {
        set.add(now);
        
        for(int i = 0; i < bombs.length; i++) {
            if(set.contains(i)) continue;
            
            var a = bombs[now];
            var b = bombs[i];
            
            long length = a[2], x = Math.abs(a[0] - b[0]), y = Math.abs(a[1] - b[1]);
            
            if(length * length >= x * x + y * y) dfs(bombs, set, i);
        }
        
        return set;
    }
}
```

---
