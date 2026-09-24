package ticket.booking.entities;

import java.util.List;

public class User {

    private String user;
    private String password;
    private String hashPassword;
    private List<Ticket> ticketsBooked;
    private String userId;
}