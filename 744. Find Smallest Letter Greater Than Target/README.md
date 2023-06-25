# 744. Find Smallest Letter Greater Than Target

[Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target/)

## 이성종 - 2023.06.09

- letters 배열이 오름차순으로 정렬이 되어있으므로
- 앞에서 부터 target과 비교하여 target보다 크다면 그 즉시
- 해당 문자를 return 만약 배열의 모든 요소를 탐색했는데도
- target보다 작거나 같았다면 배열의 첫 요소를 return.

```cpp
class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        for(char ch : letters) {
            if(ch - 'a' > target - 'a') return ch;
        }
        return letters[0];
    }
};
```

---
