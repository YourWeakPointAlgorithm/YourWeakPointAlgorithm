# 347. Top K Frequent Elements

[Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)

## 박지인 - 2023.05.22

- O(n)으로 풀기 위해서 map2개를 사용 - 하나는 원소의 빈도 수 저장, 하나는 빈도수에 해당되는 원소 저장
- 모든 걸 map에 넣고나서 높은 빈도수에 해당하는 원소를 k만큼 뽑아내는 방식으로 문제를 풀었다.

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var freqMap = new HashMap<Integer, Integer>();
        var map = new HashMap<Integer, LinkedList<Integer>>();
        int maxFrequent = 0;
        
        for(var num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            
            maxFrequent = Math.max(maxFrequent, freqMap.get(num));
            
            if(!map.containsKey(freqMap.get(num))) map.put(freqMap.get(num), new LinkedList<>());
            
            map.get(freqMap.get(num)).add(num);
        }
        
        var result = new int[k];
        var set = new HashSet<Integer>();
        
        while(set.size() < k) {
            if(map.get(maxFrequent).isEmpty()) maxFrequent--;
            set.add(map.get(maxFrequent).poll());
        }
        
        int index = 0;
        for(var num: set) result[index++] = num;
        
        return result;
    }
}
```

---
