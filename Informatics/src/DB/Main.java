package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Main {

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "fioletovobu27";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    //language=SQL
    private static final String SQL_SELECT_ALL_FROM_DRIVER = "select * from driver";

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        /*
        String sql = "insert into driver(first_name, last_name, age)\n" +
                "values ('Виталий', 'ДуБрОвЧиНсКи%', 64);";
        Statement statement = connection.createStatement();
        statement.execute(sql);\
         */

        UsersRepositoryJdbcImpl impl = new UsersRepositoryJdbcImpl(connection);

        List<User> list = impl.findAllByAge(12);
        list.forEach(System.out::println);
    }
}

