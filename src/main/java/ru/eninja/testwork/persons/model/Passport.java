package ru.eninja.testwork.persons.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Passport extends BaseEntity {

    @ManyToOne
    private Person person;

    @CreatedDate
    private LocalDate issueDate;

    @OneToOne
    private Passport prevPassport;

    private String firstName;

    private String lastName;

    private LocalDate birthday;

    private boolean valid = true;

    public Passport(Person person, String firstName, String lastName, LocalDate birthday) {
        this.person = person;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public Passport(Person person, Passport prevPassport, String firstName, String lastName, LocalDate birthday) {
        this.person = person;
        this.prevPassport = prevPassport;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public void invalidate() {
        valid = false;
    }
}
