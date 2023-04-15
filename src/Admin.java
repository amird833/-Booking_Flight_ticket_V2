import java.util.Scanner;

public class Admin {
    private int adminMenu(Scanner input)
    {
        int chose;
        System.out.println("1- Add");
        System.out.println("2- Update");
        System.out.println("3- Remove");
        System.out.println("4 - Flight schedules");
        System.out.println("0 - Sign out");
        System.out.print(">>");
        chose = input.nextInt();
        while (chose > 4 || chose<0)
        {
            System.out.println("Try again!");
            System.out.print(">>");
            chose = input.nextInt();
        }
        return chose;
    }
    public void adminAction(Scanner input,Flight[] flights)
    {
        int exitFlag = 0;
        while (exitFlag == 0)
        {
            switch (adminMenu(input))
            {
                case 1 :
                    break;
                case 2 :
                    break;
                case 3 :
                    break;
                case 4:
                    break;
                case 0:
                    exitFlag = 1;
                    break;
            }
        }

    }

}
