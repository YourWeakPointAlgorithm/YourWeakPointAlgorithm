# 2492. Minimum Score of a Path Between Two Cities

[Minimum Score of a Path Between Two Cities](https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/)

## 박지인 - 2023.03.23

- Union Find 사용
- 이 후 최솟값 찾기

```java
class Solution {
    public int minScore(int n, int[][] roads) {
        var arr = setUnion(n, roads);
        int result = Integer.MAX_VALUE;
        
        for(var road : roads) 
            if(findUnion(arr, road[0]) == 1) 
                result = Math.min(result, road[2]);

        return result;
    }
    
    private int[] setUnion(int n, int[][] roads) {
        int[] arr = new int[n + 1];
        
        for(int i = 0; i < n + 1; i++) arr[i] = i;
        
        for(var road : roads) {
            int a = findUnion(arr, road[0]);
            int b = findUnion(arr, road[1]);
            
            if(a < b) arr[b] = a;
            else arr[a] = b;
        }
        
        return arr;
    }
    
    private int findUnion(int[] arr, int n) {
        if(arr[n] == n) return n;
        
        arr[n] = findUnion(arr, arr[n]);
        
        return arr[n];
    }
}
```

---
