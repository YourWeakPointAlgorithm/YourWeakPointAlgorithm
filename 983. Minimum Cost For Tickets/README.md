# 983. Minimum Cost For Tickets

[Minimum Cost For Tickets](https://leetcode.com/problems/minimum-cost-for-tickets/)

## 박지인 - 2023.03.28

- dp를 사용했다.
- dp길이를 days 원소값중 최대값 + 1로 잡고 days에 들어가있는 값일 때만 dp를 계산하고 그 외의 날짜는 가장 최근에 계산했던 값을 저장하도록 했다. 

```java
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        var set = new HashSet<Integer>();
        for(var day: days) set.add(day);
        
        var ranges = new int[] {1, 7, 30};
        
        int n = days.length;
        var dp = new int[days[n - 1] + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        int pre = 0;
        
        for(int day = 0; day < dp.length; day++) {
            if(!set.contains(day)) {
                dp[day] = dp[pre];
                continue;
            }
            
            pre = day;
            
            for(int j = 0; j < 3; j++) {
                int beforeDay = Math.max(day - ranges[j], 0), cost = costs[j];    
                
                dp[day] = Math.min(dp[beforeDay] + cost, dp[day]);
            }
        }
        
        return dp[days[n - 1]];
    }
}
```

---
