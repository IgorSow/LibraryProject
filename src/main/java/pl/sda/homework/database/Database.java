package pl.sda.homework.database;

import pl.sda.homework.book.Book;

import java.sql.*;
import java.util.logging.Logger;

public class Database {

    Logger log = Logger.getLogger(String.valueOf(Database.class));

    private Connection connection;
    private final String USERNAME;
    private final String PASSWORD;
    private final String HOST;


    public Database(String host, String username, String password) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        this.HOST = host;
        this.USERNAME = username;
        this.PASSWORD = password;

    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);

        if (!connection.isClosed()) log.info("Connection to Database successfully");
        else throw new RuntimeException("Connection faild");
    }

    public void disconnect() throws SQLException {
        if (!connection.isClosed()) {
            connection.close();
            log.info("Disconcert successfully");
        } else throw new RuntimeException("Disconnect failed");
    }

    public void addBook(Book book) throws SQLException {
        String author = book.getAuthor();
        String title = book.getTitle();
        double rating = book.getRating();
        double price = book.getPrice();

        if (!isInDatabase(book)) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO books VALUES (null,?,?,?,?)");
            preparedStatement.setString(1, author);
            preparedStatement.setString(2, title);
            preparedStatement.setDouble(3, rating);
            preparedStatement.setDouble(4, price);
            preparedStatement.execute();
            log.info("Successful added");
        } else {
            log.info("ksiazka istnieje");
        }
    }

    private boolean isInDatabase(Book book) throws SQLException {
        String title2 = book.getTitle();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE title = ?");
        preparedStatement.setString(1, title2);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    public void addAmountToStorage(Book book, int amount) throws SQLException {
        String title = book.getTitle();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE storage SET amount = ? WHERE title =?");

        preparedStatement.setInt(1,amount);
        preparedStatement.setString(2,title);
        preparedStatement.execute();
        log.info("Successful change amount");



    }

    public void showBooks() throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from books");
        while (resultSet.next()) {
            System.out.println("Books: ");
            String author = resultSet.getString("author");
            System.out.println(author);
            String title = resultSet.getString("title");
            System.out.println(title);
            String rating = resultSet.getString("rating");
            System.out.println(rating);
            String price = resultSet.getString("price");
            System.out.println(author);
            System.out.println();

        }


    }

}
