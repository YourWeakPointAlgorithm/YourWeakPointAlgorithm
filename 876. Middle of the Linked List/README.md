# 876. Middle of the Linked List

[Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)

## 장세현 - 2023.03.28

1. 두 개의 노드 fast와 slow 생성 (토끼와 거북이)
2. fast는 두 번씩 움직이고, slow는 한 번씩 움직이는 걸 반복
3. fast의 이동이 끝났다면, slow를 return

```java
class Solution {
    public ListNode middleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }
}
```

---
