# 1396. Design Underground System

[Design Underground System](문제 링크)

## 박지인 - 2023.05.31

- id를 기준으로 start station을 저장하는 idMap
- start station을 기준으로 end station들과 해당 end station까지 갔던 개수와 시간들을 저장하는 stationMap
- checkIn 할 때는 id가 유니크함을 보장하므로 무조건 넣어주기만 한다
- checkOut 할 때는 기존에 갔었던 길인지 확인해야하므로 containsKey를 사용하여 기존 값들을 사용하게끔 했다.

```java
class UndergroundSystem {
    HashMap<Integer, Station> idMap = new HashMap<>();
    HashMap<String, HashMap<String, double[]>> stationMap = new HashMap<>();
    
    public void checkIn(int id, String stationName, int t) {
        idMap.put(id, new Station(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        var station = idMap.get(id);
        
        if(!stationMap.containsKey(station.name)) stationMap.put(station.name, new HashMap<>());
        var map = stationMap.get(station.name);
        
        if(!map.containsKey(stationName)) map.put(stationName, new double[2]);
        var arr = map.get(stationName);
        arr[0]++;
        arr[1] += t - station.time;
    }
    
    public double getAverageTime(String startStation, String endStation) {
       var arr = stationMap.get(startStation).get(endStation);
       return arr[1] / arr[0]; 
    }
}

class Station {
    String name;
    int time;
    
    public Station(String name, int time) {
        this.name = name;
        this.time = time;
    }
}
```

---
