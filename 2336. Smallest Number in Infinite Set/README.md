# 2336. Smallest Number in Infinite Set

[Smallest Number in Infinite Set](https://leetcode.com/problems/smallest-number-in-infinite-set/)

## 박준범 - 2023.04.25

- pop 횟수(count)를 기준으로 작을 경우 priority queue를 통해 저장한다.
- priority queue가 비어있을 경우 현재의 가장 작은 수인 count를 출력한다.

```java
class SmallestInfiniteSet {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int count = 1;
    
    public int popSmallest() {
        if(pq.isEmpty()) return count++;
        return pq.poll();
    }
    
    public void addBack(int num) {
        if(!pq.contains(num) && num < count) pq.add(num);
    }
}
```

---

