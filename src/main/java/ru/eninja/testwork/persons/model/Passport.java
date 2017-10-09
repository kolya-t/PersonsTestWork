package ru.eninja.testwork.persons.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Passport extends BaseEntity {

    @ManyToOne
    @JsonIgnore
    private Person person;

    @CreatedDate
    private LocalDateTime issueDateTime;

    private Passport prevPassport;

    private String firstName;
    private String lastName;
    private LocalDate birthday;

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
}
