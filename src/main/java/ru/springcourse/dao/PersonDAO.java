package ru.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PERSON_ID;

    {
        people = new ArrayList<>();

        people.add(new Person(++PERSON_ID, "Zilya"));
        people.add(new Person(++PERSON_ID, "Nick"));
    }

    public List<Person> getList() {
        return people;
    }

    public Person getPerson(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
