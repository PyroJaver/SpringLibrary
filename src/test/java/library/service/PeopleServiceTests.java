package library.service;

import library.creator.PersonCreator;
import library.models.Person;
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
    public void PeopleServiceIsNotNullTest(){
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
    @Test
    public void deletePersonTest(){
        Person testPerson = PersonCreator.createTestPerson();
        peopleService.save(testPerson);
        peopleService.delete(testPerson.getId());

        Person found = peopleService.findOne(testPerson.getId());

        assertThat(found).isNull();
    }

    @Test
    public void editPersonTest(){
        Person testPerson = PersonCreator.createTestPerson();
        Person newTestPerson = PersonCreator.createTestPerson();
        newTestPerson.setYearOfBirth(2001);
        newTestPerson.setFullName("Mikhail Plesovskikh");

        peopleService.save(testPerson);
        peopleService.update(testPerson.getId(), newTestPerson);

        when(peopleService.findOne(testPerson.getId())).thenReturn(newTestPerson);
        Person found = peopleService.findOne(newTestPerson.getId());

        assertThat(found).isNotNull();
        assertThat(found.getFullName()).isEqualTo("Mikhail Plesovskikh");
        assertThat(found.getYearOfBirth()).isEqualTo(2001);
    }
}
