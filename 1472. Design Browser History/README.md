# 1472. Design Browser History

[Design Browser History](https://leetcode.com/problems/design-browser-history/)

## 박지인 - 2023.03.08

- 2개의 스택을 사용
- 1개는 back 용도로, 1개는 forward 용도로 사용

```java
class BrowserHistory {
    Stack<String> backUrls = new Stack<>();
    Stack<String> forwardUrls = new Stack<>();
    String currentUrl;

    public BrowserHistory(String homepage) {
        currentUrl = homepage;
    }
    
    public void visit(String url) {
        forwardUrls.clear();
        backUrls.push(currentUrl);
        currentUrl = url;
    }
    
    public String back(int steps) {
        int size = Math.min(backUrls.size(), steps);
        
        for(int i = 0; i < size; i++) {
            forwardUrls.push(currentUrl);
            currentUrl = backUrls.pop();
        }
        
        return currentUrl;
    }
    
    public String forward(int steps) {
        int size = Math.min(forwardUrls.size(), steps);
        
        for(int i = 0; i < size; i++) {
            backUrls.push(currentUrl);
            currentUrl = forwardUrls.pop();
        }
        
        return currentUrl;
    }
}
```

---
