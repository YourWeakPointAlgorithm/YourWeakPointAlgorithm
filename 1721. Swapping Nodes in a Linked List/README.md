# 1721. Swapping Nodes in a Linked List

[Swapping Nodes in a Linked List](https://leetcode.com/problems/swapping-nodes-in-a-linked-list/)

## 박지인 - 2023.05.15

- 두 개의 포인터를 사용하여 k번째 노드와 뒤에서 k번째 노드를 찾아 값을 바꿔주었다.

```java
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode result = head, first = head, second = head;
        for(int i = 1; head != null; i++) {
            if(i == k) first = head;
            if(i > k) second = second.next;
            head = head.next;
        }
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        return result;
    }
}
```

---
