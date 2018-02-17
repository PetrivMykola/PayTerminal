package net.petriv.terminal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = "/listUsers")
    public String listUsers() {
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/listPayments")
    public String listPayments() {
        return "redirect:/payment/list";
    }
}
