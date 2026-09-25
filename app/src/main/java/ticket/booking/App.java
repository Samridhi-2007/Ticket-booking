package ticket.booking;

import ticket.booking.entities.User;
import ticket.booking.services.UserBookingservice;
import ticket.booking.util.UserServiceUtil;

import java.io.IOException;
import java.util.*;

public class App {

    public static void main(String[] args) {

        System.out.println("Running Train Booking System");

        Scanner sc = new Scanner(System.in);

        int option = 0;

        UserBookingservice userBookingservice = null;

        try {
            userBookingservice = new UserBookingservice();

        } catch (IOException ex) {
            System.out.println("There is something wrong");
            return;
        }

        while (option != 7) {

            System.out.println("\nChoose options");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Fetch Bookings");
            System.out.println("4. Search Train");
            System.out.println("5. Book a Seat");
            System.out.println("6. Cancel my Booking");
            System.out.println("7. Exit the App");

            option = sc.nextInt();

            switch (option) {

                case 1:

                    System.out.println("Enter the username to signup");
                    String nameToSignUp = sc.next();

                    System.out.println("Enter the password to signup");
                    String passwordToSignUp = sc.next();

                    User userToSignUp = new User(
                            nameToSignUp,
                            passwordToSignUp,
                            UserServiceUtil.hashPassword(passwordToSignUp),
                            new ArrayList<>(),
                            UUID.randomUUID().toString()
                    );

                    Boolean result =
                            userBookingservice.signUp(userToSignUp);

                    if (result) {
                        System.out.println("Signup successful!");
                    } else {
                        System.out.println("Signup failed!");
                    }

                    break;

                case 2:
                    System.out.println("Login selected");
                    break;

                case 3:
                    System.out.println("Fetch bookings selected");
                    break;

                case 4:
                    System.out.println("Search train selected");
                    break;

                case 5:
                    System.out.println("Book seat selected");
                    break;

                case 6:
                    System.out.println("Cancel booking selected");
                    break;

                case 7:
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }

        sc.close();
    }
}