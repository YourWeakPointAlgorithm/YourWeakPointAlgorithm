# 228. Summary Ranges

[Summary Ranges](https://leetcode.com/problems/summary-ranges/)

## 이성종 - 2023.06.12

- 이어져 있다면 pass하고 다음 요소와 끊어져 있다면 현재 요소를 string s에 이어붙이고
- 벡터에 해당 문자열 저장. 다시 탐색. 맨 마지막 요소에 대한 확인은 조건을 추가하여 처리.

```cpp
class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string> ret;
        if(nums.size() == 0) return ret;

        string s = to_string(nums[0]);

        for(int i = 0; i < nums.size(); i++) {
            if((i == nums.size() - 1) || (nums[i] + 1 != nums[i + 1])) {
                if(atoi(s.c_str()) != nums[i]) s += "->" + to_string(nums[i]);
                ret.push_back(s);
                
                if(i != nums.size() - 1) s = to_string(nums[i + 1]); 
            }
        }

        return ret;
    }
};
```

---
