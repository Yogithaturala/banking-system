package bankingsystem.service;

import bankingsystem.entity.Account;
import bankingsystem.entity.TransactionRecord;
import bankingsystem.repository.AccountRepository;
import bankingsystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    // ---------------- DEPOSIT ----------------
    public void deposit(Long accountId, Double amount) {

        if (amount == null || amount <= 0) {
            throw new RuntimeException("Invalid amount");
        }

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance() == null) {
            account.setBalance(0.0);
        }

        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }

    // ---------------- WITHDRAW ----------------
    public void withdraw(Long accountId, Double amount) {

        if (amount == null || amount <= 0) {
            throw new RuntimeException("Invalid amount");
        }

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance() == null) {
            account.setBalance(0.0);
        }

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
    }

    // ---------------- TRANSFER ----------------
    @Transactional
    public void transfer(Long senderId, Long receiverId, Double amount) {

        if (amount == null || amount <= 0) {
            throw new RuntimeException("Invalid amount");
        }

        Account sender = accountRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException("Sender account not found"));

        Account receiver = accountRepository.findById(receiverId)
                .orElseThrow(() -> new RuntimeException("Receiver account not found"));

        if (sender.getBalance() == null) sender.setBalance(0.0);
        if (receiver.getBalance() == null) receiver.setBalance(0.0);

        if (sender.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        accountRepository.save(sender);
        accountRepository.save(receiver);

        TransactionRecord tr = new TransactionRecord();
        tr.setSenderAccount(senderId);
        tr.setReceiverAccount(receiverId);
        tr.setAmount(amount);
        tr.setStatus("SUCCESS");
        tr.setTransactionTime(LocalDateTime.now());

        transactionRepository.save(tr);
    }
}