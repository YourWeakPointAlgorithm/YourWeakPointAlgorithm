# 61. Rotate

[Rotate](https://leetcode.com/problems/rotate-list/)

## 박지인 - 2023.04.23

- 링크드리스트 맨 끝과 맨 앞을 이은 후 잘라내는 방식

```java
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        
        int length = 1;
        var node = head;
        
        for(; node.next != null; length++) 
            node = node.next;
        
        node.next = head;
        
        for(int i = 0; i < length - (k % length); i++) 
            node = node.next;
        
        var result = node.next;
        node.next = null;
        
        return result;
    }
}
```

---
