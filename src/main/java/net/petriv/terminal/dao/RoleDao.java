package net.petriv.terminal.dao;

import net.petriv.terminal.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface RoleDao extends JpaRepository<Role, Long> {
}
