package net.petriv.terminal.service;

import net.petriv.terminal.model.Person;
import net.petriv.terminal.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for{@link Person}
 *
 * @author Mykola Petriv
 * @version 1.0
 *
 */

@Service
@Component
public interface PersonService {

    void save(Person person);

    Person findById(Long id);

    List<Person> findAll();

    void update (Person person);

    void deleteById(Long id);

}