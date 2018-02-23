package net.petriv.terminal.model;

import lombok.*;

import javax.persistence.*;

/**
 * Simple JavaBean domain object that represent a Payment
 *
 * @author Mykola Petriv
 * @version 1.0
 */

@Entity
@Table(name = "payments")
@Data
@EqualsAndHashCode(exclude={"person"})
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "amount")
    private Long amount;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
