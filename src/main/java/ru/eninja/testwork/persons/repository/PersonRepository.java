package ru.eninja.testwork.persons.repository;

import org.springframework.data.repository.CrudRepository;
import ru.eninja.testwork.persons.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
