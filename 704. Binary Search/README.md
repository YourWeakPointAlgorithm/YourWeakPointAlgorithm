# 704. Binary Search

[Binary Search](https://leetcode.com/problems/binary-search/)

## 이성종 - 2023.04.01

1. 바이너리 서치의 기본으로 left 와  right변수를 이용해 mid를 구하고 target과 비교하며 탐색을 실시.

```cpp
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] < target)  left = mid + 1;
            else if(nums[mid] > target) right = mid - 1;
            else return mid;
        }
        return -1;
    }
};  
```

---

