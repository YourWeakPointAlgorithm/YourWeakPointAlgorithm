# 70. Climbing Stairs

[Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)

## 이성종 - 2023.03.23

1. n의 결과값은 n - 1 결과값 + n - 2 결과값 이므로 이전의 부분 문제의 결과를 저장하고 필요할 때마다 다시 연산하는 것이 아니라 이전의 결과를 사용하는 Dynamic Programming 을 사용했다.

```cpp
class Solution {
public:
    int climbStairs(int n) {
        if(n <= 2) return n;

        vector<int> dp(n + 1, -1);

        return solve(n, dp);
    }
    int solve (int n, vector<int> &dp) {
        if(n <= 2) return n;
        if(dp[n] != -1) return dp[n];
       
        dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
        
        return dp[n];
    }
};
```

---

