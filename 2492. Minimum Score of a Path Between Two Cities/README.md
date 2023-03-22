# 2348. Number of Zero-Filled Subarrays

[Number of Zero-Filled Subarrays](https://leetcode.com/problems/number-of-zero-filled-subarrays/)

## 박지인 - 2023.03.21

- 기본적인 수학을 사용한 풀이
- subarray의 길이를 세면서 더하면 subarray의 개수를 구할 수 있다.

```java
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int length = 1;
        long result = 0;
        
        for(var num: nums) {
            if(num == 0) result += length++;
            else length = 1;
        }
        
        return result;
    }
}
```

---
