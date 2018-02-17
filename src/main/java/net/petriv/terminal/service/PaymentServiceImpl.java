package net.petriv.terminal.service;

import net.petriv.terminal.dao.PaymentDao;
import net.petriv.terminal.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link PaymentService}
 *
 * @author Mykola Petriv
 * @version 1.0
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    @Transactional
    public void save(Payment payment) {
        paymentDao.save(payment);

    }

    @Override
    @Transactional
    public Payment findById(Long id) {
        return paymentDao.findOne(id);
    }

    @Override
    @Transactional
    public List<Payment> findAll() {
        return paymentDao.findAll();
    }

    @Override
    @Transactional
    public void update(Payment payment) {
        paymentDao.save(payment);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        paymentDao.delete(id);

    }
}
