# 문제 번호. 문제 제목

[0208. Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)

## 우수 풀이자 이름 - 해당 문제 푼 날짜

박준범 - 2023. 03. 17
1. 사용 알고리즘 기법: Trie(트라이) - 문자열을 저장하고 효율적으로 탐색하기 위한 tree 형태의 자료구조
    1. 각 문자(Character)는 다음 문자를 Child로 갖는다.
    2. root 노드는 공백으로 갖고 첫 문자가 root 노드의 자식이 된다.
    3. boolean형 variable을 통해 해당 문자가 마지막 문자인지 확인한다.

```java
class Trie {
    boolean finished = false;
    Trie[] next = new Trie[26]; //a(0) to z(25) & finish(26) => finish: new boolean
    //remove constructor
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

우수 풀이자가 또 나오는 경우 위에 우수 풀이자 이름 부터 구분선까지를 반복하면 됨
