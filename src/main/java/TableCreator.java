import java.sql.*;

public class TableCreator {
    private static final String USER = "Info_Comp";
    private static final String PASSWORD = ";bpymghtrhfcyf0311";
    private static final String URL = "jdbc:mysql://localhost:3306/bank_db?useUnicode=true&serverTimezone=UTC";


    public static void createTable(String query) throws ClassNotFoundException, SQLException {
        {
            Class.forName("com.mysql.cj.jdbc.Driver");  //1.Регистрация драйвера
            Connection connection = null;
            Statement statement = null;
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);  //2.установка соединения
                statement = connection.createStatement();   //3.Создать Statement
                statement.execute(query);   //4.Выполнить запрос к БД
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            statement.close();
            connection.close(); //5.Закрытие соединения
        }
    }
}
