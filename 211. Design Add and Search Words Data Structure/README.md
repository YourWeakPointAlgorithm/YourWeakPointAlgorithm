# 211. Design Add and Search Words Data Structure

[Design Add and Search Words Data Structure](https://leetcode.com/problems/design-add-and-search-words-data-structure/)

## 박준범 - 2023.03.19

1. 사용 알고리즘 기법: Trie & Queue => 208. Implement Trie (Prefix Tree) 문제와 동일하게 진행합니다.
    1. Queue에는 기본적으로 다음 문자에 해당하는 노드를 입력합니다.
    2. search 메소드에서 '.'을 문자로 입력되었을 때는 모든 자식노드를 Queue에 넣습니다.

```java
class WordDictionary {
    boolean isEnd = false;
    WordDictionary[] next = new WordDictionary[26];
    
    public void addWord(String word) {
        WordDictionary temp = this;
        for(char ch: word.toCharArray()) {
            if(temp.next[ch-'a'] == null) temp.next[ch-'a'] = new WordDictionary();
            temp = temp.next[ch-'a'];
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        boolean result = false;
        Queue<WordDictionary> q = new LinkedList<>();
        q.add(this);
        
        for(int i=0; i<word.length(); ++i) {
            char ch = word.charAt(i);
            int qSize = q.size();
            
            for(int j=0; j<qSize; ++j) {
                WordDictionary temp = q.poll();
                if(ch == '.') {
                    for(int k=0; k<temp.next.length; ++k) {
                        if(temp.next[k] != null) q.add(temp.next[k]);
                    }
                }
                else if(temp.next[ch-'a'] != null) {
                    q.add(temp.next[ch-'a']);
                }
                
            }
        }
        while(!q.isEmpty() && !result) {
            WordDictionary temp = q.poll();
            if(temp != null && temp.isEnd == true) result = true;
        }
        return result;
    }
}
```

---
