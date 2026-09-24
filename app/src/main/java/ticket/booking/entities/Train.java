package ticket.booking.entities;
import java.util.List;

import java.sql.Time;
import java.util.Map;

public class Train {
    private String trainid;
    private String trainNo;
    private List<List<Integer>> seats;
    private Map<String, Time> stationsTimes;
    private List<String> stations;
}
