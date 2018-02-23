package net.petriv.terminal.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Simple JavaBean object that represent role of the {@link User}
 *
 * @author Mykola Petriv
 * @version 1.0
 */

@Entity
@Table(name = "roles")
@Data
@EqualsAndHashCode(exclude={"users"})
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "role")
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
