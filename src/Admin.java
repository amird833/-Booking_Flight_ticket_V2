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
                case 1 ://add
                    addFlight(input,flights);
                    break;
                case 2 :
                    removeFlight(input,flights);
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
    private void addFlight(Scanner input ,Flight[] flights)
    {
        int index;
        String flightId;
        System.out.print("FlightId : ");
        flightId = input.next();
        while (findExistFlighId(flights,flightId))
        {
            System.out.println("This flightId already EXIST");
            System.out.println("Try again");
            System.out.printf(">>");
            flightId = input.next();
        }
        index = findNullFlightIndex(flights);
        flights[index].setFlightId(flightId);
        System.out.print("\tOrigin : ");
        flights[index].setOrigin(input.next());
        System.out.print("\tDestination : ");
        flights[index].setDestination(input.next());
        System.out.print("\tDate : ");
        flights[index].setDate(input.next());
        System.out.print("\tTime : ");
        flights[index].setTime(input.next());
        System.out.print("\tPrice : ");
        flights[index].setPrice(input.nextInt());
        System.out.print("\tSeats : ");
        flights[index].setSeats(input.nextInt());
    }
    private int findNullFlightIndex(Flight[] flights)
    {
        for (int i = 0; i < flights.length; i++) {
            if(flights[i]!= null && flights[i].getFlightId() == null)
                return i;
        }
        for (int i = 0; i < flights.length; i++) {
            if (flights[i] == null) {
                flights[i] = new Flight();
                return i;
            }
        }
        return 0;
    }
    private boolean findExistFlighId(Flight[] flights,String flightId)
    {
        for (int i = 0; i < flights.length; i++) {
            if (flights[i] != null && flights[i].getFlightId() != null && flights[i].getFlightId().equals(flightId))
                return true;

        }
        return false;
    }
    private void removeFlight(Scanner input,Flight[] flights)
    {
        System.out.printf("Enter flightId : ");
        String flightId = input.next();
        while (!findExistFlighId(flights,flightId))
        {
            System.out.println("This flightId is INCORRECT!");
            System.out.println("Try again ");
            System.out.printf("Enter flightId : ");
            flightId = input.next();
        }
        int index = findFlightIdIndex(flights,flightId);
        flights[index]=null;
        System.out.println("Remove is successfully :)");
    }
    private int findFlightIdIndex(Flight[] flights , String flightId)
    {
        for (int i = 0; i < flights.length; i++)
        {
            if (flights[i]!=null && flights[i].getFlightId() != null && flights[i].getFlightId().equals(flightId))
                return i;
        }
        return 0;
    }
}
