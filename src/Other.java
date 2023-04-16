import java.util.Random;
import java.util.Scanner;

public class Other {
    public void otherAction(Scanner input , Flight[] flights , User user,Random random , Ticket[] tickets , FlightAction flightAction)
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
                    flightAction.filterFlight(flights,input);
                    break;
                case 3:
                    bookingTicket(random , tickets , user , input , flights ,flightAction );
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
    private void cancellation(Ticket[] tickets , User user , Scanner input)
    {
        String ticketId;
        System.out.printf("Enter ticketId : ");
        ticketId = input.next();
/////////////////////////////////////////////////////////////////////////////
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
    private void bookingTicket(Random random ,Ticket[] tickets , User user, Scanner input , Flight[] flights , FlightAction flightAction)
    {
        String flightId;
        int indexFlight;
        int indexTicket;
        System.out.print("Enter flightId : ");
        flightId = input.next();
        while (!flightAction.findExistFlightId(flights,flightId))
        {
            System.out.println("Cant find this flightId :(");
            System.out.println("Try again");
            System.out.printf("Enter flightId : ");
            flightId = input.next();
        }
        indexFlight = flightAction.findFlightIdIndex(flights,flightId);
        if (flights[indexFlight].getSeats() ==0)
        {
            System.out.println("This flight dont have any seats");
        }
        else if (flights[indexFlight].getPrice() > user.getVault())
        {
            System.out.println("You dont have enugh many :(");
        }
        else
        {
            indexTicket = tickets[0].findNullTicket(tickets);
            tickets[indexTicket].setTicketId(random , tickets);
            tickets[indexTicket].setFlightId(flights[indexFlight].getFlightId());
            tickets[indexTicket].setOrigin(flights[indexFlight].getOrigin());
            tickets[indexTicket].setDestination(flights[indexFlight].getDestination());
            tickets[indexTicket].setDate(flights[indexFlight].getDate());
            tickets[indexTicket].setPrice(flights[indexFlight].getPrice());
            tickets[indexTicket].setTime(flights[indexFlight].getTime());
            tickets[indexTicket].setUsername(user.getUsername());
            user.setVault(user.getVault() - flights[indexFlight].getPrice());
            flights[indexFlight].setSeats(flights[indexFlight].getSeats()-1);
        }
    }

    private void changeUserPassword(User user,Scanner input)
    {
        System.out.printf("Old password : %s\n", user.getPassword());
        System.out.print("New password : ");
        user.setPassword(input.next());
        System.out.println("Change successfully");
    }

}
