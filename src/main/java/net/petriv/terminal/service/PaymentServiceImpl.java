package net.petriv.terminal.service;

import net.petriv.terminal.dao.PaymentDao;
import net.petriv.terminal.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link PaymentService}
 *
 * @author Mykola Petriv
 * @version 1.0
 */

@Service
public class PaymentServiceImpl implements PaymentService {


    @Qualifier("paymentDao")
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public void save(Payment payment) {
        paymentDao.save(payment);

    }

    @Override
    public Payment findById(Long id) {
        return paymentDao.findOne(id);
    }

    @Override
    public List<Payment> findAll() {
        return paymentDao.findAll();
    }

    @Override
    public void update(Payment payment) {
        paymentDao.save(payment);
    }

    @Override
    public void deleteById(Long id) {
        paymentDao.delete(id);

    }
}
