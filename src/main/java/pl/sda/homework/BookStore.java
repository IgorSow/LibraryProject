package pl.sda.homework;

import java.util.*;

public class BookStore {

    private final Set<Book> bookCollection;
    private final Map<Book, Integer> bookStorage; // Magazyn ->> klucz książka (equals autor+tytuł)
    // wartość - ilość sztuk w magazynie

    public BookStore() {
        Book book7 = new Book("Brent Weeks", "Nie znana", 1.0);
        Book book1 = new Book("Jakub Ćwiek", "Kłamca", 7.5);
        Book book2 = new Book("Jarosław Grzędowicz", "Pan Lodowego Ogrodu TOM 1", 8.3);
        Book book3 = new Book("Andrzej Sapkowski", "Pani Jeziorna", 1.0);
        Book book4 = new Book("Marcin Przybyłek", "Gamedec Zabaweczki", 7.1);
        Book book5 = new Book("Brent Weeks", "Czarny Pryzmat", 9.1);
        Book book6 = new Book("Brent Weeks", "Droga Cienia", 9.8);


        bookCollection = new HashSet<>();
        bookCollection.add(book7);
        bookCollection.add(book1);
        bookCollection.add(book2);
        bookCollection.add(book3);
        bookCollection.add(book4);
        bookCollection.add(book5);
        bookCollection.add(book6);


        bookStorage = new HashMap<>();

        bookStorage.put(book1, 7);
        bookStorage.put(book2, 3);
        bookStorage.put(book3, 11);
        bookStorage.put(book4, 22);
        bookStorage.put(book5, 9);
        bookStorage.put(book6, 47);
        bookStorage.put(book7, 2);
    }

    int collectionSize() { // metoda pomocna do junitów - nie potrzebna do działania programu
        return bookCollection.size();
    }

    public void showBookCollection() {
//        bookCollection.forEach(System.out::println); //->> java 8 lambda skrócona
//        bookCollection.forEach(book -> System.out.println(book));// ->> java 8 lambda
        for (Book book : bookCollection) { // pętla foreach -> iterujemy każdy element, ale nie mamy wiedzy która jest to iteracja
            System.out.println(book);

        }
    }

    public void addBook(Book book) {
        //dodać książkę do kolekcji
        bookCollection.add(book);
        bookStorage.put(book, 0);
        // TODO dla chętnych - jesli dodajemy do kolekcji książek nową pozycje
        // to w magazynie powinna pojawić się taka z ilością 0.

        System.out.println("Dodano nową książkę do kolekcji: " + book);
    }

    public boolean findAuthorInCollection(String nameOfAuthor) { // metoda na potrzeby testow


        for (Book book : bookCollection) {
            if (book.getAuthor().equalsIgnoreCase(nameOfAuthor) == true) {
                return true;
            }
        }
        return false;
    }

    public void removeBookByTitle(String bookToRemove) {
        // usuwa ksiazke z kolekcji po nazwie :

        for (Book book : bookCollection) {

            boolean compare = book.getTitle().equals(bookToRemove);

            if (compare == true) {
                bookCollection.remove(book);
                System.out.println("Zostala usunieta ksiazka : ");
                System.out.println(book);
                System.out.println(collectionSize());
            }
        }
    }

    public void removeAllBooksOfAuthor(String nameOfAuthor) {

        int amountOfRemovedBooks = 0;

        for (Book book : bookCollection) {

            if (true == book.getAuthor().equals(nameOfAuthor)) {
                bookCollection.remove(book);
            }
        }
        System.out.println("Usunieto : " + amountOfRemovedBooks + " ksiazek " + nameOfAuthor);
    }

    public List<Book> returnBooksSortedByTitle() {

        List<Book> tempCollection = new ArrayList<>();

        tempCollection.addAll(bookCollection);

        tempCollection.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {

                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return tempCollection;
    }

    public List<Book> returnBooksSortedByAuthor() {

        List<Book> tempCollection = new ArrayList<Book>();

        tempCollection.addAll(bookCollection);


        tempCollection.sort(new Comparator<Book>() {

            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthor().compareTo(o2.getAuthor());
            }
        });
        System.out.println(tempCollection);
        return tempCollection;
    }

    public List<Book> returnBooksSortedByRating() {

        List<Book> tempCollection = new ArrayList<Book>();

        tempCollection.addAll(bookCollection);

        tempCollection.sort(new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return -Double.compare(book1.getRating(), book2.getRating());
            }
        });
//        System.out.println(tempCollection);
        return tempCollection;
    }

    public List<Book> returnAuthorsCollectionsSortedByOption(String nameOfAutor, List<Book> orderOfList) {
        List<Book> tempCollections = new ArrayList<Book>();
        List<Book> ret = new ArrayList<Book>();

        tempCollections.addAll(orderOfList);


        for (int i = 0; i < tempCollections.size(); i++) {

            if (tempCollections.get(i).getAuthor().equalsIgnoreCase(nameOfAutor)) {

                ret.add(tempCollections.get(i));
            }
        }
        return ret;
    }


    /// STORAGE


    public void reviewOfStorage() {

        bookStorage.forEach((key, value) -> System.out.println(key + " \n szt. na magazynie: " + value + "\n"));


    }

    public void addBookToStorage(String nameOfAuthor, String title, int amountOfbooks) {
        Book bookToAdd = new Book(nameOfAuthor, title);
        boolean a = bookStorage.containsKey(bookToAdd);

        System.out.println(a);

        if (bookStorage.containsKey(bookToAdd)) {
            bookStorage.merge(bookToAdd, amountOfbooks, Integer::sum);
            System.out.println("Zostala zwiekszona ilosc o : " + amountOfbooks);
        } else {
            bookStorage.put(bookToAdd, amountOfbooks);
            System.out.println("Niestety nie bylo ksiazki na magazynie, ale dodano nowa ksiazke");
        }


    }

    public void returnSortedStorage(){
        
        Map<Book, Integer> temporatyStore= new TreeMap<>();

        temporatyStore.putAll(bookStorage);

        System.out.println(temporatyStore);
    }
}
