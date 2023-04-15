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
            switch (adminMenu(input)) {
                case 1 -> addFlight(input, flights);
                case 2 -> updateFlight(flights, input);
                case 3 -> removeFlight(input, flights);
                case 4 -> printFlight(flights);
                case 0 -> exitFlag = 1;
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
        for (Flight flight : flights)
            if (flight != null && flight.getFlightId() != null) {
                System.out.printf("\t%-10s       | %-10s       | %-10s       | %-10s       | %-10s       | %-,10d       | %-3d\n", flight.getFlightId(), flight.getOrigin(), flight.getDestination(), flight.getDate(), flight.getTime(), flight.getPrice(), flight.getSeats());
            }
    }
    public void addDefultFlight(Flight[] flights)
    {
        flights[0] = new Flight();
        flights[1] = new Flight();
        flights[2] = new Flight();
        flights[0].setFlightId("WX-12");
        flights[0].setOrigin("Yazd");
        flights[0].setDestination("Tehran");
        flights[0].setDate("1401-12-10");
        flights[0].setTime("12:30");
        flights[0].setPrice(700000);
        flights[0].setSeats(51);

        flights[1].setFlightId("WZ-15");
        flights[1].setOrigin("Mashhad");
        flights[1].setDestination("Ahvaz");
        flights[1].setDate("1401-12-11");
        flights[1].setTime("08:00");
        flights[1].setPrice(900000);
        flights[1].setSeats(245);

        flights[2].setFlightId("BG-22");
        flights[2].setOrigin("Shiraz");
        flights[2].setDestination("Tabriz");
        flights[2].setDate("1401-12-12");
        flights[2].setTime("22:30");
        flights[2].setPrice(1100000);
        flights[2].setSeats(12);
    }
}
