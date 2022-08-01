package library.service;

import library.creator.BookCreator;
import library.models.Book;
import library.services.BooksService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BooksServiceTests {
    @MockBean
    private BooksService booksService;

    @Test
    public void checkBooksServiceIsNotNull(){
        initMocks(this);
        assertThat(booksService).isNotNull();
    }

    @Test
    public void saveBooksTest(){
        Book book = BookCreator.createTestBook();
        booksService.save(book);
        when(booksService.findOne(book.getId())).thenReturn(book);
        Book found = booksService.findOne(book.getId());

        assertThat(found).isNotNull();
        assertThat(found.getAuthor()).isEqualTo(book.getAuthor());
        assertThat(found.getTitle()).isEqualTo(book.getTitle());
        assertThat(found.getYear()).isEqualTo(book.getYear());
    }

}
