import java.util.Scanner;

public class Sign {
    public  int welcomeMenu(Scanner input)
    {
        int chose;
        System.out.println("1- Sign in ");
        System.out.println("2- Sign up");
        System.out.print(">>");
        chose = input.nextInt();
        while (chose > 2 || chose <1)
        {
            System.out.println("Try again!");
            System.out.print(">>");
            chose = input.nextInt();
        }
        return chose;
    }
    public void signUpUser(Scanner input, User[] users)
    {
        String username;
        System.out.print("Username : ");
        username = input.next();
        int index;
        while (checkUsername(users,username))
        {
            System.out.println("This username is already EXIST !");
            System.out.println("Try again");
            System.out.print(">>");
            username = input.next();
        }
        index = findIndex(users);
        users[index].setUsername(username);
        System.out.print("Password : ");
        users[index].setPassword(input.next());
    }
    private boolean checkUsername(User[] users,String username)
    {
        if (username.equals("Admin") || username.equals("ADMIN")||username.equals("admin"))
            return true;
        for (User user : users) {
            if (user != null && user.getUsername().equals(username))
                return true;

        }

        return false;
    }
    private int findIndex(User[] users)
    {
        for (int i = 0; i < users.length; i++) {
            if (users[i]==null) {
                users[i] = new User();
                return i;
            }
        }
        return 0;
    }
    public void signInGet(Scanner input , User[] users,Admin admin)
    {
        String username;
        String password;
        int index;
        System.out.print("Username : ");
        username = input.next();
        while (!checkUserUsername(users,username)  )
        {
            System.out.println("Cant find this user!");
            System.out.println("Try again");
            System.out.print(">>");
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
            admin.adminAction(input);
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
            System.out.printf("Welcome %s",users[index].getUsername());
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
        else if (userName.equals("admin")||userName.equals("ADMIN")||userName.equals("Admin"))
            return true;
        for (User user : users) {
            if (user.getUsername() != null && user.getUsername().equals(userName))
                return true;
        }
        return false;
    }
    private boolean checkUserPassword(User user,String passWord)
    {
        return user.getPassword() != null && user.getPassword().equals(passWord);
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
