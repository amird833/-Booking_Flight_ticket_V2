import java.util.Scanner;

public class Utils {
    Menu menu = new Menu();
    Scanner input = new Scanner(System.in);
    SignIn signin = new SignIn();
    User[] users = new User[100];
    public void start()
    {
        while (true)
        {
            switch (menu.welcomeMenu(input)) {
                case 1 -> signin.signInGet(input,users);
                case 2 -> System.out.println("2");
            }
        }
    }

}
