# 705. Design HashSet

[Design HashSet](https://leetcode.com/problems/design-hashset/)

## 박지인 - 2023.05.30

- boolean 배열을 사용하여 문제를 풀었다.

```java
class MyHashSet {
    boolean[] arr = new boolean[1000001];
    
    public void add(int key) {
        arr[key] = true;
    }
    
    public void remove(int key) {
        arr[key] = false;
    }
    
    public boolean contains(int key) {
        return arr[key];
    }
}

```

---
