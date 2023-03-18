# 1472. Design Browser History
[Design Browser History](https://leetcode.com/problems/design-browser-history/)

## 이성종 - 2023/03/18

- vector<int>를 이용하여 문제를 해결하였습니다.
- int idx는 현재 index를 의미합니다.


```cpp
class BrowserHistory {
public:
    vector<string> v;
    int idx;
    BrowserHistory(string homepage) {
        v.push_back(homepage);
        idx = 0;
    }
    
    void visit(string url) {
        v.erase(v.begin() + idx + 1, v.end());   
        v.push_back(url);
        idx = v.size() - 1;
    }
    
    string back(int steps) {
        idx = max(0, idx - steps);
        return v[idx];  
    }
    
    string forward(int steps) {
        idx = min((int)v.size() - 1, steps + idx);
        return v[idx];  
    }
};
```

---