package net.petriv.terminal.model;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.util.Set;

/**
 * Simple JavaBean domain object that represent a User
 *
 * @author Mykola Petriv
 * @version 1.0
 */

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username", unique = true)
    @NotEmpty
    private String username;

    @Column(name = "password", unique = true)
    @NotEmpty
    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id" ),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
