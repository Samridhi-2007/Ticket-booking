package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.User;
import ticket.booking.util.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserBookingservice {

    private User user;
    private List<User> userList;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final String USER_PATH = "../localDB/users.json";

    public UserBookingservice(User user1) throws IOException {
        this.user = user1;
        loadUsers();
    }

    public UserBookingservice() throws IOException {
        loadUsers();
    }

    public void loadUsers() throws IOException {

        File users = new File(USER_PATH);

        userList = objectMapper.readValue(
                users,
                new TypeReference<List<User>>() {}
        );
    }

    public Boolean loginUser() {

        Optional<User> foundUser = userList.stream()
                .filter(user1 ->
                        user1.getName().equals(user.getName())
                                && UserServiceUtil.checkPassword(
                                user.getPassword(),
                                user1.getHashPassword()
                        ))
                .findFirst();

        return foundUser.isPresent();
    }

    public Boolean signUp(User user1) {

        try {
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;

        } catch (IOException ex) {
            return Boolean.FALSE;
        }
    }

    private void saveUserListToFile() throws IOException {

        File usersFile = new File(USER_PATH);

        objectMapper.writeValue(
                usersFile,
                userList
        );
    }

    public void fetchBooking() {

        user.printTickets();
    }

    public Boolean cancelBooking(String ticketId) throws IOException {

        Optional<User> foundUser = userList.stream()
                .filter(user1 ->
                        user1.getUserId().equals(user.getUserId()))
                .findFirst();

        if (foundUser.isPresent()) {

            User loggedInUser = foundUser.get();

            boolean removed = loggedInUser.getTicketsBooked()
                    .removeIf(ticket ->
                            ticket.getTicketid().equals(ticketId));

            if (removed) {
                saveUserListToFile();
                return true;
            }
        }

        return false;
    }
}