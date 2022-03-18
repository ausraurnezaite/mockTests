package testest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListMockTest {
    @Test
    public void whenNotUsingMockAnnotation() {
        List<String> mockedList = mock(ArrayList.class);
        mockedList.add("one");
        mockedList.add("two");
        verify(mockedList, times(1)).add("one");
        verify(mockedList, times(1)).add("two");
        assertEquals(0, mockedList.size());
        when(mockedList.size()).thenReturn(100).thenReturn(45);
        assertEquals(100, mockedList.size());
        assertEquals(45, mockedList.size());
    }

    @Mock
    private List<String> mockedList;

    @Test
    public void whenUsingMockAnnotation() {
        mockedList.add("one");
        mockedList.add("two");
        verify(mockedList, times(1)).add("one");
        verify(mockedList, times(1)).add("two");
        assertEquals(0, mockedList.size());
        when(mockedList.size()).thenReturn(100).thenReturn(45);
        assertEquals(100, mockedList.size());
        assertEquals(45, mockedList.size());
    }

    @Test
    public void WhenNotUsingArgumentCaptorAnnotation() {
        List<String> mockedList = mock(ArrayList.class);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        mockedList.add("one");
        mockedList.add("two");
        verify(mockedList, times(2)).add(argumentCaptor.capture());
        assertEquals("one", argumentCaptor.getAllValues().get(0));
        assertEquals("two", argumentCaptor.getAllValues().get(1));
    }

    @Mock
    List<String> mockedListAnnotation;
    @Captor
    ArgumentCaptor<String> argumentCaptor;

    @Test
    public void WhenUsingArgumentCaptorAnnotation() {
        mockedListAnnotation.add("one");
        mockedListAnnotation.add("two");
        verify(mockedList, times(2)).add(argumentCaptor.capture());
        assertEquals("one", argumentCaptor.getAllValues().get(0));
        assertEquals("two", argumentCaptor.getAllValues().get(1));
    }

    @Mock
    private Map<String, String> wordMap;
    @InjectMocks
    private MyDictionary dictionary;

    @Test
    public void injectMocks() {
        when(wordMap.get("aWord")).thenReturn("aMeaning");
        assertEquals("aMeaning", dictionary.getMeaning("aWord"));
        when(wordMap.get(any(String.class))).thenReturn("anything");
        assertEquals("anything", dictionary.getMeaning(" "));
    }
}
