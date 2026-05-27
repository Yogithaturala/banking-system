package bankingsystem.controller;

import bankingsystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HistoryController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/history")
    public String history(Model model) {

        model.addAttribute(
                "transactions",
                transactionRepository.findAll()
        );

        return "history";
    }
}