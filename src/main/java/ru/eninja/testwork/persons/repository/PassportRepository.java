package ru.eninja.testwork.persons.repository;

import org.springframework.data.repository.CrudRepository;
import ru.eninja.testwork.persons.model.Passport;

public interface PassportRepository extends CrudRepository<Passport, Long> {
}
