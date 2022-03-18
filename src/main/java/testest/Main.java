package testest;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Library library = new Library(new ArrayList<Book>());
        String book1title = "Book1";
        int book1pages = 30;
        Book book1 = new Book(book1title, book1pages);
        library.addBook(book1);
        library.addBook(new Book("book2", 50));

        System.out.println(library.getBooks());
        System.out.println("Amount of books:  "+library.amountOfBooks());
        System.out.println("Highest Page Count:  " +library.getBookWithHighestPageCount());
        System.out.println("Find book with title 'Book1':  " +library.findBookByTitle(book1title));
    }
}
