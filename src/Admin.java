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
    public void adminAction(Scanner input,Flight[] flights , FlightAction flightAction ,Admin admin)
    {
        int exitFlag = 0;
        while (exitFlag == 0)
        {
            switch (adminMenu(input)) {
                case 1 -> flightAction.addFlight(input, flights);
                case 2 -> flightAction.updateFlight(flights, input , admin);
                case 3 -> flightAction.removeFlight(input, flights);
                case 4 -> flightAction.printFlight(flights);
                case 0 -> exitFlag = 1;
            }
        }

    }
    public int adminUpdateMenu(Scanner input)
    {
        int chose;
        System.out.println("Select number");
        System.out.println("< 1 > Origin");
        System.out.println("< 2 > Destination");
        System.out.println("< 3 > Date");
        System.out.println("< 4 > Time");
        System.out.println("< 5 > Price");
        System.out.println("< 6 > Seats");
        System.out.print(">>");
        chose = input.nextInt();
        while (chose > 6 || chose<1)
        {
            System.out.println("Try again!");
            System.out.print(">>");
            chose = input.nextInt();
        }
        return chose;
    }

}
