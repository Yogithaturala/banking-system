package bankingsystem.controller;

import bankingsystem.entity.User;
import bankingsystem.service.AccountService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    // ---------------- DEPOSIT ----------------

    @PostMapping("/deposit")
    public String deposit(@RequestParam Long accountId,
                          @RequestParam Double amount) {

        accountService.deposit(accountId, amount);

        return "redirect:/dashboard";
    }

    // ---------------- WITHDRAW ----------------

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam Long accountId,
                           @RequestParam Double amount,
                           @RequestParam String password,
                           HttpSession session,
                           Model model) {

        User user = (User) session.getAttribute("loggedInUser");

        if(user == null) {
            return "redirect:/login";
        }

        // password validation

        if(!user.getPassword().equals(password)) {

            model.addAttribute("withdrawError", "Wrong Password");

            return "dashboard";
        }

        accountService.withdraw(accountId, amount);

        return "redirect:/dashboard";
    }

    // ---------------- TRANSFER ----------------

    @PostMapping("/transfer")
    public String transfer(@RequestParam Long senderId,
                           @RequestParam Long receiverId,
                           @RequestParam Double amount,
                           @RequestParam String password,
                           HttpSession session,
                           Model model) {

        User user = (User) session.getAttribute("loggedInUser");

        // user not logged in

        if (user == null) {
            return "redirect:/login";
        }

        // password check

        if (!user.getPassword().equals(password)) {

            model.addAttribute("error", "Wrong Password");

            return "transfer";
        }

        // transfer money

        accountService.transfer(senderId, receiverId, amount);

        return "redirect:/dashboard";
    }
}