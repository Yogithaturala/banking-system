package bankingsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private Double balance = 0.0;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}