# 1402. Reducing Dishes

[Reducing Dishes](https://leetcode.com/problems/reducing-dishes/)

## 박준범 - 2023.03.29

- 가장 큰 수부터 누적합을 더해 저장한다. (∑ Sn)

```java
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int result = 0, sum = 0;
        Arrays.sort(satisfaction);
        
        for(int i=satisfaction.length-1; i>=0; --i) {
            if(sum + satisfaction[i] < 0) return result;
            sum += satisfaction[i];
            result += sum;
        }
        
        return result;
    }
}
```

---
