package ru.eninja.testwork.persons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.eninja.testwork.persons.model.Passport;
import ru.eninja.testwork.persons.repository.PassportRepository;

import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/passports")
public class PassportController {

    @Autowired
    private PassportRepository passportRepository;

    @GetMapping("/search")
    public Iterable<Passport> searchPassports(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthday,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate issueDate,
            @RequestParam(required = false) Boolean valid,
            @RequestParam(required = false) Long personId
    ) {
        return passportRepository.findAll((root, qr, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (firstName != null) {
                predicates.add(cb.equal(cb.lower(root.get("firstName")), firstName.toLowerCase()));
            }
            if (lastName != null) {
                predicates.add(cb.equal(cb.lower(root.get("lastName")), lastName.toLowerCase()));
            }
            if (birthday != null) {
                predicates.add(cb.equal(root.get("birthday"), birthday));
            }
            if (issueDate != null) {
                predicates.add(cb.equal(root.get("issueDate"), issueDate));
            }
            if (valid != null) {
                predicates.add(cb.equal(root.get("valid"), valid));
            }
            if (personId != null) {
                predicates.add(cb.equal(root.get("person").get("id"), personId));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        });
    }
}
