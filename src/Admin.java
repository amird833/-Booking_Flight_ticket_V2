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
                    updateFlight(flights,input);
                    break;
                case 3 :
                    removeFlight(input,flights);
                    break;
                case 4:
                    printFlight(flights);
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
        while (findExistFlightId(flights,flightId))
        {
            System.out.println("This flightId already EXIST");
            System.out.println("Try again");
            System.out.print(">>");
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
    private boolean findExistFlightId(Flight[] flights,String flightId)
    {
        for (Flight flight : flights) {
            if (flight != null && flight.getFlightId() != null && flight.getFlightId().equals(flightId))
                return true;

        }
        return false;
    }
    private void removeFlight(Scanner input,Flight[] flights)
    {
        System.out.print("Enter flightId : ");
        String flightId = input.next();
        while (!findExistFlightId(flights,flightId))
        {
            System.out.println("This flightId is INCORRECT!");
            System.out.println("Try again ");
            System.out.print("Enter flightId : ");
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
    private void updateFlight(Flight[] flights , Scanner input)
    {
        System.out.println("Enter flightId : ");
        String flightId = input.next();
        while (!findExistFlightId(flights,flightId))
        {
            System.out.println("This flightId is INCORRECT!");
            System.out.println("Try again ");
            System.out.print("Enter flightId : ");
            flightId = input.next();
        }
        int index = findFlightIdIndex(flights,flightId);
        switch (adminUpdateMenu(input)) {
            case 1 -> updateOrigin(flights[index], input);
            case 2 -> updateDestination(flights[index], input);
            case 3 -> updateDate(flights[index], input);
            case 4 -> updateTime(flights[index], input);
            case 5 -> updatePrice(flights[index], input);
            case 6 -> updateSeats(flights[index], input);
        }
    }
    private int adminUpdateMenu(Scanner input)
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
    private void updateOrigin(Flight flight ,Scanner input)
    {
        System.out.printf("Old Origin : %s",flight.getOrigin());
        System.out.print("New Origin : ");
        flight.setOrigin(input.next());
    }
    private void updateDestination(Flight flight ,Scanner input)
    {
        System.out.printf("Old Destination : %s",flight.getDestination());
        System.out.print("New Destination : ");
        flight.setDestination(input.next());
    }
    private void updateDate(Flight flight ,Scanner input)
    {
        System.out.printf("Old Date : %s",flight.getDate());
        System.out.print("New Date : ");
        flight.setDate(input.next());
    }
    private void updateTime(Flight flight ,Scanner input)
    {
        System.out.printf("Old Time : %s",flight.getTime());
        System.out.print("New Time : ");
        flight.setTime(input.next());
    }
    private void updatePrice(Flight flight ,Scanner input)
    {
        System.out.printf("Old Price : %d",flight.getPrice());
        System.out.print("New Price : ");
        flight.setPrice(input.nextInt());
    }
    private void updateSeats(Flight flight ,Scanner input)
    {
        System.out.printf("Old Seats : %d",flight.getSeats());
        System.out.print("New Seats : ");
        flight.setSeats(input.nextInt());
    }
    private void printFlight(Flight[] flights)
    {
        for (int i = 0; i < flights.length; i++)
            if (flights[i] != null && flights[i].getFlightId() != null) {
                System.out.printf("\t%6s       |%6s       |%6s       |%6s       |%6s       %|10d       |%3d\n", flights[i].getFlightId(), flights[i].getOrigin(), flights[i].getDestination(), flights[i].getDate(), flights[i].getTime(), flights[i].getPrice(), flights[i].getSeats());
            }
    }
}
