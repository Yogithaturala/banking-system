package bankingsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class TransactionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long senderAccount;
    private Long receiverAccount;
    private Double amount;
    private String status;
    private LocalDateTime transactionTime = LocalDateTime.now();
}