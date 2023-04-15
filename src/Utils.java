import java.util.Scanner;

public class Utils {
    private static final int SIZE = 100;
    Scanner input = new Scanner(System.in);
    Sign sign = new Sign();
    User[] users = new User[SIZE];
    Admin admin = new Admin();
    Other other = new Other();
    Flight[] flights = new Flight[SIZE];
    Ticket[] tickets = new Ticket[SIZE*10];
    public void start()
    {
        admin.addDefultFlight(flights);
        while (true)
        {
            switch (sign.welcomeMenu(input)) {
                case 1 -> sign.signInGet(input,users,admin,flights,other);
                case 2 -> sign.signUpUser(input,users);
            }
        }
    }

}
