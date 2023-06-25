# 1318. Minimum Flips to Make a OR b Equal to

[Minimum Flips to Make a OR b Equal to](https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/)

## 박지인 - 2023.06.07

- a, b, c를 2진수로 바꾸고 맨 뒤의 bit부터 비교하면서 아래 2가지 상황을 생각했다.
- c 가 1이고 a, b가 모두 0인 경우 -> 둘 중 하나만 1로 만들어도 1이 되므로 result에 1 더해주기
- c 가 0이고 a, b 둘 중 하나라도 1이 있는 경우 -> result에 a, b를 더해주면 된다. 둘 다 1이면 둘 다 뒤집어야하니 2가 더해지고 둘 중 하나만 1이라면 1개만 뒤집으면 되므로 1이 더해진다.

```java
class Solution {
    public int minFlips(int a, int b, int c) {
        int result = 0;
        
        while(a > 0 || b > 0 || c > 0) {
            int ar = a % 2, br = b % 2, cr = c % 2;
            a >>= 1; b >>= 1; c >>= 1;
            if(cr == (ar | br)) continue;
            
            if(cr == 1) result++;
            else result += ar + br;
        }
        
        return result;
    }
}
```

---
