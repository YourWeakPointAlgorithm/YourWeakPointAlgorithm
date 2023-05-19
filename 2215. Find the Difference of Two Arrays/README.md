# 2215. Find the Difference of Two Arrays

[Find the Difference of Two Arrays](https://leetcode.com/problems/find-the-difference-of-two-arrays/)

## 박지인 - 2023.05.03

- 배열을 set으로 변환하여 차집합을 구했다.

```java
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var set1 = new HashSet<Integer>();
        var set2 = new HashSet<Integer>();
        
        for(var num: nums1) set1.add(num);
        for(var num: nums2) set2.add(num);
        
        var result = new ArrayList<List<Integer>>();
        
        var arr = new ArrayList<Integer>();
        for(var num: set1) if(!set2.contains(num)) arr.add(num);
        
        result.add(arr);
        
        arr = new ArrayList<Integer>();
        for(var num: set2) if(!set1.contains(num)) arr.add(num);
        
        result.add(arr);
        
        return result;
    }
}
```

---
