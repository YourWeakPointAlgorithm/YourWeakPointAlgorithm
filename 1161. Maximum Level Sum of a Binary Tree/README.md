# 1161. Maximum Level Sum of a Binary Tree

[Maximum Level Sum of a Binary Tree](https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/)

## 이성종 - 2023.06.15

- flood fill 기법을 이용하여 각 레벨별로 sum을 구하고 map에 
- key: sum, value: levle 을 저장한다. 만약 sum이 같을때 기존에 저장된
- level보다 현재 level이 높음이 자명하므로 기존 level 유지.

```cpp
class Solution {
public:
    int bfs(TreeNode* node) {
        queue<TreeNode*> q;
        map<int, int, greater<int>> mp;
        int level = 0, maxSum = -1e9, minLevel = 0;

        q.push(node);

        while(q.size()) {
            int qsize = q.size(), sum = 0;
            
            while(qsize--) {
                TreeNode* here = q.front(); q.pop();
                sum += here->val;
                
                if(here->right != NULL) q.push(here->right);
                if(here->left != NULL) q.push(here->left);
            }
            level++;

            if(sum > maxSum) {
                maxSum = sum;
                minLevel = level;
            }
        }

        return minLevel;
    }

    int maxLevelSum(TreeNode* root) {
        return bfs(root);
    }
};

```

---
