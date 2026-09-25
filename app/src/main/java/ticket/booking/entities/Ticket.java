package ticket.booking.entities;
import java.util.Date;

public class Ticket {
    private String ticketid;
    private String userid;
    private String source;
    private String destination;
    private Date dateoftravel;
    private Train train;
    public  Ticket(){}
    public  Ticket(String ticketid, String userid, String source, String destination,Date dateoftravel ,Train train){
        this.dateoftravel=dateoftravel;
        this.destination=destination;
        this.ticketid=ticketid;
        this.train=train;
        this.source=source;
        this.userid=userid;
    }
    public String  getTicketInfo(){
       return String.format("Ticket ID: %s belongs to User %s from %s to %s on %s", ticketid, userid,source,destination,dateoftravel);
    }

    public String getTicketid() {
        return ticketid;
    }

    public void setTicketid(String ticketid) {
        this.ticketid = ticketid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDateoftravel() {
        return dateoftravel;
    }

    public void setDateoftravel(Date dateoftravel) {
        this.dateoftravel = dateoftravel;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
