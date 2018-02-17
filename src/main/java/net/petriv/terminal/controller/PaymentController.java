package net.petriv.terminal.controller;

import net.petriv.terminal.model.Payment;
import net.petriv.terminal.model.User;
import net.petriv.terminal.service.PaymentService;
import net.petriv.terminal.service.PaymentServiceImpl;
import net.petriv.terminal.service.UserService;
import net.petriv.terminal.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Controller for {@link net.petriv.terminal.model.Payment}'s pages.
 *
 * @author Mykola Petriv
 * @version 1.0
 */

@RequestMapping("/payment")
@Controller
public class PaymentController {

    @Autowired
    PaymentService paymentService;


    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Payment> payments = paymentService.findAll();
        model.addAttribute("payments", payments);
        return "listPayments";
    }

    @RequestMapping("/remove/{id}")
    public String removePayment(@PathVariable("id") Long id) {
        paymentService.deleteById(id);
        return "redirect:/payment/list";
    }

    @RequestMapping("edit/{id}")
    public ModelAndView editUser(@PathVariable("id") Long id, ModelAndView model) {
        List<User> userList = userService.findAll();
        Payment payment = paymentService.findById(id);
        model.addObject("userList", userList);
        model.addObject(payment);
        model.setViewName("editPaymentForm");
        return model;
    }

    @RequestMapping("/new")
    public ModelAndView newPayment(ModelAndView model) {
        Payment payment = new Payment();
        List<User> userList = userService.findAll();
        model.addObject("userList", userList);
        model.addObject(payment);
        model.setViewName("paymentForm");
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute Payment payment, @RequestParam("userId") String id) {
        User user = userService.findById(Long.parseLong(id));
        payment.setUser(user);
        paymentService.save(payment);
        return "redirect:/payment/list";
    }
}
