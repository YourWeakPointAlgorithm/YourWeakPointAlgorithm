# 1603. Design Parking System

[Design Parking System](https://leetcode.com/problems/design-parking-system/)

## 김시현 - 2023.05.29

- 클래스 내 메소드 구현
- carType이 정수 1,2,3으로 입력받아서 배열의 index로 이용하면
편할 것 같아서 park 배열을 선언하고 값을 넣어줬다.
- 배열의 값이 0보다 크기만 하면 공간이 있다는 뜻이므로 true를 return한다.
- park배열을 ParkingSystem에서 한 번에 초기화해서 코드를 더 깔끔하게 수정하였다.

```java
class ParkingSystem {
        int[] park;

    public ParkingSystem(int big, int medium, int small) {
        park = new int[] {big, medium, small};
    }
    
    public boolean addCar(int carType) {
        return park[carType - 1]-- > 0;
    }
}
```

---
