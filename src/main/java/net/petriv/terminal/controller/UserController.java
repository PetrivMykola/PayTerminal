package net.petriv.terminal.controller;

import net.petriv.terminal.model.Payment;
import net.petriv.terminal.model.User;
import net.petriv.terminal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

/**
 * Controller for {@link net.petriv.terminal.model.User}'s pages.
 *
 * @author Mykola Petriv
 * @version 1.0
 */

@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String userview(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
      return "user";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "listUsers";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newUser(ModelAndView model) {
        User user = new User();
        model.addObject(user);
        model.setViewName("userForm");
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeBook(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "edit/{id}")
    public ModelAndView editUser(@PathVariable("id") Long id, ModelAndView model) {
        User user = userService.findById(id);
        model.addObject(user);
        model.setViewName("editUserForm");
        return model;
    }

    @RequestMapping(value = "/payments/{id}")
    public String payments(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        Set<Payment> payments = user.getPayments();
        model.addAttribute("user", user);
        model.addAttribute("payments", payments);
        return "paymentsForUser";
    }

}
