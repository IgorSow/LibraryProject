package pl.sda.homework.book;



import java.util.*;

public class BookCollection {

    private Set<Book> bookCollection;

    public BookCollection() {

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
    }
    public Set<Book> getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(Set<Book> bookCollection) {
        this.bookCollection = bookCollection;
    }


    public void addBook(Book book) {
        //dodać książkę do kolekcji
        bookCollection.add(book);
//        bookStorage.put(book, 0);
//        // TODO dla chętnych - jesli dodajemy do kolekcji książek nową pozycje
//        // to w magazynie powinna pojawić się taka z ilością 0.

        System.out.println("Dodano nową książkę do kolekcji: " + book);
    }

    public int collectionSize() { // metoda pomocna do junitów - nie potrzebna do działania programu
        return bookCollection.size();
    }

    public void showBookCollection() {
//        bookCollection.forEach(System.out::println); //->> java 8 lambda skrócona
//        bookCollection.forEach(book -> System.out.println(book));// ->> java 8 lambda
        for (Book book : bookCollection) { // pętla foreach -> iterujemy każdy element, ale nie mamy wiedzy która jest to iteracja
            System.out.println(book);

        }
    }

    public void addBookToCollection(Book book) {
        //dodać książkę do kolekcji
        bookCollection.add(book);
//        bookStorage.put(book, 0);
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

    public List<Book> returnAuthorsCollectionsSortedByOption(String nameOfAuthor, List<Book> orderOfList) {
        List<Book> tempCollections = new ArrayList<>();
        List<Book> ret = new ArrayList<>();

        tempCollections.addAll(orderOfList);


        for (int i = 0; i < tempCollections.size(); i++) {

            if (tempCollections.get(i).getAuthor().equalsIgnoreCase(nameOfAuthor)) {

                ret.add(tempCollections.get(i));
            }
        }
        return ret;
    }

    public List<Book> returnBooksContainsTitle(String titleToFind){
        List<Book> cloneOfOurCollection = new ArrayList<>();
        List<Book> ret = new ArrayList<>();

        cloneOfOurCollection.addAll(bookCollection);

        for (int i =0 ; i < cloneOfOurCollection.size(); i++) {

            if (cloneOfOurCollection.get(i).getTitle().contains(titleToFind)){
                ret.add(cloneOfOurCollection.get(i));
            }

        }
        return ret;
    }

}
