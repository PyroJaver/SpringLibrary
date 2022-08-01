package library.service;

import library.creator.PersonCreator;
import library.models.Book;
import library.models.Person;
import library.services.BooksService;
import library.services.PeopleService;
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
public class PeopleServiceTests {
    @MockBean
    private PeopleService peopleService;

    @Test
    public void checkBooksServiceIsNotNull(){
        initMocks(this);
        assertThat(peopleService).isNotNull();
    }

    @Test
    public void savePersonTest(){
        Person testPerson = PersonCreator.createTestPerson();
        peopleService.save(testPerson);
        when(peopleService.findOne(testPerson.getId())).thenReturn(testPerson);
        Person found = peopleService.findOne(testPerson.getId());

        assertThat(found).isNotNull();
        assertThat(found.getFullName()).isEqualTo(testPerson.getFullName());
        assertThat(found.getYearOfBirth()).isEqualTo(testPerson.getYearOfBirth());

    }
}
