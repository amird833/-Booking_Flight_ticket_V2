import java.util.Scanner;

public class SignIn {
    public void signInGet(Scanner input , User[] users)
    {
        String username;
        String password;
        int index;
        System.out.print("Username : ");
        username = input.next();
        while (!checkAdminUsername(username) || !checkUserUsername(users,username) )
        {
            System.out.println("Cant find this user!");
            System.out.println("Try again");
            System.out.printf(">>");
            username = input.next();
        }
        System.out.print("Password : ");
        password = input.next();
        if (checkAdminUsername(username))
        {

            while (!checkAdminPassword(password))
            {
                System.out.println("Wrong password!");
                System.out.println("Try again");
                System.out.print(">>");
                password = input.next();
            }
            System.out.println("Welcome admin :)");
        }
        else
        {
            index = findIndexOfUser(users,username);
            while (!checkUserPassword(users[index],password))
            {
                System.out.println("Wrong password!");
                System.out.println("Try again");
                System.out.print(">>");
                password = input.next();
            }
        }
    }
    private boolean checkAdminUsername(String userName )
    {
        return userName.equals("admin") || userName.equals("Admin") || userName.equals("ADMIN");
    }
    private boolean checkAdminPassword(String passWord)
    {
        return passWord.equals("admin")||passWord.equals("Admin")||passWord.equals("ADMIN");
    }
    private boolean checkUserUsername(User[] users,String userName)
    {
        if (users[0] == null)
            return true;
        for (User user : users) {
            if (user.getUsername() != null && user.getUsername().equals(userName))
                return true;
        }
        return false;
    }
    private boolean checkUserPassword(User user,String passWord)
    {
        if (user.getPassword() != null && user.getPassword().equals(passWord))
            return true;

        return false;
    }
    private int findIndexOfUser(User[] users,String username)
    {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername() != null && users[i].getUsername().equals(username))
                return i;

        }
        return 0;
    }
}
