import java.util.Scanner;

public class Utils {
    private static final int SIZE = 100;
    Menu menu = new Menu();
    Scanner input = new Scanner(System.in);
    Sign sign = new Sign();
    User[] users = new User[SIZE];
    public void start()
    {
        while (true)
        {
            switch (menu.welcomeMenu(input)) {
                case 1 -> sign.signInGet(input,users);
                case 2 -> sign.signUpUser(input,users);
            }
        }
    }

}
