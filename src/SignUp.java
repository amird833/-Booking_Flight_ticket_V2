import java.util.Scanner;

public class SignUp {
    public void signingUpUser(Scanner input, User[] users)
    {
        String username;
        System.out.println("Username : ");
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
        System.out.println("Password : ");
        users[index].setPassword(input.next());
    }
    private boolean checkUsername(User[] users,String username)
    {
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
}
