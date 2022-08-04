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

    public void save(Person person) {
        person.setId(++PERSON_ID);
        people.add(person);
    }

    public void update(int id, Person person) {
        getPerson(id).setName(person.getName());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
