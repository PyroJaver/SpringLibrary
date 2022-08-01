package library.creator;

import library.models.Person;

public class PersonCreator {
    public static final String FULL_NAME = "TestName";
    public static final int YEAR_OF_BIRTH = 2000;

    public static Person createTestPerson(){
        Person testPerson = new Person();
        testPerson.setFullName(FULL_NAME);
        testPerson.setYearOfBirth(YEAR_OF_BIRTH);
        return testPerson;
    }

}
