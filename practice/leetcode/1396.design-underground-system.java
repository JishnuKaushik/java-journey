class UndergroundSystem {

    class CheckIn{
        String station;
        int time;
        CheckIn(String s, int t){
            station=s; time=t;
        }
    }

    class Stat{
        long total = 0;
        int count = 0;
    }

    Map<Integer, CheckIn> checkins = new HashMap<>();
    Map<String, Stat> stats = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        checkins.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn c = checkins.get(id);
        String key = c.station + "->" + stationName;
        Stat s = stats.get(key);
        if(s==null){
            s = new Stat();
            stats.put(key,s);
        }
        s.total += (t - c.time);
        s.count += 1;
        checkins.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        Stat s = stats.get(startStation + "->" + endStation);
        return (double)s.total / s.count;
    }
}
