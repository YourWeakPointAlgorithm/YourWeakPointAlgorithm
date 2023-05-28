# 2542. Maximum Subsequence Score

[Maximum Subsequence Score](https://leetcode.com/problems/maximum-subsequence-score/)

## 박준범 - 2023.05.24

- nums2의 값을 기준으로 내림차순하여 min에 대한 처리를 쉽게 한다.
- nums1의 값은 PriorityQueue에 저장해서 큰 값을 남겨 sum을 해결한다.

```java
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] arr = createArray(nums1, nums2);
        long sum = 0, max = 0, min = arr[k-1][1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < arr.length; ++i) {
            if(i >= k) {
                sum -= pq.poll();
                min = arr[i][1];
            }
            pq.add(arr[i][0]);
            sum += arr[i][0];
            max = Math.max(max, sum * min);
        }
        return max;
    }
    
    public int[][] createArray(int[] nums1, int[] nums2) {
        int[][] arr = new int[nums1.length][2];
        for(int i = 0; i < nums1.length; ++i) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }
        Arrays.sort(arr, (o1, o2) -> {return o1[1] != o2[1] ? o2[1] - o1[1] : o2[0] - o1[0];});
        return arr;
    }
}

```

---
