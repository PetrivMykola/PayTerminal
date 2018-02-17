package net.petriv.terminal.service;

import net.petriv.terminal.model.Payment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for{@link net.petriv.terminal.model.Payment}
 *
 * @author Mykola Petriv
 * @version 1.0
 *
 */

@Service
@Component
public interface PaymentService {

    void save(Payment payment);

    Payment findById(Long id);

    List<Payment> findAll();

    void update (Payment payment);

    void deleteById(Long id);
}
