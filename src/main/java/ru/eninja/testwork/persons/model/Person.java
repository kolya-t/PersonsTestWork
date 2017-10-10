package ru.eninja.testwork.persons.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class Person extends BaseEntity {

    @JsonIgnore
    @OneToMany(mappedBy = "person")
    private Set<Passport> passports = new HashSet<>();
}
