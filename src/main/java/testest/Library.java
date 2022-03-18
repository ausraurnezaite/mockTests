package testest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public Book getBookWithHighestPageCount() {
        if (books.isEmpty()) {
            throw new RuntimeException();
        }
        Book bookWithHighestPageCount = books.get(0);
        for (int i = 1; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getPages() > bookWithHighestPageCount.getPages()) {
                bookWithHighestPageCount = book;
            }
        }
        return bookWithHighestPageCount;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public int amountOfBooks() {
        return books.size();
    }


    public Book findBookByTitle(String title) {
        if (books.isEmpty()) {
            throw new RuntimeException();
        }

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (title.equalsIgnoreCase(book.getTitle())) {
                return book;
            }
        }
        throw new RuntimeException();
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}


/*
• Create class called Library with a list of books.
    -Create methods to get all books,
    -to get the number of books in the library and
    -a method to find a book by its title lastly
    -method to get the book with the highest number of pages.
 */