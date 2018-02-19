package net.petriv.terminal.service;

import net.petriv.terminal.dao.PaymentDao;
import net.petriv.terminal.model.Payment;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

/**
 * Implementation of {@link PaymentService}
 *
 * @author Mykola Petriv
 * @version 1.0
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private PaymentDao paymentDao;

    @Override
    @Transactional
    public void save(Payment payment) {
        paymentDao.save(payment);
        logger.info(payment.getName() + " successfully saved");
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
        logger.info(payment.getName() + " successfully updated");
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        paymentDao.delete(id);

    }
}
