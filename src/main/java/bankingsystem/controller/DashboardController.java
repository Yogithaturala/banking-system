package bankingsystem.controller;

import bankingsystem.entity.Account;
import bankingsystem.entity.User;
import bankingsystem.repository.AccountRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session,
                            Model model) {

        User user =
                (User) session.getAttribute("loggedInUser");

        if(user == null) {
            return "redirect:/login";
        }

        // get all accounts of user

        List<Account> accounts =
                accountRepository.findAll();

        model.addAttribute("user", user);
        model.addAttribute("accounts", accounts);

        return "dashboard";
    }
}