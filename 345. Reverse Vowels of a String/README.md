# 345. Reverse Vowels of a String

[Reverse Vowels of a String]([문제 링크](https://leetcode.com/problems/reverse-vowels-of-a-string/))

## 김시 - 2023. 3. 29.

- 간단한 코드에 사용된 기법이나 풀이 방법 설명 (리스트 형식 사용)

```java
class Solution {
    public String reverseVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        //모음 문자들의 index 저장하는 ArrayList
        ArrayList<Integer> arr = new ArrayList<> ();
        char c;
        //모음인 문자의 index arr에 저장
        for(int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') arr.add(i);
        }

        //arr길이가 n일때, arr[i]와 arr[n - i - 1] index의 값을 바꾸는 행위를 n / 2회 반복 
        for(int i = 0; i < arr.size() / 2; i++) {
            c = str.charAt(arr.get(i));
            str.setCharAt(arr.get(i), str.charAt(arr.get(arr.size() - i - 1)));
            str.setCharAt(arr.get(arr.size() - i - 1), c);
        }
        return str.toString();
    }
}
```
