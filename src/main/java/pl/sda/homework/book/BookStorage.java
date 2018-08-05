package pl.sda.homework.book;

import pl.sda.homework.account.Account;

import java.util.*;


public class BookStorage {
    private Map<Book, Integer> bookStorage; //Storage : Key - book , Integer - amount of books
    private Account account;

    public BookStorage() {

        bookStorage = new HashMap<>();
    }

    public void setBookStorage(Map<Book,Integer> bookStorage) {
        this.bookStorage = bookStorage;
    }

    public void showBookStore() {
        bookStorage.forEach((key, value) -> System.out.println(key + " \n szt. na magazynie: " + value + "\n"));

    }

    public int bookStorageSize() {
        return bookStorage.size();
    }

    public void addBook(Book bookToAdd, int amountOfBooks) {
        bookStorage.put(bookToAdd, amountOfBooks);
    }

    public void addBookToStorage(String nameOfAuthor, String title, int amountOfBooks) {
        Book bookToAdd = new Book(nameOfAuthor, title);


        if (bookStorage.containsKey(bookToAdd)) {
            bookStorage.merge(bookToAdd, amountOfBooks, Integer::sum);
            System.out.println("Zostala zwiekszona ilosc o : " + amountOfBooks);
        } else {

            bookStorage.put(bookToAdd, amountOfBooks);
//            bookCollection.add(bookToAdd);
//            System.out.println("Niestety nie bylo ksiazki na magazynie," +
//                    " ale dodano nowa ksiazke do sprzedazy oraz kolekcji");
            System.out.println("Nie ma ksiazki na magazynie");
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
                account.addMoneyToAccount(15.50 * amountOfBooks);

                System.out.println("KUPILES KSIAZKE : " + bookToSell);
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

