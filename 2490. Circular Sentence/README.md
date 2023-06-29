# 2490. Circular Sentence

[Circular Sentence](https://leetcode.com/problems/circular-sentence/)

## 김시현 - 2023.06.29

- sentence를 공백으로 나누어 String 배열에 넣어주고 for문 돌면서
마지막 문자와 다음 String 첫 문자를 비교해준다.

```java
class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] str = sentence.split(" ");
        for(int i = 0; i < str.length; i++) {
            if(str[i].charAt(str[i].length() - 1)
            != str[(i + 1) % str.length].charAt(0))
                return false;
        }
        return true;
    }
}
```
