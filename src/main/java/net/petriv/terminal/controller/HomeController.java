package net.petriv.terminal.controller;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/", "home"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String homePage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user.getUsername());
        return "home";
    }

    @RequestMapping(value = "/listPersons")
    public String listUsers() {
        return "redirect:/person/list";
    }

    @RequestMapping(value = "/listPayments")
    public String listPayments() {
        return "redirect:/payment/list";
    }

}

