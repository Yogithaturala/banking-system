package bankingsystem.controller;

import bankingsystem.entity.User;
import bankingsystem.entity.TransactionRecord;
import bankingsystem.repository.UserRepository;
import bankingsystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/admin")
    public String adminPage(Model model) {

        List<User> users = userRepository.findAll();
        List<TransactionRecord> transactions = transactionRepository.findAll();

        model.addAttribute("users", users);
        model.addAttribute("transactions", transactions);

        return "admin";
    }
}