# 2405. Optimal Partition of String

[Optimal Partition of String](https://leetcode.com/problems/optimal-partition-of-string/)

## 우수 풀이자 이름 - 해당 문제 푼 날짜

- 윈도우 슬라이딩과 그리디를 같이 사용
- 윈도우 슬라이딩으로 substring을 만들어가면서 중복되는 원소가 있다면 바로 count를 올리고 substring을 다시 만들어가는 방식

```java
class Solution {
    public int partitionString(String s) {
        var arr = new boolean[26];
        int left = 0, result = 1;
        
        for(int i = 0; i < s.length(); i++) {
            if(arr[s.charAt(i) - 'a']) {
                while(left < i) arr[s.charAt(left++) - 'a'] = false;
                result++;
            }
            arr[s.charAt(i) - 'a'] = true;
        }
        
        return result;
    }
}
```

---
