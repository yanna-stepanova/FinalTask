import dao.UsersDao;
import model.Users;

import java.util.Scanner;
import java.sql.SQLException;

public class App {
    private static final String queryUsers = "create table Users(\n" +
            "user_id bigint not null auto_increment,\n" +
            "user_name varchar(50) not null,\n" +
            "acct_id bigint,\n" +
            "primary key(user_id),\n" +
            "foreign key(acct_id) references accouts(acct_id)\n" +
            " );";
    private static final String queryAccounts = "CREATE TABLE Accounts (\n" +
            "    'acct_id' BIGINT NOT NULL AUTO_INCREMENT,\n" +
            "    'user_id' BIGINT NOT NULL,\n" +
            "    'acct_money' DOUBLE(8 , 2 ),\n" +
            "    'acct_date' DATE,\n" +
            "    PRIMARY KEY ('acct_id' , 'user_id'),\n" +
            "    FOREIGN KEY ('user_id')\n" +
            "        REFERENCES users ('user_id')\n" +
            ");";

    public static void main(String[] args)throws SQLException, ClassNotFoundException {
        TableCreator.createTable(queryUsers);
        String answer;
        do {
            System.out.print("1) Create User\n" +
                    "2) Create account\n" +
                    "Input number: ");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch(choice){
            case 1:
                String answerUser;
                do {
                    UsersDao usersDao = new UsersDao();
                    System.out.println("User's name:");
                    Users users1 = new Users();
                    users1.setName(scan.next());
                    usersDao.createUser(users1);
                    System.out.println("Do you want to create user? y/n : ");
                    answerUser = scan.next();
                }while (answerUser.equals("y")==true);
                    break;
            case 2:
                break;
            default:
                System.out.println("Make some choice, please.");
                break;
        }


        System.out.print("Continue? (y/n): ");
        answer = scan.next();
    } while (answer.equals("y") == true);
}
}
