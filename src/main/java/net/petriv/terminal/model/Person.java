package net.petriv.terminal.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Simple JavaBean domain object that represent a Person
 *
 * @author Mykola Petriv
 * @version 1.0
 */

@Entity
@Table(name = "persons")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "person")
    private Set<Payment> payments;
}
