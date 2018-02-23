package net.petriv.terminal.service;

import net.petriv.terminal.dao.RoleDao;
import net.petriv.terminal.dao.UserDao;
import net.petriv.terminal.model.Role;
import net.petriv.terminal.model.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Autowired
    private RoleDao roleDao;

    @Autowired
    public PasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne (1L));
        userDao.save(user);
        logger.info(user.getUsername() + " successfully saved");
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
        logger.info(user.getUsername()+ " successfully updated");
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userDao.delete(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
