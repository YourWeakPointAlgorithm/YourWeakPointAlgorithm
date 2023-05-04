# 1822. Sign of the Product of an Array

[Sign of the Product of an Array](https://leetcode.com/problems/sign-of-the-product-of-an-array/)

## 박준범 - 2023.05.02

- 음수가 곱해질 때만 해당 정수의 부호가 바뀌는 점을 이용하여 부호만 판단한다.

```java
class Solution {
    public int arraySign(int[] nums) {
        boolean positive = true;
        for(int num : nums) {
            if(num == 0) return 0;
            if(num < 0) positive = !positive;
        }
        return positive ? 1 : -1;
    }
}
```

---

