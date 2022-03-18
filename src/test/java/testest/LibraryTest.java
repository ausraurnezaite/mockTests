package testest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LibraryTest {

    @Mock
    private ArrayList<Book> mockedBooks;

    @InjectMocks
    private Library library;

    @Test
    public void Should_Get_Books() {
        when(mockedBooks.get(0)).thenReturn(new Book("title", 25));

        assertEquals("title", library.getBooks().get(0).getTitle());
        assertEquals(25, library.getBooks().get(0).getPages());
    }

    @Test
    public void Should_ThrowRuntimeException_When_LibraryIsEmpty() {
        when(mockedBooks.isEmpty()).thenReturn(true);

        assertThrows(RuntimeException.class, () -> library.getBookWithHighestPageCount());
    }

    @Test
    public void Should_ReturnBookWithHighestPageCount_When_LibraryHasBooks() {
        when(mockedBooks.get(0)).thenReturn(new Book("title", 25));
        when(mockedBooks.get(1)).thenReturn(new Book("mocks", 40));
        when(mockedBooks.size()).thenReturn(2);
        assertEquals("title", library.getBooks().get(0).getTitle());
        Book actual = library.getBookWithHighestPageCount();

        assertEquals(40, actual.getPages());
        assertEquals("mocks", actual.getTitle());
    }

    @Test
    public void Should_ReturnBookByItsTitle_When_LibraryHasBooks() {
        when(mockedBooks.isEmpty()).thenReturn(false);
        when(mockedBooks.size()).thenReturn(2);

        when(mockedBooks.get(0)).thenReturn(new Book("mocks", 40));
        when(mockedBooks.get(1)).thenReturn(new Book("title", 25));

        when(mockedBooks.get(0).getTitle()).thenReturn("mocks");
        when(mockedBooks.get(1).getTitle()).thenReturn("title");

        when("title".equalsIgnoreCase(mockedBooks.get(0).getTitle())).thenReturn(false);
        when("title".equalsIgnoreCase(mockedBooks.get(1).getTitle())).thenReturn(true);


        Book actual = library.findBookByTitle("title");

        assertEquals("title", actual.getTitle());
    }
}