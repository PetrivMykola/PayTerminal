package net.petriv.terminal.service;

import net.petriv.terminal.dao.PersonDao;
import net.petriv.terminal.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link PersonService}
 *
 * @author Mykola Petriv
 * @version 1.0
 */

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired()
    private PersonDao personDao;

    @Override
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    public Person findById(Long id) {
        return personDao.findOne(id);
    }

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    public void update(Person person) {
        personDao.save(person);

    }

    @Override
    public void deleteById(Long id) {
        personDao.delete(id);

    }
}
