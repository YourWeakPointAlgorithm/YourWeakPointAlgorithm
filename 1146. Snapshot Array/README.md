# 1146. Snapshot Array

[Snapshot Array](https://leetcode.com/problems/snapshot-array/)

## 박준범 - 2023.05.02

- HashMap의 key는 값이 바뀐 index만 갖는다.
- TreeMap의 key는 값이 언제 바뀌었는지 해당 snap_count를 갖는다.
- get에서 원하는 snap_id일 떄의 값은 snap_id로 부터 가장 최신에 바뀌었을 떄를 탐색하면 된다.

```java
class SnapshotArray {
    HashMap<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
    int count = 0;
    
    public SnapshotArray(int length) { }
    
    public void set(int index, int val) {
        if(!map.containsKey(index)) map.put(index, new TreeMap<>());
        map.get(index).put(count, val);
    }
    
    public int snap() {
        return count++;
    }
    
    public int get(int index, int snap_id) {
        if(!map.containsKey(index)) return 0;
        
        Integer temp = map.get(index).floorKey(snap_id);
        if(temp == null) return 0;
        return map.get(index).get(temp);
    }
}
```

---
