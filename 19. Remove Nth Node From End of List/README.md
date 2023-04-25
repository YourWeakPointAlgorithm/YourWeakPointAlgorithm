# 19. Remove Nth Node From End of List

[Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

## 박준범 - 2023.04.23

- 첫번째 노드가 n 만큼 이동한 뒤 나머지 size-n 만큼 두 개의 노드가 같이 이동함.
- 두번째 노드는 뒤에서 n 만큼 이전의 노드가 되므로 제거해준다.

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp1 = head, temp2 = head;
        for(int i = 0; i < n; i++) temp1 = temp1.next;
        if(temp1 == null) return temp2.next;
        
        while(temp1.next != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        temp2.next = temp2.next.next;
        
        return head;
    }
}
```

---

