# 74. Search a 2D Matrix

[Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)

## 이승범 - 2023.03.30

- binary search를 이용해서 문제풀이했습니다

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix[0][0]>target||matrix[matrix.length-1][matrix[0].length-1]<target)
            return false;
        int low=0,high=matrix[0].length-1,mid;

        if(matrix[0].length == 1){
            for(int i=0;i<matrix.length;i++){
                if(matrix[i][0]==target) return true;
            }
            return false;
        }
        if(matrix.length==1){
            while(low<=high){
                mid =(low+high)/2;
                if(target==matrix[0][mid]) return true;
                else if(target<matrix[0][mid]) high=mid-1;
                else if(target>matrix[0][mid]) low =mid+1;
            }
            return false;
        }
        for(int i=0;i<matrix.length-1;i++){
            if(target>=matrix[i][0]&&target<matrix[i+1][0]){
                while(low<=high){
                    mid =(low+high)/2;
                    if(target==matrix[i][mid]) return true;
                    else if(target<matrix[i][mid]) high=mid-1;
                    else if(target>matrix[i][mid]) low =mid+1;
                }
            }
        }
        if(target>=matrix[matrix.length-1][0]){
            while(low<=high){
                mid =(low+high)/2;
                if(target==matrix[matrix.length-1][mid])return true;
                else if(target<matrix[matrix.length-1][mid]) high=mid-1;
                else if(target>matrix[matrix.length-1][mid]) low =mid+1;
            }
        }
        return false;
    }
}
```

---

