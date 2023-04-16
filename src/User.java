import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private int vault;
    public Ticket[] tickets = new Ticket[10];




    public User() {
        vault = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getVault() {
        return vault;
    }

    public void setVault(int vault) {
        this.vault = vault;
    }
    public void addCharge(Scanner input)
    {
        System.out.printf("You have %,d\n",vault);
        System.out.print("Add ");
        vault += input.nextInt();
    }
}
