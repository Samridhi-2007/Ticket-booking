package ticket.booking.entities;
import java.util.List;

import java.sql.Time;
import java.util.Map;

public class Train {
    private String trainid;
    private String trainNo;
    private List<List<Integer>> seats;
    private Map<String, String> stationsTimes;
    private List<String> stations;

    public  Train(){}

    public  Train(String trainid, String trainNo, List<List<Integer>> seats, Map<String,String>stationsTimes,List<String>stations){
        this.trainNo= trainNo;
        this.trainid= trainid;
        this.stationsTimes=stationsTimes;
        this.stations=stations;
        this.seats= seats;
    }

    public String getTrainid() {
        return trainid;
    }

    public void setTrainid(String trainid) {
        this.trainid = trainid;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public List<List<Integer>> getSeats() {
        return seats;
    }

    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }

    public Map<String, String> getStationsTimes() {
        return stationsTimes;
    }

    public void setStationsTimes(Map<String, String> stationsTimes) {
        this.stationsTimes = stationsTimes;
    }
    public  String getTrainInfo(){
        return String.format("Train ID: %s Train No: %s",trainid, trainNo);
    }
}
