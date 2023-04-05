# 2439. Minimize Maximum of Array

[Minimize Maximum of Array](https://leetcode.com/problems/minimize-maximum-of-array/)

## 박지인 - 2023.04.05

- 그리디를 사용
- index를 올려가면서 평균을 구하고 그 평균의 최대값을 구했다.

```java
class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0, max = 0;
        
        for(int i = 0; i< nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum / (i + 1) + (sum % (i + 1) > 0 ? 1 : 0));
        }
        
        return (int)max;
    }
}
```

---
