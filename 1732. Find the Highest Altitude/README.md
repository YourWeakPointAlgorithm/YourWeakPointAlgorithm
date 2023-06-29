# 1732. Find the Highest Altitude

[Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target/)

## 김시현 - 2023.06.19

- for문 돌면서 sum에 더하여 저장, sum이 max보다 큰 경우 바꿔줌

```java
class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0, max = 0;
        for(int i = 0; i < gain.length; i++) {
            sum += gain[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}
```
