package bd.c9.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "bank_account_transaction")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class BankAccountTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate transactionDate;

    private Double amount;

    private String note;

    @ManyToOne
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "bank_account_account_number")
    private BankAccount bankAccount;
}
