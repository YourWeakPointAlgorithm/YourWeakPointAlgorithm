# 881. Boats to Save People

[Boats to Save People](https://leetcode.com/problems/boats-to-save-people/)

## 박준범 - 2023.04.03

- 보트에는 최대 2명까지 들어갈 수 있다.
- 무거운 사람을 우선 태우고 가벼운 사람을 태울 수 있는지 확인한다. 가벼운 사람은 탈 수 있을 때 탄다.

```java
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int res = 0, low = 0;
        Arrays.sort(people);
        for(int i = people.length - 1; i >= low; i--) {
            if(people[i] + people[low] <= limit) low++;
            res++;
        }
        return res;
    }
}
```

---

