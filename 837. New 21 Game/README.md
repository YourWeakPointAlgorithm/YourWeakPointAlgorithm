# 837. New 21 Game

[New 21 Game](https://leetcode.com/problems/new-21-game/)

## 박준범 - 2023.05.25

- dp: 각 point가 나올 확률을 담음.
- sliding window: [1, maxPts]의 범위를 가짐.
- P0(draw 전)와 P1(draw 후) 일때, [P1의 확률 = (P0의 확률 * (P1-P0 카드가 나올 확률))의 합]로 구한다

```java
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if(k == 0 || n >= k + maxPts) return 1;
        double[] dp = new double[n + 1];
        double sum = 0, result = 0;
        
        dp[0] = 1;
        for(int i = 0; i < n; ++i) {
            if(i < k) sum += dp[i];
            else result += dp[i];
            
            if(i >= maxPts) sum -= dp[i - maxPts];
            dp[i + 1] = sum / maxPts;
        }        
        return result + dp[n];
    }
}
```

---
