import java.util.Scanner;

public class Utils {
    private static final int SIZE = 100;
    Scanner input = new Scanner(System.in);
    Sign sign = new Sign();
    User[] users = new User[SIZE];
    Admin admin = new Admin();
    Flight[] flights = new Flight[SIZE];
    public void start()
    {
        while (true)
        {
            switch (sign.welcomeMenu(input)) {
                case 1 -> sign.signInGet(input,users,admin,flights);
                case 2 -> sign.signUpUser(input,users);
            }
        }
    }

}
