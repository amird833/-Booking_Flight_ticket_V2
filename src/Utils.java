import java.util.Scanner;

public class Utils {
    Menu menu = new Menu();
    Scanner input = new Scanner(System.in);
    SignIn signin = new SignIn();
    public void start()
    {
        while (true)
        {
            switch (menu.welcomeMenu(input)) {
                case 1 -> signin.signInGet(input);
                case 2 -> System.out.println("2");
            }
        }
    }

}
