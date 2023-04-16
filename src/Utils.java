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
    Ticket[] tickets = new Ticket[SIZE*10];
    Random random = new Random();
    public void start()
    {
        flightAction.addDefultFlight(flights);
        while (true)
        {
            switch (sign.welcomeMenu(input)) {
                case 1 -> sign.signInGet(input,users,admin,flights,other,random , tickets ,flightAction);
                case 2 -> sign.signUpUser(input,users);
            }
        }
    }

}
