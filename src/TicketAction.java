import java.util.Random;
import java.util.Scanner;

public class TicketAction {
    public void bookingTicket(User user , Scanner input , FlightAction flightAction , Flight[] flights , User[] users , Random random)
    {
        String flightId;
        int indexFlight;
        System.out.println("Enter flightId");
        flightId = input.next();
        while (!flightAction.findExistFlightId(flights,flightId))
        {
            System.out.println("Wrong flightId !");
            System.out.println("Try again");
            System.out.printf("Enter flightId :");
            flightId = input.next();
        }
        indexFlight = flightAction.findFlightIdIndex(flights,flightId);
        System.out.printf("%-10s       | %-10s       | %-10s       | %-10s       | %-10s       | %-,10d       | %-3d\n", flights[indexFlight].getFlightId(), flights[indexFlight].getOrigin(), flights[indexFlight].getDestination(), flights[indexFlight].getDate(), flights[indexFlight].getTime(), flights[indexFlight].getPrice(), flights[indexFlight].getSeats());
        bookingAction(flights[indexFlight], user , users,random);
    }
    private void bookingAction(Flight flight , User user , User[] users , Random random)
    {
        if (flight.getSeats() == 0)
        {
            System.out.println("This flight dont have any seats");
        }
        else if (flight.getPrice() > user.getVault())
        {
            System.out.println("You dont have enugh many :(");
        }
        else if (!freeCellTicket(user))
        {
            System.out.println("You reserve 10 ticket !");
            System.out.println("If you want reserve , get premium version :) ");
        }
        else
        {
            setTicket(user,flight,users,random);

        }
    }
    private boolean freeCellTicket(User user)
    {
        for (int i = 0; i < user.tickets.length; i++) {
            if (user.tickets[i] == null)
                return true;
        }
        return false ;
    }
    private int findNullTicket(User user)
    {
        for (int i = 0; i < user.tickets.length; i++) {
            if (user.tickets[i]==null)
            {
                user.tickets[i] = new Ticket();
                return i;
            }
        }
        return 0;
    }
    private String randTicketId(User[] users , Random random)
    {
        String randNum;
        randNum = Integer.toString(random.nextInt(100_000,1_000_000));
        while (findTicketId(users,randNum))
        {
            randNum = Integer.toString(random.nextInt(100_000,1_000_000));
        }
        return randNum;

    }
    private boolean findTicketId(User[] users , String ticketId)
    {
        for (int i = 0; i < users.length; i++) {
            for (int j = 0; j < users[i].tickets.length; j++) {
                if (users[i].tickets[j] != null && users[i].tickets[j].getTicketId().equals(ticketId))
                    return true;
            }
        }
        return false;
    }
    private void setTicket(User user , Flight flight ,User[] users , Random random )
    {
        int indexTicket;
        indexTicket = findNullTicket(user);
        user.tickets[indexTicket].setTicketId(randTicketId(users , random));
        user.tickets[indexTicket].setFlightId(flight.getFlightId());
        user.setVault(user.getVault()-flight.getPrice());
        flight.setSeats(flight.getSeats() - 1);
    }

}
