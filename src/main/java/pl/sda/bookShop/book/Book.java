package pl.sda.bookShop.book;
public class Book{

    private final String author;
    private final String title;
    private double rating;
    private double price;


    public Book(String author, String title) {
        this.author = author;
        this.title = title;
        this.rating = 0;
        this.price = 14.99;
    }

    public Book(String author, String title, double rating) {
        this.author = author;
        this.title = title;
        this.rating = rating;
        this.price = 14.99;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        return title != null ? title.equals(book.title) : book.title == null;
    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  "Author : " + author + '\n' +
                "Title : " + title + '\n' +
                "Average Rating : " + rating + '\n' +
                "Price book: " + price + '\n' +
                "";
    }

//
}
