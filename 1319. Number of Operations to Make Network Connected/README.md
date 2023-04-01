# 1319. Number of Operations to Make Network Connected

[Number of Operations to Make Network Connected](https://leetcode.com/problems/number-of-operations-to-make-network-connected/)

## 김수연 - 2023.03.23

1. Union Find 사용
2. root가 true이면 node가 최상위 노드임을 나타냄
3. findunion으로 찾은 root가 false이면 현재까지와 다른 최상위 노드를 가짐
4. 따라서 result 값 증가

```java
class Solution {
    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n - 1) return -1;

        int[] arr = new int[n];
        boolean[] root = new boolean[n];
        int result = 0;

        for(int i = 0; i < n; i++) arr[i] = i;

        for(int[] connection : connections) {
            int a = findUnion(arr, connection[0]);
            int b = findUnion(arr, connection[1]);

            if(a < b) arr[b] = a;
            else arr[a] = b;
        }

        for(int i = 0; i < n; i++){
            int semi = findUnion(arr, i);
            if(root[semi]) continue;
            result++;
            root[semi] = true;
        }
        return result - 1;
    }

    public int findUnion(int[] arr, int n) {
        if(arr[n] == n) return n;

        return findUnion(arr, arr[n]);
    }
}
```

---
