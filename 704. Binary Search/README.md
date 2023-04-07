# 704. Binary Search

[Binary Search](https://leetcode.com/problems/binary-search/)

## 이성종 - 2023.04.01

1. 바이너리 서치의 기본으로 left 와  right변수를 이용해 mid의 요소를 구하고 target과 비교한다.
2. target이 mid의 요소보다 크면 left를 mid + 1로 옮기고 작으면 right를 mid - 1로 옮긴다.
3. left 가 right보다 작거나 같을때까지 위를 반복한다.

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

