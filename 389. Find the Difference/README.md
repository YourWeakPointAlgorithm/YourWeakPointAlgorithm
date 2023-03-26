# 389. Find the Difference

[Find the Difference](https://leetcode.com/problems/Find the Difference/)

## 이성종 - 2023.03.26

1. map<char, int> 을 만들어서 문자열에 있는 문자를 key, 문자의 개수를 value로써 저장한다.
2. 2번째 for문에서 문자열 t의 문자 개수만큼 mp의 value값을 -- 해준다.
3. 새로 추가된 문자가 있다면 결국 value값은 -1이 되므로 해당 문자를 return 한다.

```cpp
class Solution {
public:
    char findTheDifference(string s, string t) {
        map<char, int> mp;
  
        for(char ch : s) mp[ch]++;
        
        for(char ch : t) {
            if(--mp[ch] < 0) return ch;
        }

        return 'd';
    }
};
```

---

