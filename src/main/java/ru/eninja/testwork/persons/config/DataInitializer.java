package ru.eninja.testwork.persons.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.eninja.testwork.persons.model.Passport;
import ru.eninja.testwork.persons.model.Person;
import ru.eninja.testwork.persons.repository.PassportRepository;
import ru.eninja.testwork.persons.repository.PersonRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PassportRepository passportRepository;

    @Override
    public void run(String... args) throws Exception {
        Person person = new Person();
        personRepository.save(person);

        Passport passport = new Passport(person, "Иван", "Иванов", LocalDate.of(1990, Month.JULY, 23));
        Passport internationalPassport = new Passport(person, "Ivan", "Ivanov", passport.getBirthday());

        passportRepository.save(Arrays.asList(passport, internationalPassport));
    }
}
