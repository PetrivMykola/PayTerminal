package net.petriv.terminal.dao;

import net.petriv.terminal.model.Payment;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentDao extends JpaRepository<Payment, Long> {
}
