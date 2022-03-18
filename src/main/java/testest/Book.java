package testest;

public class Book {
    public String title;
    public int pages;

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }
}


/*
• Create a class named Book and store number of pages in the book and book title.

• Write as many unit tests as you can using mocks
 */
