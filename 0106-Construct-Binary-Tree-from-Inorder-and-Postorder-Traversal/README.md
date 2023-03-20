# 문제 번호. 문제 제목

[0106. Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

## 우수 풀이자 이름 - 해당 문제 푼 날짜

박준범 - 2023. 03. 16
1. 순회(Traversal)에 대한 설명.
    1. pre-order(전위 순회): root -> left -> right
    2. in-order(중위 순회): left -> root -> right
    3. post-order(후위 순회): left -> right -> root
    4. 'root 노드를 어디에 적는가'에 따라 정해집니다.
2. 알고리즘 기법: Divide and Conquer(분할 정복) - 나누고 풀고 조합
    1. postorder은 가장 오른쪽부터 parent이기 때문에 오른쪽에서 한칸씩 접근
    2. inorder을 통해 해당 노드가 leaf 노드인지 확인 - inorder에서 더 이상 움직일 수 없을 때
        1. inorder은 postorder에서 찾은 parent를 기점으로 좌우가 나뉘어짐.
    3. 분할: inorder에서 범위를 나눔, 정복: 더 이상 나눌 수 없으면 leaf노드, 조합: binary tree형태로

```java
class Solution {
    int pi; //index of postoreder
    HashMap<Integer, Integer> map = new HashMap<>(); //inorder base: <value, index>
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pi = postorder.length-1;
        for(int i=0; i<inorder.length; ++i) map.put(inorder[i], i);
        return makeNode(inorder, postorder, 0, pi);
    }
    
    public TreeNode makeNode(int[] inorder, int[] postorder, int left, int right) {
        if(left > right) return null; //can not create Node
        
        int target = postorder[pi--];
        if(left == right) return new TreeNode(inorder[left]); //no more divide
        
        TreeNode result = new TreeNode(target);
        int mid = map.get(target); //index of target at inorder
        
        result.right = makeNode(inorder, postorder, mid+1, right);
        result.left = makeNode(inorder, postorder, left, mid-1);
        
        return result;
    }
}
```

---

우수 풀이자가 또 나오는 경우 위에 우수 풀이자 이름 부터 구분선까지를 반복하면 됨
