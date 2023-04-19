# 1768. Merge Strings Alternately

[Merge Strings Alternately](https://leetcode.com/problems/merge-strings-alternately/)

## 박준범 - 2023.04.18

- 한 글자씩 입력 후 긴 문자열에 대해서만 추가로 입력

```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len1 = word1.length(), len2 = word2.length();
        int maxLen = Math.max(len1, len2);
        for(int i=0; i<maxLen; ++i) {
            if(i < len1) sb.append(word1.charAt(i));
            if(i < len2) sb.append(word2.charAt(i));
        }
        return sb.toString();
    }
}
```

---
