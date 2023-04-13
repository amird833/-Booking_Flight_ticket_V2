import java.util.Scanner;

public class Utils {
    Menu menu = new Menu();
    Scanner input = new Scanner(System.in);
    public void start()
    {
        while (true)
        {
            switch (menu.welcomeMenu(input)) {
                case 1 -> System.out.println("1");
                case 2 -> System.out.println("2");
            }
        }
    }

}
