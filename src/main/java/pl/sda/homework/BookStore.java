package pl.sda.homework;

import pl.sda.homework.book.Book;

import java.util.*;

public class BookStore {

    private final Set<Book> bookCollection;
    private final Map<Book, Integer> bookStorage; // Magazyn ->> klucz książka (equals autor+tytuł)
    private double account = 0;


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

    int bookStorageSize() {
        return bookStorage.size();
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

        Book findedElement = null;

// wersja z iteratorem
//        List<Book>  lb = new ArrayList<>();

//        Iterator<Book> iterator = bookCollection.iterator();
//        int i = 0;
//        while (iterator.hasNext()){
//
//            System.out.println(i);
//            Book next = iterator.next();
//            System.out.println(next);
//            i++;
//
//        }
//
//
        for (Book book : bookCollection) {
            boolean compare = book.getTitle().equals(bookToRemove);

            if (compare == true) {
                findedElement = book;
                break;
            }
        }

        if (findedElement != null) {

            bookCollection.remove(findedElement);
            System.out.println("Zostala usunieta ksiazka : ");
            System.out.println(findedElement);
            System.out.println(collectionSize());
        } else {
            System.out.println("Nie Zostala usunieta ksiazka : ");

        }


    }

    public void removeAllBooksOfAuthor(String nameOfAuthor) {

        int amountOfRemovedBooks = 0;
        Book bookToRemove = null;


        for (Book book : bookCollection) {

            if (true == book.getAuthor().equals(nameOfAuthor)) {
                bookToRemove = book;
                amountOfRemovedBooks++;
            }
        }
        bookCollection.remove(bookToRemove);

        if (findAuthorInCollection(nameOfAuthor) == true) {
            removeAllBooksOfAuthor(nameOfAuthor);
        }
        bookCollection.remove(bookToRemove);
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


    public void showBookStore() {

        bookStorage.forEach((key, value) -> System.out.println(key + " \n szt. na magazynie: " + value + "\n"));


    }

    public void addBookToStorage(String nameOfAuthor, String title, int amountOfBooks) {
        Book bookToAdd = new Book(nameOfAuthor, title);


        if (bookStorage.containsKey(bookToAdd)) {
            bookStorage.merge(bookToAdd, amountOfBooks, Integer::sum);
            System.out.println("Zostala zwiekszona ilosc o : " + amountOfBooks);
        } else {
            bookStorage.put(bookToAdd, amountOfBooks);
            bookCollection.add(bookToAdd);
            System.out.println("Niestety nie bylo ksiazki na magazynie," +
                    " ale dodano nowa ksiazke do sprzedazy oraz kolekcji");
        }


    }

    public int returnAmountOfBooksInStore(String nameOfAuthor, String title) {
        Book bookToSell = new Book(nameOfAuthor, title);

        if (bookStorage.containsKey(bookToSell)) {
            int ret = bookStorage.get(bookToSell);

            return ret;
        } else {
            System.out.println("Nie ma takiej ksiazki na magazynie");
        }
        return 0;
    }

    public void sellBook(String nameOfAuthor, String title, int amountOfBooks) {

        Book bookToSell = new Book(nameOfAuthor, title);

        if (bookStorage.containsKey(bookToSell)) {
            int centuryAmountsBooks = bookStorage.get(bookToSell);

            if (centuryAmountsBooks > 0) {
                bookStorage.put(bookToSell, centuryAmountsBooks - amountOfBooks);
                account += 15.50 * amountOfBooks;

                System.out.println("KUPILES KSIAZKE : ");
            } else {
                System.out.println(bookToSell);
                System.out.println("Ksiazka zostala wyprzedana zapraszamy w krotce");
            }

        } else {
            System.out.println("Nie mozna sprzedac tej ksiazki, gdyz nie ma jej na magazynie");
        }
    }

    public Map<Book, Integer> returnSortedStorageInGrowing() {


        // 1. Convert Map to List of Map
        List<Map.Entry<Book, Integer>> tempList = new LinkedList<>(bookStorage.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        Collections.sort(tempList, new Comparator<Map.Entry<Book, Integer>>() {
            @Override
            public int compare(Map.Entry<Book, Integer> o1, Map.Entry<Book, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<Book, Integer> sortedMap = new LinkedHashMap<Book, Integer>();
        for (Map.Entry<Book, Integer> entry : tempList) {

            sortedMap.put(entry.getKey(), (entry.getValue()));

        }

        sortedMap.forEach((key, value) -> System.out.println(key + " \n szt. na magazynie: " + value + "\n"));

        return sortedMap;
    }


//    public void returnedStoredLessThen10SortedInGrowing () {
//
//        returnSortedStorageInGrowing().forEach((key, value) -> Math.subtractExact(value-10)(key + value));
//    }
}
