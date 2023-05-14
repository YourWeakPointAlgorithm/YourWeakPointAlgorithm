# 896. Monotonic Array

[Monotonic Array](https://leetcode.com/problems/monotonic-array/)

## 박지인 - 2023.05.07

- 배열 내 원소가 오름차순 또는 내림차순인지 boolean 변수 2개를 사용하여 판단했다.

```java
class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isUp = true, isDown = true;
        for(int i = 1; i < nums.length && isUp; i++) if(nums[i - 1] > nums[i]) isUp = false;
        for(int i = 1; i < nums.length && isDown; i++) if(nums[i - 1] < nums[i]) isDown = false;
        return isUp || isDown;
    }
}
```

---

