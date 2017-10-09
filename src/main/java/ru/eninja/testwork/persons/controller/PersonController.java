package ru.eninja.testwork.persons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eninja.testwork.persons.model.Person;
import ru.eninja.testwork.persons.repository.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    }
}
