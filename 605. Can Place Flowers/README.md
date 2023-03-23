# 605. Can Place Flowers

[Can Place Flowers](https://leetcode.com/problems/can-place-flowers/)

## 박준범 - 2023.03.20

1. 연속적인 1이 없으니까 2칸씩 건너 뛰면 됨.
2. 1을 만나면 2칸 건너 뛰고, 0을 만나면 다음 칸을 확인

```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0; i<flowerbed.length && n>0; i+=2) {
            if(flowerbed[i] == 0) {
                if(i == flowerbed.length - 1) {n--; break;}
                if(flowerbed[i+1] == 0) n--;
                else i++;
            }
        }
        return n == 0;
    }
}
```

---
