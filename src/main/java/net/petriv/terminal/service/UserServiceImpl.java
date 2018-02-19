package net.petriv.terminal.service;

import net.petriv.terminal.dao.UserDao;
import net.petriv.terminal.model.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link UserService}
 *
 * @author Mykola Petriv
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired()
    private UserDao userDao;

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
        logger.info(user.getFirstName() + " successfully saved");
    }

    @Override
    @Transactional
    public User findById(Long id) {
        return userDao.findOne(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public void update(User user) {
        userDao.save(user);
        logger.info(user.getFirstName() + " successfully updated");
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userDao.delete(id);
    }
}
