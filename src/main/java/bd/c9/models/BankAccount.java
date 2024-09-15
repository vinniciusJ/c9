package bd.c9.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "bank_account")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class BankAccount {
    @Id
    private String accountNumber;

    private LocalDate openingDate;

    @ManyToOne
    private Agency agencyAccount;

    @ManyToOne
    private AccountType accountType;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "bankAccount", fetch = FetchType.EAGER)
    private List<BankAccountTransaction> transactions;

    @Transient
    public Double getBalance() {
        return transactions.stream()
                .mapToDouble(transaction ->
                        transaction.getTransactionType().getPaymentMethod() == PaymentMethod.CREDIT ? transaction.getAmount() : (transaction.getAmount() * -1)
                ).sum();
    }
}
