import java.util.Random;
import java.util.Scanner;

public class Utils {
    private static final int SIZE = 100;
    Scanner input = new Scanner(System.in);
    Sign sign = new Sign();
    User[] users = new User[SIZE];
    Other other = new Other();
    FlightAction flightAction = new FlightAction();
    Flight[] flights = new Flight[SIZE];
    Admin admin = new Admin();
    Random random = new Random();
    TicketAction ticketAction = new TicketAction();
    public void start()
    {
        flightAction.addDefultFlight(flights);
        while (true)
        {
            switch (sign.welcomeMenu(input)) {
                case 1 -> sign.signInGet(input,users,admin,flights,other,random , ticketAction ,flightAction);
                case 2 -> sign.signUpUser(input,users);
            }
        }
    }

}
