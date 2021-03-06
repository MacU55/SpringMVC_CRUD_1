package home.example.dao;

import home.example.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PERSON_ID;
    List<Person> peopleList;

    {
        peopleList = new ArrayList<>();
        peopleList.add(new Person(++PERSON_ID, "Bob"));
        peopleList.add(new Person(++PERSON_ID, "Mike"));
        peopleList.add(new Person(++PERSON_ID, "Olga"));
        peopleList.add(new Person(++PERSON_ID, "John"));
    }

    public List<Person> index() {
        return peopleList;
    }


    public Person show(int id) {
//               Person person = peopleList.get(id);
//            return peopleList;
        return peopleList.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PERSON_ID);
        peopleList.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToUpdate = show(id);
        personToUpdate.setName(updatedPerson.getName());
    }
}
