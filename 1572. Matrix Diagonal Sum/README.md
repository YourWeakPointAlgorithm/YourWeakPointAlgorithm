# 1572. Matrix Diagonal Sum

[Matrix Diagonal Sum](https://leetcode.com/problems/matrix-diagonal-sum/)

## 이성종 - 2023.05.08

- for문을 순회하며 2중 배열의 대각선들의 합을 sum에 저장하여 답을 return하도록 했다.

```cpp
class Solution {
public:
    int diagonalSum(vector<vector<int>>& mat) {
        int sum = 0;
        for(int i = 0, j = mat.size() - 1; i < mat.size() && j >= 0 ; i++, j--) sum += mat[i][j] + mat[i][i];
        return mat.size() % 2 ? sum - mat[mat.size() / 2][mat.size() / 2] : sum;
    }
};
```

---
