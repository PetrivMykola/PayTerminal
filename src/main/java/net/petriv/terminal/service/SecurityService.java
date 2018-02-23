package net.petriv.terminal.service;

/**
 * Service for config
 *
 * @author Mykola Petriv
 * @version 1.0
 */

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
