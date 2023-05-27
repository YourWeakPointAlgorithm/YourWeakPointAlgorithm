# 703. Kth Largest Element in a Stream

[Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)

## 박준범 - 2023.05.23

- 우선순위 큐(Priority Queue)를 활용하여 상위 k번째 숫자까지만을 저장.

```java
class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int maxSize;
    public KthLargest(int k, int[] nums) {
        maxSize = k;
        for(int num : nums) pq.add(num);
        while(pq.size() > maxSize) pq.poll();
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > maxSize) pq.poll();
        return pq.peek();
    }
}
```

---

