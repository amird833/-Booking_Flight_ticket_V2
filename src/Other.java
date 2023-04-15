import java.util.Scanner;

public class Other {
    public void otherAction(Scanner input , Flight[] flights , User user)
    {
        int exitFlag =0 ;
        while (exitFlag == 0)
        {
            switch (otherMenu(input))
            {
                case 1:
                    changeUserPassword(user,input);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    exitFlag = 1;
                    break;
            }
        }
    }
    private int otherMenu(Scanner input)
    {
        int chose;
        System.out.println("Select number");
        System.out.println("< 1 > Change password");
        System.out.println("< 2 > Search flight tickets");
        System.out.println("< 3 > Booking ticket");
        System.out.println("< 4 > Ticket cancellation");
        System.out.println("< 5 > Booked tickets");
        System.out.println("< 6 > Add charge");
        System.out.println("< 0 > Sign out");
        System.out.print(">>");
        chose = input.nextInt();
        while (chose >6 || chose < 0 )
        {
            System.out.println("Try again!" );
            System.out.print(">>");
            chose=input.nextInt();
        }
        return chose;
    }
    private void changeUserPassword(User user,Scanner input)
    {
        System.out.printf("Old password : %s\n", user.getPassword());
        System.out.print("New password : ");
        user.setPassword(input.next());
        System.out.println("Change successfully");
    }
}
