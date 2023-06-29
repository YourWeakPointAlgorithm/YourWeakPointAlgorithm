# 744. Find Smallest Letter Greater Than Target

[Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target/)

## 김시현 - 2023.06.09

- letters배열에 for문 돌면서 저장된 아스키코드값을 비교해 target보다 크면 return
- 배열에 더 큰 값이 없다면 letters[0] return

```java
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for(var c: letters) if(c > target) return c;
        return letters[0];
    }
}
```
