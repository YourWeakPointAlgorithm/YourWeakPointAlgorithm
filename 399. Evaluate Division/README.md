# 399. Evaluate Division

[Evaluate Division](https://leetcode.com/problems/evaluate-division/)

## 박준범 - 2023.05.20

- 각 String에 대해 Map을 통해 Index를 부여한다.
- 각 Array는 String을 묶은 set을 나타내거나, 현재의 값을 나타낸다.
- 두 set를 묶을 땐 바뀌는 쪽의 변화량을 측정하여 해당 set의 모든 값을 바꾼다.

```java
class Solution {
    int[] linkArr;
    double[] valArr;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        
        int len = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < equations.size(); ++i) {
            List<String> equation = equations.get(i);
            
            if(!map.containsKey(equation.get(0))) map.put(equation.get(0), len++);
            if(!map.containsKey(equation.get(1))) map.put(equation.get(1), len++);
        }
        
        linkArr = new int[len];
        for(int i=0; i<linkArr.length; ++i) linkArr[i] = i;

        valArr = new double[len];
        
        for(int i = 0; i < equations.size(); ++i) {
            List<String> equation = equations.get(i);
            
            int flag = 0, idx1 = map.get(equation.get(0)), idx2 = map.get(equation.get(1));
            if(valArr[idx1] != 0) flag += 2;
            if(valArr[idx2] != 0) flag += 1;

            switch(flag) {
                case 0:
                    valArr[idx2] = 1;
                
                case 1:
                    valArr[idx1] = values[i] * valArr[idx2];
                    linkArr[idx1] = linkArr[idx2];
                    break;
                
                case 2:
                    valArr[idx2] = valArr[idx1] / values[i];
                    linkArr[idx2] = linkArr[idx1];
                    break;
                
                case 3:
                    double mul = valArr[idx2] * values[i] / valArr[idx1];
                    linkAll(idx1, idx2, mul);
                    break;
            }
        }
        
        for(int i = 0; i < queries.size(); ++i) {
            List<String> query = queries.get(i);
            String str1 = query.get(0), str2 = query.get(1);
            
            result[i] = (map.containsKey(str1) && map.containsKey(str2) && linkArr[map.get(str1)] == linkArr[map.get(str2)]) ? valArr[map.get(str1)] / valArr[map.get(str2)] : -1;
        }
        
        return result;
    }
    
    public void linkAll(int index1, int index2, double mul) {
        int val1 = linkArr[index1], val2 = linkArr[index2];
        for(int i=0; i<linkArr.length; ++i) {
            if(linkArr[i] == val1) {
                valArr[i] *= mul;
                linkArr[i] = val2;
            }            
        }
    }
}
```

---
