import java.util.Random;
import java.util.Scanner;

public class Other {
    public void otherAction(Scanner input , Flight[] flights , User user,Random random , TicketAction ticketAction , FlightAction flightAction , User[] users)
    {
        int exitFlag =0 ;
        while (exitFlag == 0)
        {
            switch (otherMenu(input)) {
                case 1 -> changeUserPassword(user, input);
                case 2 -> flightAction.filterFlight(flights, input);
                case 3 -> ticketAction.bookingTicket(user, input, flightAction, flights, users, random);
                case 4 -> ticketAction.cancellationTicket(user, input, flights, flightAction);
                case 5 -> ticketAction.printTicket(user, flights);
                case 6 -> user.addCharge(input);
                case 0 -> exitFlag = 1;
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
