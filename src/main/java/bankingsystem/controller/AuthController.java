package bankingsystem.controller;

import bankingsystem.entity.User;
import bankingsystem.entity.Account;
import bankingsystem.repository.UserRepository;
import bankingsystem.repository.AccountRepository;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    // ---------------- LOGIN PAGE ----------------
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // ---------------- LOGIN PROCESS ----------------
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            model.addAttribute("error", "User not found");
            return "login";
        }

        if (user.getPassword() == null ||
                !user.getPassword().equals(password)) {

            model.addAttribute("error", "Invalid password");
            return "login";
        }

        session.setAttribute("loggedInUser", user);

        return "redirect:/dashboard";
    }

    // ---------------- SIGNUP PAGE ----------------
    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }

    // ---------------- SIGNUP PROCESS ----------------
    @PostMapping("/signup")
    public String signup(@RequestParam String name,
                         @RequestParam String email,
                         @RequestParam String password) {

        // Save user
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        userRepository.save(user);

        // Create account for user
        Account account = new Account();
        account.setUser(user);
        account.setBalance(0.0);

        accountRepository.save(account);

        return "redirect:/login";
    }

    // ---------------- LOGOUT ----------------
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}