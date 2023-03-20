# 208. Implement Trie (Prefix Tree)

[208. Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)

## 박준범 - 2023.03.17

1. 사용 알고리즘 기법: Trie(트라이) - 문자열을 저장하고 효율적으로 탐색하기 위한 tree 형태의 자료구조
    1. 각 문자(Character)는 다음 문자를 Child로 갖는다.
    2. root 노드는 공백으로 갖고 첫 문자가 root 노드의 자식이 된다.
    3. boolean형 variable을 통해 해당 문자가 마지막 문자인지 확인한다.

```java
class Trie {
    boolean finished = false;
    Trie[] next = new Trie[26];
    
    public void insert(String word) {
        Trie temp = this;
        for(char ch: word.toCharArray()) {
            if(temp.next[ch-'a'] == null) temp.next[ch-'a'] = new Trie();
            temp = temp.next[ch-'a'];
        }
        temp.finished = true;
    }
    
    public boolean search(String word) {
        Trie temp = this;
        for(char ch: word.toCharArray()) {
            if(temp.next[ch-'a'] == null) return false;
            temp = temp.next[ch-'a'];
        }
        return temp.finished;
    }
    
    public boolean startsWith(String prefix) {
        Trie temp = this;
        for(char ch: prefix.toCharArray()) {
            if(temp.next[ch-'a'] == null) return false;
            temp = temp.next[ch-'a'];
        }
        return true;
    }
}
```

---

