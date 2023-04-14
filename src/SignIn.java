import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Scanner;

public class SignIn {
    public void signInGet(Scanner input)
    {
        String username;
        String password;
        System.out.printf("Username : ");
        username = input.next();
        if (adminSignInPassword(username))
        {
            System.out.printf("Password : ");
            password = input.next();
            while (!adminSignInPassword(password))
            {
                System.out.println("Wrong password!");
                System.out.println("Try again");
                System.out.printf(">>");
                password = input.next();
            }
            System.out.println("Welcome admin :)");
        }
        else
        {
            System.out.println("username not admin");
        }
    }
    private boolean adminSignInUsername(String userName )
    {
        return userName.equals("admin") || userName.equals("Admin") || userName.equals("ADMIN");
    }
    private boolean adminSignInPassword(String passWord)
    {
        return passWord.equals("admin")||passWord.equals("Admin")||passWord.equals("ADMIN");
    }
}
