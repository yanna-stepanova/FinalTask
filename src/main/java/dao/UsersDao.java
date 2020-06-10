package dao;

import model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UsersDao {
    private static final String USER = "Info_Comp";
    private static final String PASSWORD = ";bpymghtrhfcyf0311";
    private static final String URL = "jdbc:mysql://localhost:3306/bank_db?useUnicode=true&serverTimezone=UTC";
    private static final String SELECT_USER = "select*from users where user_id = ?;";
    private static final String INSERT_USER = "insert into  Users values(null, ?);";
    private static final String UPDATE_USER = "update Users set user_name = ? where user_id = ?;";
    private static final String DELETE_USER = "delete from users where user_id = ?;";
    private static final String SELECT_ALL_USERS = "select*from users;";

    public Users getUserById(long id){
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            PreparedStatement statement = connection.prepareStatement(SELECT_USER);
            statement.setString(1, String.valueOf(id)); //preparedStatement.setString(1, Long.toString(id));
            ResultSet result = statement.executeQuery();
            result.next();
            return convertToUser(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private Users convertToUser(ResultSet result) throws SQLException {
        long id = result.getLong("user_id");
        String name = result.getString("user_name");
        return new Users(id,name);
    }

    public void createUser(Users user){
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            PreparedStatement statement = connection.prepareStatement(INSERT_USER);
            statement.setString(1, user.getName());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void changeUser(long id, Users user){
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER);
            statement.setString(1, user.getName());
            statement.setString(2, Long.toString(id));
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(long id){
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            PreparedStatement statement = connection.prepareStatement(DELETE_USER);
            statement.setString(1, Long.toString(id));
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Users> getAllUsers(){
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(SELECT_ALL_USERS);
            List<Users> users = new ArrayList<>();
            while (result.next()){
                users.add(convertToUser(result));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        String strInfo = String.format(
                "---------------------    Users    ------------------------------\n" +
                        "|  user_id   |      user_name    |   acct_id                    | \n" +
                        "|------------|-------------------|-----------------------------|\n");

        Iterator<Users> iterUsers = getAllUsers().iterator();
        while(iterUsers.hasNext()){
            Users item = iterUsers.next();
            strInfo = strInfo.concat(String.format("|%1$-12d|%2$-19s|%3$-29s|\n",
                    item.getUserId(), item.getName(), item.getAccounts()));
        }
        strInfo = strInfo.concat(String.format(
                "|____________|___________________|_____________________________|"));
        return strInfo;
    }
}
