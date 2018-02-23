package net.petriv.terminal.controller;

import net.petriv.terminal.model.Payment;
import net.petriv.terminal.model.Person;
import net.petriv.terminal.service.PersonService;
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

@RequestMapping(value = "/person")
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String userview(@PathVariable("id") Long id, Model model) {
        Person person = personService.findById(id);
        model.addAttribute("person", person);
      return "person/person";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("persons", personService.findAll());
        return "person/listPerson";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newUser(ModelAndView model) {
        Person person = new Person();
        model.addObject(person);
        model.setViewName("person/personForm");
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute Person person) {
        personService.save(person);
        return "redirect:/person/list";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeBook(@PathVariable("id") Long id) {
        personService.deleteById(id);
        return "redirect:/person/list";
    }

    @RequestMapping(value = "edit/{id}")
    public ModelAndView editUser(@PathVariable("id") Long id, ModelAndView model) {
        Person person = personService.findById(id);
        model.addObject(person);
        model.setViewName("person/editPersonForm");
        return model;
    }

    @RequestMapping(value = "/payments/{id}")
    public String payments(@PathVariable("id") Long id, Model model) {
        Person person = personService.findById(id);
        Set<Payment> payments = person.getPayments();
        model.addAttribute("person", person);
        model.addAttribute("payments", payments);
        return "person/paymentsForPerson";
    }

}
