import java.util.Random;

public class Ticket {
    private String flightId;
    private String origin;
    private String destination;
    private String date;
    private String time;
    private int price;
    private String ticketId;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(Random random,Ticket[] tickets) {
        String randNum;
        randNum =Integer.toString(random.nextInt(100_000,1_000_000)) ;
        while (findTicketId(tickets,randNum))
        {
            randNum =Integer.toString(random.nextInt(100_000,1_000_000)) ;
        }
        this.ticketId = randNum;
    }
    private boolean findTicketId(Ticket[] tickets , String randNum )
    {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i]!= null && tickets[i].getTicketId()!= null && tickets[i].getTicketId().equals(randNum) )
            {
                return true;
            }
        }
        return false;
    }
}
