import java.util.Scanner;

public class Menu {
    private int chose;

    public int welcomeMenu(Scanner input)
    {
        chose=0;
        System.out.println("1- Sign in ");
        System.out.println("2- Sign up");
        System.out.print(">>");
        chose = input.nextInt();
        while (chose > 2 || chose <1)
        {
            System.out.println("Try again!");
            System.out.printf(">>");
            chose = input.nextInt();
        }
        return chose;
    }
}
