package pl.sda.homework.database;

import pl.sda.homework.book.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class database {

    Logger log = Logger.getLogger(String.valueOf(database.class));

    private Connection connection;
    private final String USERNAME;
    private final String PASSWORD;
    private final String HOST;

    public database(String host, String username, String password) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        this.HOST = host;
        this.USERNAME = username;
        this.PASSWORD = password;

    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(HOST,USERNAME,PASSWORD);

        if (!connection.isClosed()) log.info("Connection to database successfully");
        else throw new RuntimeException("Connection faild");
    }
    public void disconnect () throws SQLException {
        if (!connection.isClosed()){
            connection.close();
            log.info("Disconcert successfully");
        }else throw new RuntimeException("Disconnect failed");
    }

    public void addBook(Book book) throws SQLException {
    String author = book.getAuthor();
    String title = book.getTitle();
    double rating = book.getRating();
    double price = book.getPrice();

        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO books VALUES (null,?,?,?,?)");
        preparedStatement.setString(1,author);
        preparedStatement.setString(2,title);
        preparedStatement.setDouble(3,rating);
        preparedStatement.setDouble(4,price);
        preparedStatement.execute();
        log.info("Successful added");

    }
}
