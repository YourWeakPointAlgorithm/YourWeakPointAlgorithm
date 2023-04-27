# 345. Reverse Vowels of a String

[Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/)

## 김시현 - 2023. 3. 29.

- String을 ArrayList로 변환해 사용

```java
class Solution {
    public String reverseVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        ArrayList<Integer> arr = new ArrayList<> ();
        char c;
        for(int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') arr.add(i);
        }

        for(int i = 0; i < arr.size() / 2; i++) {
            c = str.charAt(arr.get(i));
            str.setCharAt(arr.get(i), str.charAt(arr.get(arr.size() - i - 1)));
            str.setCharAt(arr.get(arr.size() - i - 1), c);
        }
        return str.toString();
    }
}
```
